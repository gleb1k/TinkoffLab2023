package com.example.tinkofflab2023.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.data.Constants
import com.example.tinkofflab2023.data.DotaRepositoryImpl
import com.example.tinkofflab2023.databinding.FragmentMainBinding
import com.example.tinkofflab2023.di.DataContainer
import com.example.tinkofflab2023.domain.DotaRepository
import kotlinx.coroutines.launch

class MainFragment : Fragment(R.layout.fragment_main) {

    private var binding: FragmentMainBinding? = null

    //todo
    private val dotaRep: DotaRepositoryImpl = DotaRepositoryImpl(DataContainer.dotaApi)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        lifecycleScope.launch {
            binding?.tvTest?.text = dotaRep.getMatch(Constants.test_id).toString()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
