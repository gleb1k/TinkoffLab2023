package com.example.tinkofflab2023.presentation.fragment.player

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tinkofflab2023.presentation.fragment.player.overview.PlayerOverviewFragment

class PlayerPagerAdapter(
    fragmentActivity: FragmentActivity,
    private val accountId: String
) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PlayerOverviewFragment(accountId)
            1 -> PlayerMatchesFragment()
            else -> PlayerHeroesFragment()
        }
    }
}
