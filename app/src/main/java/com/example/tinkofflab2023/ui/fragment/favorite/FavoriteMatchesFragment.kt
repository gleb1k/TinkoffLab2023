package com.example.tinkofflab2023.ui.fragment.favorite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.core.delegateadapter.CompositeDelegateAdapter
import com.example.tinkofflab2023.data.local.entity.toResponse
import com.example.tinkofflab2023.data.local.entity.toSearchResponse
import com.example.tinkofflab2023.databinding.FragmentFavoriteMatchesBinding
import com.example.tinkofflab2023.di.Screens
import com.example.tinkofflab2023.domain.usecase.match.GetFavoriteMatchesUseCase
import com.example.tinkofflab2023.domain.usecase.player.GetFavoritePlayersUseCase
import com.example.tinkofflab2023.ui.fragment.search.adapter.SearchMatchDelegateAdapter
import com.example.tinkofflab2023.ui.util.ViewModifier
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class FavoriteMatchesFragment : Fragment(R.layout.fragment_favorite_matches) {

    private var binding: FragmentFavoriteMatchesBinding? = null

    private var adapter: CompositeDelegateAdapter? = null

    @Inject
    lateinit var getFavoriteMatchesUseCase : GetFavoriteMatchesUseCase

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var viewModifier: ViewModifier

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = CompositeDelegateAdapter(
            SearchMatchDelegateAdapter(
                viewModifier,
                ::onMatchClick
            )
        )
    }

    override fun onResume() {
        super.onResume()
        swapAdapterData()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFavoriteMatchesBinding.bind(view)

        binding?.run {
            swipeRefreshLayout.setOnRefreshListener {
                swapAdapterData()
                swipeRefreshLayout.isRefreshing = false
            }

            rvMatches.layoutManager = LinearLayoutManager(context)
            rvMatches.adapter = adapter

            swapAdapterData()
        }
    }

    private fun swapAdapterData() {
        lifecycleScope.launch {
            adapter?.swapData(
                getFavoriteMatchesUseCase()?.map { it.toResponse() }
                    ?: listOf())
        }
    }

    private fun onMatchClick(matchId: String) {
        router.navigateTo(Screens.Match(matchId))
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}
