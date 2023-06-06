package com.example.tinkofflab2023.ui.fragment.player.overview

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.core.delegateadapter.CompositeDelegateAdapter
import com.example.tinkofflab2023.databinding.FragmentPlayerOverviewBinding
import com.example.tinkofflab2023.di.Screens
import com.example.tinkofflab2023.ui.fragment.player.adapter.HeroDelegateAdapter
import com.example.tinkofflab2023.ui.fragment.player.adapter.MatchDelegateAdapter
import com.example.tinkofflab2023.ui.fragment.player.adapter.PlayerHeaderDelegateAdapter
import com.example.tinkofflab2023.ui.fragment.player.adapter.TextCenterDelegateAdapter
import com.example.tinkofflab2023.ui.util.ViewModifier
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PlayerOverviewFragment : Fragment(R.layout.fragment_player_overview) {

    private var binding: FragmentPlayerOverviewBinding? = null

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var viewModifier: ViewModifier

    private var adapter: CompositeDelegateAdapter? = null

    private val viewModel: PlayerOverviewViewModel by viewModels()

    private var accountId: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val glide = Glide.with(this)

        adapter = CompositeDelegateAdapter(
            TextCenterDelegateAdapter(),
            PlayerHeaderDelegateAdapter(viewModifier, glide),
            MatchDelegateAdapter(viewModifier, glide, ::onMatchClick),
            HeroDelegateAdapter(viewModifier, glide)
        )

        arguments?.getString(ACCOUNT_ID_TAG)?.let {
            accountId = it
        }
        viewModel.loadData(accountId)
    }


    private fun onMatchClick(matchId: String) {
        router.navigateTo(Screens.Match(matchId))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPlayerOverviewBinding.bind(view)

        binding?.run {
            swipeRefreshLayout.setOnRefreshListener {
                viewModel.refreshData(accountId)
            }

            rvOverview.layoutManager = LinearLayoutManager(context)
            rvOverview.adapter = adapter

            viewModel.refreshing.observe(viewLifecycleOwner) {
                swipeRefreshLayout.isRefreshing = it
            }
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


    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    companion object {

        const val ACCOUNT_ID_TAG = "ACCOUNT_ID_TAG"

        fun newInstance(message: String, tag: String = ACCOUNT_ID_TAG) =
            PlayerOverviewFragment().apply {
                arguments = Bundle().apply {
                    putString(tag, message)
                }
            }
    }
}
