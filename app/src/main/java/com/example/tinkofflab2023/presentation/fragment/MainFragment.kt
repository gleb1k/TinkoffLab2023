package com.example.tinkofflab2023.presentation.fragment

import android.os.Bundle
import android.util.Log
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
import kotlin.math.log

class MainFragment : Fragment(R.layout.fragment_main) {

    private var binding: FragmentMainBinding? = null

    private val getMatchUseCase = DataContainer.getMatchUseCase

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        try {
            lifecycleScope.launch {
                binding?.tvTest?.text = getMatchUseCase(Constants.test_id).toString()
            }
        }
        catch (ex: Throwable) {
            Log.e("testEx", ex.message.toString() )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
