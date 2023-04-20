package com.example.tinkofflab2023.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.databinding.FragmentTestBinding
import com.example.tinkofflab2023.di.DataContainer

class TestFragment : Fragment(R.layout.fragment_test) {

    private var binding: FragmentTestBinding? = null

    private val getMatchUseCase = DataContainer.getMatchUseCase

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTestBinding.bind(view)

//        try {
//            lifecycleScope.launch {
//                binding?.tvTest?.text = getMatchUseCase(Constants.MATCH_TEST_ID).toString()
//            }
//        } catch (ex: Throwable) {
//            Log.e("testEx", ex.message.toString())
//        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
