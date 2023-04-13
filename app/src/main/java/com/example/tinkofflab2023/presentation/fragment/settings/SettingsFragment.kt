package com.example.tinkofflab2023.presentation.fragment.settings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.data.Constants
import com.example.tinkofflab2023.databinding.FragmentSettingsBinding
import com.example.tinkofflab2023.di.DataContainer

class SettingsFragment : Fragment(R.layout.fragment_settings) {

    private var binding: FragmentSettingsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSettingsBinding.bind(view)

        binding?.run {
            tvSettings.setOnClickListener {
                DataContainer.router.navigateTo(DataContainer.Match(Constants.MATCH_TEST_ID))
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}

