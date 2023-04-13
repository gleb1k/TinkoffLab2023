package com.example.tinkofflab2023.presentation.fragment.player

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.databinding.FragmentPlayerHeroesBinding

class PlayerHeroesFragment : Fragment(R.layout.fragment_player_heroes) {

    private var binding: FragmentPlayerHeroesBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPlayerHeroesBinding.bind(view)

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
