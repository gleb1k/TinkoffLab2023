package com.example.tinkofflab2023.ui.fragment.player.heroes

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.core.delegateadapter.CompositeDelegateAdapter
import com.example.tinkofflab2023.databinding.FragmentPlayerHeroesBinding
import com.example.tinkofflab2023.di.NavigationContainer
import com.example.tinkofflab2023.ui.fragment.player.overview.PlayerOverviewFragment
import com.example.tinkofflab2023.ui.fragment.player.overview.adapter.MatchDelegateAdapter

class PlayerHeroesFragment : Fragment(R.layout.fragment_player_heroes) {

    private var binding: FragmentPlayerHeroesBinding? = null

    private var adapter: CompositeDelegateAdapter? = null

//    private val viewModel:

    private var accountId: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val glide = Glide.with(this)

        adapter = CompositeDelegateAdapter(
            MatchDelegateAdapter(glide, ::onMatchClick),
        )

        arguments?.getString(PlayerOverviewFragment.ACCOUNT_ID_TAG)?.let {
            accountId = it
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
