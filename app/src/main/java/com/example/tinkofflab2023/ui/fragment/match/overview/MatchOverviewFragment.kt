package com.example.tinkofflab2023.ui.fragment.match.overview

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.core.ActivityToolBar
import com.example.tinkofflab2023.core.delegateadapter.CompositeDelegateAdapter
import com.example.tinkofflab2023.core.util.showSnackbar
import com.example.tinkofflab2023.data.Constants
import com.example.tinkofflab2023.databinding.FragmentMatchBinding
import com.example.tinkofflab2023.di.DataContainer
import com.example.tinkofflab2023.di.NavigationContainer
import com.example.tinkofflab2023.ui.fragment.match.overview.adapter.MatchHeaderDelegateAdapter
import com.example.tinkofflab2023.ui.fragment.match.overview.adapter.TeamHeaderDelegateAdapter
import com.example.tinkofflab2023.ui.fragment.match.overview.adapter.TeamOutcomeDelegateAdapter
import com.example.tinkofflab2023.ui.fragment.match.overview.adapter.TeamPlayerDelegateAdapter
import kotlinx.coroutines.launch

class MatchOverviewFragment : Fragment(R.layout.fragment_match) {

    private var binding: FragmentMatchBinding? = null

    private var adapter: CompositeDelegateAdapter? = null

    private val viewModel: MatchOverviewViewModel by viewModels {
        MatchOverviewViewModel.Factory
    }

    private var matchId: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val glide = Glide.with(this)

        adapter = CompositeDelegateAdapter(
            MatchHeaderDelegateAdapter(),
            TeamHeaderDelegateAdapter(),
            TeamOutcomeDelegateAdapter(),
            TeamPlayerDelegateAdapter(
                glide,
                ::onPlayerClick,
                requireContext()
            )
        )

        arguments?.getString(MATCH_ID_TAG)?.let {
            matchId = it
        }
        viewModel.loadData(matchId)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMatchBinding.bind(view)
        setUpToolBar()
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
        NavigationContainer.router.navigateTo(NavigationContainer.Player(accountId))
    }

    private fun setUpToolBar() {

        val menuHost: MenuHost = requireActivity().also {
            if (it is ActivityToolBar) {
                it.changeToolBarTitle("${getString(R.string.match)} $matchId")
            }
        }

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.top_app_bar_heart, menu)

            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    R.id.action_more -> binding?.root?.showSnackbar("sdfsfd")
                    R.id.action_heart -> addToFavorite()
                }
                return true
            }

            override fun onMenuClosed(menu: Menu) {
                super.onMenuClosed(menu)

            }

        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    //todo nasral
    private fun addToFavorite() {
        binding?.root?.showSnackbar("added to favorite")

        lifecycleScope.launch {
            DataContainer.getMatchUseCase(matchId).also {
                Constants.favoriteMatches.add(it)
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
            MatchOverviewFragment().apply {
                arguments = Bundle().apply {
                    putString(tag, message)
                }
            }
    }
}
