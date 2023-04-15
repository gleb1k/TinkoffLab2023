package com.example.tinkofflab2023.presentation.fragment.player

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.databinding.FragmentPlayerBinding
import com.google.android.material.tabs.TabLayoutMediator

class PlayerFragment : Fragment(R.layout.fragment_player) {

    private var binding: FragmentPlayerBinding? = null
    private val playerId : String? = arguments?.getString(PLAYER_ID_TAG)

    private val textToShow: String
        get() = requireArguments().getString(PLAYER_ID_TAG)
            ?: throw IllegalArgumentException("Argument $PLAYER_ID_TAG required")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    //todo почему дергается этот фрагмент, когда навигируюсь на совершенно другие з
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPlayerBinding.bind(view)

        val tabLayout = binding!!.tabLayout
        val viewPager = binding!!.viewPager
        viewPager.adapter = PlayerPagerAdapter(requireActivity(), playerId!!)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
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

    companion object {

        const val PLAYER_ID_TAG = "PLAYER_ID_TAG"

        fun newInstance(message: String, tag: String = PLAYER_ID_TAG) = PlayerFragment().apply {
            arguments = Bundle().apply {
                putString(tag, message)
            }
        }
    }
}
