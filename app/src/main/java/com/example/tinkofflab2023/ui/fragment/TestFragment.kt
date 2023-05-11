package com.example.tinkofflab2023.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.databinding.FragmentTestBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TestFragment : Fragment(R.layout.fragment_test) {

    private var binding: FragmentTestBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTestBinding.bind(view)

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
