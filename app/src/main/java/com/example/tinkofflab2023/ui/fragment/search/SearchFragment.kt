package com.example.tinkofflab2023.ui.fragment.search

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.core.ActivityToolBar
import com.example.tinkofflab2023.core.delegateadapter.CompositeDelegateAdapter
import com.example.tinkofflab2023.databinding.FragmentSearchBinding
import com.example.tinkofflab2023.di.NavigationContainer
import com.example.tinkofflab2023.ui.fragment.search.adapter.SearchMatchDelegateAdapter
import com.example.tinkofflab2023.ui.fragment.search.adapter.SearchPlayerDelegateAdapter
import com.example.tinkofflab2023.core.utils.showSnackbar
import com.github.terrakok.cicerone.Router


class SearchFragment : Fragment(R.layout.fragment_search) {

    private var binding: FragmentSearchBinding? = null

    private val router: Router = NavigationContainer.router

    private var adapter: CompositeDelegateAdapter? = null

    private val viewModel: SearchViewModel by viewModels {
        SearchViewModel.Factory
    }

    //todo ?
    fun onBackPressed() {
        router.exit()
    }

    private fun setUpToolBar() {

        val menuHost: MenuHost = requireActivity().also {
            if (it is ActivityToolBar){
                it.changeToolBarTitle("Search")
            }
        }

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.top_app_bar, menu)
                menu.findItem(R.id.action_heart).isVisible = false
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    R.id.action_more -> binding?.root?.showSnackbar("sdfsfd")
                }
                return true
            }

        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val glide = Glide.with(this)

        adapter = CompositeDelegateAdapter(
            SearchMatchDelegateAdapter(onItemClick = ::onMatchClick),
            SearchPlayerDelegateAdapter(
                onItemClick = ::onPlayerClick,
                glide = glide,
                context = requireContext()
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpToolBar()

        binding = FragmentSearchBinding.bind(view)
        viewModel.error.observe(viewLifecycleOwner) {
            if (it) {
                binding?.root?.showSnackbar("Ошибка поиска")
            }
        }

        binding?.run {
            rvSearch.layoutManager = LinearLayoutManager(context)
            rvSearch.adapter = adapter

            viewModel.viewList.observe(viewLifecycleOwner) {
                if (it == null) return@observe
                rvSearch.scrollToPosition(0)
                adapter?.swapData(it)
            }

        }
        setEditText()
    }

    private fun onMatchClick(matchId: String) {
        NavigationContainer.router.navigateTo(NavigationContainer.Match(matchId))
    }

    private fun onPlayerClick(accountId: String) {
        router.navigateTo(NavigationContainer.Player(accountId))
    }

    private fun setEditText() {
        binding?.run {
            etSearch.setOnEditorActionListener { v, actionId, event ->
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    viewModel.onSearchClick(etSearch.text.toString())
                    true
                } else {
                    false
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
