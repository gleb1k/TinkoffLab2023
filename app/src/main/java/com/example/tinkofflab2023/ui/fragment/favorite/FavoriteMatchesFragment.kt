package com.example.tinkofflab2023.ui.fragment.favorite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.core.delegateadapter.CompositeDelegateAdapter
import com.example.tinkofflab2023.data.Constants
import com.example.tinkofflab2023.databinding.FragmentFavoriteMatchesBinding
import com.example.tinkofflab2023.di.NavigationContainer
import com.example.tinkofflab2023.ui.fragment.search.adapter.SearchMatchDelegateAdapter

class FavoriteMatchesFragment : Fragment(R.layout.fragment_favorite_matches) {

    private var binding: FragmentFavoriteMatchesBinding? = null

    private var adapter: CompositeDelegateAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = CompositeDelegateAdapter(
            SearchMatchDelegateAdapter(
                ::onMatchClick
            )
        )
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFavoriteMatchesBinding.bind(view)

        binding?.run {
            rvMatches.layoutManager = LinearLayoutManager(context)
            rvMatches.adapter = adapter

            adapter?.swapData(Constants.favoriteMatches)


        }
    }

    private fun onMatchClick(matchId: String) {
        NavigationContainer.router.navigateTo(NavigationContainer.Match(matchId))
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}
