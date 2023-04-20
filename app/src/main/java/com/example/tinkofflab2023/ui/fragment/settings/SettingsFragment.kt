package com.example.tinkofflab2023.ui.fragment.settings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment(R.layout.fragment_settings) {

    private var binding: FragmentSettingsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSettingsBinding.bind(view)

        binding?.run {
//            tvSettings.setOnClickListener {
//                NavigationContainer.router.navigateTo(NavigationContainer.Match(Constants.MATCH_TEST_ID))
//            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}


