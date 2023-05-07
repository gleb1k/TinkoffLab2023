package com.example.tinkofflab2023.ui


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.core.ActivityToolBar
import com.example.tinkofflab2023.databinding.ActivityMainBinding
import com.example.tinkofflab2023.di.NavigationContainer
import com.github.terrakok.cicerone.androidx.AppNavigator

class MainActivity : AppCompatActivity(), ActivityToolBar {

    private var binding: ActivityMainBinding? = null

    private val navigator = AppNavigator(
        this,
        R.id.fragment_container
    )
    private val router = NavigationContainer.router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        setSupportActionBar(binding?.toolbar)
        binding?.toolbar?.menu?.findItem(R.id.action_heart)?.isVisible = false

        binding?.run {
            bnvMain.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.action_settings -> {
                        router.navigateTo(NavigationContainer.Settings())
                        true
                    }

                    R.id.action_search -> {
                        router.navigateTo(NavigationContainer.Search())
                        true
                    }

                    R.id.action_favorite -> {
                        router.navigateTo(NavigationContainer.Favorite())
                        true
                    }

                    else -> false
                }
            }
            bnvMain.selectedItemId = R.id.action_search
        }
        router.navigateTo(NavigationContainer.Search())
    }

    override fun changeToolBarTitle(title: String) {
        binding?.toolbar?.title = title
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        NavigationContainer.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        NavigationContainer.navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}
