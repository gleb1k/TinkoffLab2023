package com.example.tinkofflab2023.presentation.fragment.player

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PlayerOverviewFragment()
            1 -> PlayerMatchesFragment()
            else -> PlayerHeroesFragment()
        }
    }
}
