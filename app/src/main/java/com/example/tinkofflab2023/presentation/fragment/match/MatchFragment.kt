package com.example.tinkofflab2023.presentation.fragment.match

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.databinding.FragmentMatchBinding
import com.example.tinkofflab2023.presentation.viewmodel.MatchViewModel
import com.example.tinkofflab2023.presentation.viewmodel.SearchViewModel

class MatchFragment(
    private val matchId : String
) : Fragment(R.layout.fragment_match) {

    private var binding: FragmentMatchBinding? = null


    private val matchViewModel: MatchViewModel by viewModels {
        MatchViewModel.Factory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMatchBinding.bind(view)

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
