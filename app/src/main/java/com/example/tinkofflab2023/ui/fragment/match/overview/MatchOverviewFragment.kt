package com.example.tinkofflab2023.ui.fragment.match.overview

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.core.delegateadapter.CompositeDelegateAdapter
import com.example.tinkofflab2023.core.util.showSnackbar
import com.example.tinkofflab2023.databinding.FragmentMatchBinding
import com.example.tinkofflab2023.databinding.FragmentMatchOverviewBinding
import com.example.tinkofflab2023.di.Screens
import com.example.tinkofflab2023.ui.fragment.match.adapter.MatchHeaderDelegateAdapter
import com.example.tinkofflab2023.ui.fragment.match.adapter.TeamHeaderDelegateAdapter
import com.example.tinkofflab2023.ui.fragment.match.adapter.TeamOutcomeDelegateAdapter
import com.example.tinkofflab2023.ui.fragment.match.adapter.TeamPlayerDelegateAdapter
import com.example.tinkofflab2023.ui.util.ViewModifier
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MatchOverviewFragment : Fragment(R.layout.fragment_match_overview) {

    private var binding: FragmentMatchOverviewBinding? = null

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var viewModifier: ViewModifier

    private var adapter: CompositeDelegateAdapter? = null

    private val viewModel: MatchOverviewViewModel by viewModels()

    private var matchId: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val glide = Glide.with(this)

        adapter = CompositeDelegateAdapter(
            MatchHeaderDelegateAdapter(viewModifier),
            TeamHeaderDelegateAdapter(),
            TeamOutcomeDelegateAdapter(),
            TeamPlayerDelegateAdapter(
                viewModifier,
                glide,
                ::onPlayerClick,
            )
        )

        arguments?.getString(MATCH_ID_TAG)?.let {
            matchId = it
        }
        viewModel.loadData(matchId)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMatchOverviewBinding.bind(view)
        binding?.run {


            rvOverview.layoutManager = LinearLayoutManager(context)
            rvOverview.adapter = adapter

            viewModel.error.observe(viewLifecycleOwner) {
                tvError.text = it
            }
            viewModel.loading.observe(viewLifecycleOwner) {
                if (it == true)
                    progressBar.visibility = View.VISIBLE
                else
                    progressBar.visibility = View.GONE
            }

            viewModel.viewList.observe(viewLifecycleOwner) {
                if (it == null) return@observe
                adapter?.swapData(it)
            }
        }
    }

    private fun onPlayerClick(accountId: String?) {
        if (accountId == null) {
            binding?.root?.showSnackbar(getString(R.string.anonym))
            return
        }
        router.navigateTo(Screens.Player(accountId))
    }


    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    companion object {

        const val MATCH_ID_TAG = "MATCH_ID_TAG"

        fun newInstance(message: String, tag: String = MATCH_ID_TAG) =
            MatchOverviewFragment().apply {
                arguments = Bundle().apply {
                    putString(tag, message)
                }
            }
    }
}
