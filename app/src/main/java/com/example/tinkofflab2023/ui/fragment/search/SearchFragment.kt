package com.example.tinkofflab2023.ui.fragment.search

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.databinding.FragmentSearchBinding
import com.example.tinkofflab2023.di.NavigationContainer
import com.example.tinkofflab2023.ui.delegateadapter.CompositeDelegateAdapter
import com.example.tinkofflab2023.ui.fragment.search.adapter.SearchMatchDelegateAdapter
import com.example.tinkofflab2023.ui.fragment.search.adapter.SearchPlayerDelegateAdapter
import com.example.tinkofflab2023.utils.showSnackbar
import com.github.terrakok.cicerone.Router

class SearchFragment : Fragment(R.layout.fragment_search) {

    private var binding: FragmentSearchBinding? = null
    private val router: Router = NavigationContainer.router

    private var adapter: CompositeDelegateAdapter? = null

    private val viewModel: SearchViewModel by viewModels {
        SearchViewModel.Factory
    }

    private fun onOpenPlayerScreen(
        accountId: String
    ) {
        router.navigateTo(NavigationContainer.Player(accountId))
    }

    //todo ?
    fun onBackPressed() {
        router.exit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val glide = Glide.with(this)

        adapter = CompositeDelegateAdapter(
            SearchMatchDelegateAdapter(onItemClick = ::onMatchClick),
            SearchPlayerDelegateAdapter(
                onItemClick = ::onOpenPlayerScreen,
                glide = glide,
                context = requireContext()
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
                adapter?.swapData(it)
            }

            tvSearch.setOnClickListener {
                viewModel.onSearchClick(etSearch.text.toString())
            }
        }
        //setEditText()
    }

    private fun onMatchClick(matchId: String) {
        NavigationContainer.router.navigateTo(NavigationContainer.Match(matchId))
    }

    private fun setEditText() {
        binding?.run {
            etSearch.setOnEditorActionListener { v, actionId, event ->
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    val temp = etSearch.text.toString()
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
