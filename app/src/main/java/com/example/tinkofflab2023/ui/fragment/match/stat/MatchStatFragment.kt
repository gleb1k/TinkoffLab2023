package com.example.tinkofflab2023.ui.fragment.match.stat

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.data.Constants
import com.example.tinkofflab2023.databinding.FragmentMatchStatBinding
import com.example.tinkofflab2023.ui.fragment.match.overview.MatchOverviewFragment
import com.example.tinkofflab2023.ui.util.ViewModifier
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MatchStatFragment : Fragment(R.layout.fragment_match_stat) {

    private var binding: FragmentMatchStatBinding? = null

    @Inject
    lateinit var viewModifier: ViewModifier

    private val viewModel: MatchStatViewModel by viewModels()

    private var matchId: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getString(MatchOverviewFragment.MATCH_ID_TAG)?.let {
            matchId = it
        }
        viewModel.loadData(matchId)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMatchStatBinding.bind(view)
        binding?.run {
            viewModel.error.observe(viewLifecycleOwner) {
                tvError.text = it
            }
            viewModel.loading.observe(viewLifecycleOwner) {
                if (it == true)
                    progressBar.visibility = View.VISIBLE
                else
                    progressBar.visibility = View.GONE
            }

            viewModel.match.observe(viewLifecycleOwner) {
                if (it == null) return@observe
                item1.tvTitle.text = getString(R.string.match_num)
                item1.tvInfo.text = it.matchItem.matchId

                item2.tvTitle.text = getString(R.string.match_result)
                item2.tvInfo.text = viewModifier.winSide(it.matchItem.radiantWin)

                item3.tvTitle.text = getString(R.string.game_mode)
                item3.tvInfo.text = Constants.gameModes[it.matchItem.gameMode].toString()

                item4.tvTitle.text = getString(R.string.lobby_type)
                item4.tvInfo.text = Constants.lobbyTypes[it.matchItem.lobbyType]

                item5.tvTitle.text = getString(R.string.region)
                try {
                    item5.tvInfo.text = Constants.regions[it.matchItem.region]
                } catch (thr: Throwable) {
                    item5.tvInfo.text = "-"
                }

                item6.tvTitle.text = getString(R.string.data)
                item6.tvInfo.text = viewModifier.epochToDate(it.matchItem.startTime)

                item7.tvTitle.text = getString(R.string.duration)
                item7.tvInfo.text = viewModifier.matchDuration(it.matchItem.duration)

                item8.tvTitle.text = getString(R.string.first_blood)
                item8.tvInfo.text = viewModifier.matchDuration(it.matchItem.firstBloodTime)

//                item9.tvTitle.text = getString(R.string.mvp)
//                item9.tvInfo.text = "хз"
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    companion object {

        const val MATCH_ID_TAG = "MATCH_ID_TAG"

        fun newInstance(message: String, tag: String = MATCH_ID_TAG) =
            MatchStatFragment().apply {
                arguments = Bundle().apply {
                    putString(tag, message)
                }
            }
    }
}
