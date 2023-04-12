package com.example.tinkofflab2023.presentation.fragment.player

import android.graphics.pdf.PdfDocument
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.databinding.FragmentPlayerBinding
import com.google.android.material.tabs.TabLayoutMediator

class PlayerFragment : Fragment(R.layout.fragment_player) {

    private var binding: FragmentPlayerBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPlayerBinding.bind(view)
        val viewPager = binding!!.viewPager
        viewPager.adapter = PagerAdapter(requireActivity())
        TabLayoutMediator(binding!!.tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Overview"
                1 -> tab.text = "Matches"
                else -> tab.text = "Heroes"
            }
        }.attach()

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}