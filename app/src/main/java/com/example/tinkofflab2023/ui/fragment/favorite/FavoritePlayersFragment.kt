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
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.core.delegateadapter.CompositeDelegateAdapter
import com.example.tinkofflab2023.data.Constants
import com.example.tinkofflab2023.databinding.FragmentFavoritePlayersBinding
import com.example.tinkofflab2023.di.NavigationContainer
import com.example.tinkofflab2023.ui.fragment.search.adapter.SearchPlayerDelegateAdapter
import com.example.tinkofflab2023.core.utils.showSnackbar

class FavoritePlayersFragment : Fragment(R.layout.fragment_favorite_players) {

    private var binding: FragmentFavoritePlayersBinding? = null
    private var adapter: CompositeDelegateAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val glide = Glide.with(this)
        adapter = CompositeDelegateAdapter(
            SearchPlayerDelegateAdapter(
                glide,
                ::onPlayerClick,
                requireContext()
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpToolBar()
        binding = FragmentFavoritePlayersBinding.bind(view)

        binding?.run {
            rvPlayers.layoutManager = LinearLayoutManager(context)
            rvPlayers.adapter = adapter

            adapter?.swapData(Constants.favoritePLayers)
        }
    }

    private fun onPlayerClick(accountId: String) {
        NavigationContainer.router.navigateTo(NavigationContainer.Player(accountId))
    }

    private fun setUpToolBar() {
        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.top_app_bar, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    R.id.action_more -> binding?.root?.showSnackbar("favortie players")
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
