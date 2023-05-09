package com.example.tinkofflab2023.ui.fragment.favorite

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.core.ActivityToolBar
import com.example.tinkofflab2023.core.util.showSnackbar
import com.example.tinkofflab2023.databinding.FragmentFavoriteBinding
import com.google.android.material.tabs.TabLayoutMediator

class FavoriteFragment : Fragment(R.layout.fragment_favorite) {

    private var binding: FragmentFavoriteBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFavoriteBinding.bind(view)

        val tabLayout = binding!!.tabLayout
        val viewPager = binding!!.viewPager
        viewPager.adapter = FavoritePagerAdapter(requireActivity())

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.matches)
                else -> tab.text = getString(R.string.players)
            }
        }.attach()
        setUpToolBar()
    }

    private fun setUpToolBar() {

        val menuHost: MenuHost = requireActivity().also {
            if (it is ActivityToolBar) {
                it.changeToolBarTitle(getString(R.string.favorites))
            }
        }

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.top_app_bar_base, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    R.id.action_more -> binding?.root?.showSnackbar("sdfsfd")
                }
                return true
            }

        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
