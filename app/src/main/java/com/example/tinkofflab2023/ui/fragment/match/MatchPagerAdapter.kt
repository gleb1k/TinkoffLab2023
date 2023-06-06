package com.example.tinkofflab2023.ui.fragment.match

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tinkofflab2023.ui.fragment.match.details.MatchDetailsFragment
import com.example.tinkofflab2023.ui.fragment.match.overview.MatchOverviewFragment
import com.example.tinkofflab2023.ui.fragment.match.stat.MatchStatFragment

class MatchPagerAdapter(
    fragmentActivity: FragmentActivity,
    private val matchId: String
) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MatchOverviewFragment.newInstance(matchId)
            1 -> MatchDetailsFragment.newInstance(matchId)
            else -> MatchStatFragment.newInstance(matchId)
        }
    }
}

