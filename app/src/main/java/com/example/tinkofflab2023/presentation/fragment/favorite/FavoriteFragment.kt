package com.example.tinkofflab2023.presentation.fragment.favorite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.databinding.FragmentFavoriteBinding
import com.example.tinkofflab2023.presentation.fragment.player.PlayerPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class FavoriteFragment : Fragment(R.layout.fragment_favorite) {

    private var binding: FragmentFavoriteBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFavoriteBinding.bind(view)

        val tabLayout = binding!!.tabLayout
        val viewPager = binding!!.viewPager
        viewPager.adapter = FavoritePagerAdapter(requireActivity())

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Matches"
                else -> tab.text = "Heroes"
            }
        }.attach()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
