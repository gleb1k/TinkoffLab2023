package com.example.tinkofflab2023.ui.fragment.favorite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.core.delegateadapter.CompositeDelegateAdapter
import com.example.tinkofflab2023.data.local.entity.toSearchResponse
import com.example.tinkofflab2023.databinding.FragmentFavoritePlayersBinding
import com.example.tinkofflab2023.di.Screens
import com.example.tinkofflab2023.domain.usecase.player.GetFavoritePlayersUseCase
import com.example.tinkofflab2023.ui.fragment.search.adapter.SearchPlayerDelegateAdapter
import com.example.tinkofflab2023.ui.util.ViewModifier
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class FavoritePlayersFragment : Fragment(R.layout.fragment_favorite_players) {

    private var binding: FragmentFavoritePlayersBinding? = null

    private var adapter: CompositeDelegateAdapter? = null

    @Inject
    lateinit var getFavoritePlayersUseCase: GetFavoritePlayersUseCase

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var viewModifier: ViewModifier

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val glide = Glide.with(this)
        adapter = CompositeDelegateAdapter(
            SearchPlayerDelegateAdapter(
                viewModifier,
                glide,
                ::onPlayerClick
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFavoritePlayersBinding.bind(view)

        binding?.run {
            rvPlayers.layoutManager = LinearLayoutManager(context)
            rvPlayers.adapter = adapter

            lifecycleScope.launch {
                adapter?.swapData(
                    getFavoritePlayersUseCase()?.map { it.toSearchResponse() }
                        ?: listOf())
            }
        }
    }

    private fun onPlayerClick(accountId: String) {
        router.navigateTo(Screens.Player(accountId))
    }


    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}
