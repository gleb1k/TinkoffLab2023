package com.example.tinkofflab2023.presentation.fragment.player

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.databinding.FragmentPlayerMatchesBinding
import com.example.tinkofflab2023.databinding.FragmentPlayerOverviewBinding

class PlayerMatchesFragment : Fragment(R.layout.fragment_player_matches) {

    private var binding: FragmentPlayerMatchesBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPlayerMatchesBinding.bind(view)

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}

