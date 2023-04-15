package com.example.tinkofflab2023.presentation.fragment.match

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.databinding.FragmentMatchBinding
import com.example.tinkofflab2023.presentation.fragment.player.PlayerFragment
import com.example.tinkofflab2023.utils.Converter

class MatchFragment : Fragment(R.layout.fragment_match) {

    private var binding: FragmentMatchBinding? = null

    private val viewModel: MatchViewModel by viewModels {
        MatchViewModel.Factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadData()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMatchBinding.bind(view)

        bind()
    }

    private fun bind() {
        binding?.run {
            viewModel.match.observe(viewLifecycleOwner) {
                if (it == null) return@observe
                with(matchHeader) {
                    tvMatchId.text = "Match ${it.matchId}"
                    tvMatchTime.text = Converter.matchDuration(it.duration)
                    tvWinner.text = Converter.win(it.radiantWin)
                    tvRadiantKills.text = it.radiantScore.toString()
                    tvDireKills.text = it.direScore.toString()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    companion object {

        const val MATCH_ID_TAG = "MATCH_ID_TAG"

        fun newInstance(message: String, tag: String = MATCH_ID_TAG) = PlayerFragment().apply {
            arguments = Bundle().apply {
                putString(tag, message)
            }
        }
    }
}
