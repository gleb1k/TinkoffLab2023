package com.example.tinkofflab2023.presentation.fragment

import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.databinding.FragmentSearchBinding
import com.example.tinkofflab2023.presentation.viewmodel.SearchViewModel
import com.example.tinkofflab2023.presentation.recyclerview.SearchPlayersAdapter

class SearchFragment : Fragment(R.layout.fragment_search) {

    private var binding: FragmentSearchBinding? = null
    private var searchAdapter: SearchPlayersAdapter? = null

    private val searchViewModel: SearchViewModel by viewModels {
        SearchViewModel.Factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSearchBinding.bind(view)
        val glide = Glide.with(this@SearchFragment)

        searchAdapter = SearchPlayersAdapter(
            glide,
            onItemClick = :: navigate
        ).also { adapter ->
            searchViewModel.playersList.observe(viewLifecycleOwner){
                if (it == null) return@observe
                adapter.submitList(it)
            }
            binding?.rvPlayers?.adapter = adapter
        }
        setSearchView()
    }

    private fun setSearchView() {
        binding?.run {
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
                androidx.appcompat.widget.SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(name: String?): Boolean {
                    if (!name.isNullOrEmpty()) {
                        //todo вот тут проверять на мин длину запроса?
                        //но нельзя же писать логику в фрагменте
                        searchViewModel.onSearchClick(name)
                    }
                    return true
                }

                override fun onQueryTextChange(p0: String?): Boolean {
                    return false
                }

            })
        }
    }

    //todo навигатион
    private fun navigate(accountId: Int) {

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
