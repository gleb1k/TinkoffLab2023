package com.example.tinkofflab2023.ui


import android.content.Context
import android.os.Bundle
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.FragmentManager
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.core.ActivityToolBar
import com.example.tinkofflab2023.databinding.ActivityMainBinding
import com.example.tinkofflab2023.di.Screen
import com.example.tinkofflab2023.di.Screens
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ActivityToolBar {

    private var binding: ActivityMainBinding? = null

    private val navigator = AppNavigator(
        this,
        R.id.fragment_container
    )

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onBackPressedDispatcher.addCallback(this) {
            router.exit()
        }

        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        setSupportActionBar(binding?.toolbar)
        binding?.toolbar?.menu?.findItem(R.id.action_heart)?.isVisible = false

        binding?.run {
            bnvMain.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.action_settings -> {
                        router.navigateTo(Screens.Settings())
                        true
                    }

                    R.id.action_search -> {
                        router.navigateTo(Screens.Search())
                        true
                    }

                    R.id.action_favorite -> {
                        router.navigateTo(Screens.Favorite())
                        true
                    }

                    else -> false
                }
            }
            bnvMain.selectedItemId = R.id.action_search
        }
        router.navigateTo(Screens.Search())
    }

    override fun changeToolBarTitle(title: String) {
        binding?.toolbar?.title = title
    }

    override fun changeToolBar(Screen: Screen) {

    }

    override fun changeTheme(isChecked: Boolean) {
        if (isChecked) {
            // Change to dark theme
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            // Change to light theme
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
        val sharedPref = getSharedPreferences("theme", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        editor.putBoolean("is_dark_theme", isChecked)

        editor.apply()
        binding?.bnvMain?.selectedItemId = R.id.action_search
        recreate()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}
