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
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.core.ActivityToolBar
import com.example.tinkofflab2023.core.delegateadapter.CompositeDelegateAdapter
import com.example.tinkofflab2023.core.util.showSnackbar
import com.example.tinkofflab2023.databinding.FragmentSearchBinding
import com.example.tinkofflab2023.di.Screens
import com.example.tinkofflab2023.ui.fragment.search.adapter.SearchMatchDelegateAdapter
import com.example.tinkofflab2023.ui.fragment.search.adapter.SearchPlayerDelegateAdapter
import com.example.tinkofflab2023.ui.util.ViewModifier
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.AndroidEntryPoint
import jp.wasabeef.glide.transformations.BlurTransformation
import javax.inject.Inject

@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.fragment_search) {

    private var binding: FragmentSearchBinding? = null

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var viewModifier: ViewModifier

    private var adapter: CompositeDelegateAdapter? = null

    private val viewModel: SearchViewModel by viewModels()

    private fun setUpToolBar() {

        val menuHost: MenuHost = requireActivity().also {
            if (it is ActivityToolBar) {
                it.changeToolBarTitle(getString(R.string.search))
            }
        }

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.top_app_bar_base, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
//                    R.id.action_more -> binding?.root?.showSnackbar("sdfsfd")
                }
                return true
            }

        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val glide = Glide.with(this)

        adapter = CompositeDelegateAdapter(
            SearchMatchDelegateAdapter(viewModifier, onItemClick = ::onMatchClick),
            SearchPlayerDelegateAdapter(
                viewModifier,
                onItemClick = ::onPlayerClick,
                glide = glide,
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpToolBar()
        binding = FragmentSearchBinding.bind(view)

        binding?.run {
            rvSearch.layoutManager = LinearLayoutManager(context)
            rvSearch.adapter = adapter

            viewModel.error.observe(viewLifecycleOwner) {
                if (it != null) {
                    binding?.root?.showSnackbar(it)
                }
            }

            viewModel.loading.observe(viewLifecycleOwner) {
                if (it == true)
                    progressBar.visibility = View.VISIBLE
                else
                    progressBar.visibility = View.GONE
            }

            viewModel.viewList.observe(viewLifecycleOwner) {
                if (it == null) return@observe
                rvSearch.scrollToPosition(0)
                adapter?.swapData(it)
            }
        }
        setEditText()
    }

    private fun onMatchClick(matchId: String) {
        router.navigateTo(Screens.Match(matchId))
    }

    private fun onPlayerClick(accountId: String) {
        router.navigateTo(Screens.Player(accountId))
    }

    private fun setEditText() {
        binding?.run {
            etSearch.setOnEditorActionListener { _, actionId, _ ->
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
