package com.example.tinkofflab2023.ui.fragment.match

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tinkofflab2023.ui.fragment.match.details.MatchDetailsFragment
import com.example.tinkofflab2023.ui.fragment.match.overview.MatchOverviewFragment

class MatchPagerAdapter(
    fragmentActivity: FragmentActivity,
    private val matchId: String
) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MatchOverviewFragment.newInstance(matchId)
            else -> MatchDetailsFragment.newInstance(matchId)
        }
    }
}

