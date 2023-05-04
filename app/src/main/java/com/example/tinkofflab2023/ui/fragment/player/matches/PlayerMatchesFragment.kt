package com.example.tinkofflab2023.ui.fragment.player.matches

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.core.delegateadapter.CompositeDelegateAdapter
import com.example.tinkofflab2023.databinding.FragmentPlayerMatchesBinding
import com.example.tinkofflab2023.di.NavigationContainer
import com.example.tinkofflab2023.ui.fragment.player.heroes.PlayerHeroesViewModel
import com.example.tinkofflab2023.ui.fragment.player.overview.PlayerOverviewFragment
import com.example.tinkofflab2023.ui.fragment.player.overview.adapter.MatchDelegateAdapter

class PlayerMatchesFragment : Fragment(R.layout.fragment_player_matches) {

    private var binding: FragmentPlayerMatchesBinding? = null

    private var adapter: CompositeDelegateAdapter? = null

    private val viewModel: PlayerMatchesViewModel by viewModels {
        PlayerMatchesViewModel.Factory
    }

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPlayerMatchesBinding.bind(view)

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }


}

