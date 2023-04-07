package com.example.tinkofflab2023.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.databinding.ActivityMainBinding
import com.example.tinkofflab2023.di.DataContainer
import com.example.tinkofflab2023.presentation.fragment.search.SearchFragment
import com.github.terrakok.cicerone.androidx.AppNavigator

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private val navigator = AppNavigator(
        this,
        R.id.fragment_container
    )
    private val router = DataContainer.router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        binding?.run {
            bnvMain.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.action_settings -> {
                        router.navigateTo(DataContainer.Settings())
                        true
                    }
                    R.id.action_search -> {
                        router.navigateTo(DataContainer.Search())
                        true
                    }
                    R.id.action_favorite -> {
                        router.navigateTo(DataContainer.Favorite())
                        true
                    }
                    else -> false
                }
            }
        }

        supportFragmentManager.beginTransaction()
            .add(
                R.id.fragment_container,
                SearchFragment()
            )
            .commit()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        DataContainer.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        DataContainer.navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}
