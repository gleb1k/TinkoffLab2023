package com.example.tinkofflab2023.ui.fragment.player

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
import com.example.tinkofflab2023.databinding.FragmentPlayerBinding
import com.example.tinkofflab2023.utils.showSnackbar
import com.google.android.material.tabs.TabLayoutMediator

class PlayerFragment : Fragment(R.layout.fragment_player) {

    private var binding: FragmentPlayerBinding? = null

    private var accountId: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.getString(ACCOUNT_ID_TAG)?.let {
            accountId = it
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpToolBar()
        binding = FragmentPlayerBinding.bind(view)

        val tabLayout = binding!!.tabLayout
        val viewPager = binding!!.viewPager
        viewPager.adapter = PlayerPagerAdapter(requireActivity(), accountId)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Overview"
                1 -> tab.text = "Matches"
                else -> tab.text = "Heroes"
            }
        }.attach()
    }

    private fun setUpToolBar() {
        val menuHost: MenuHost = requireActivity().also {
            if (it is ActivityToolBar){
                it.changeToolBarTitle("Player $accountId")
            }
        }
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.top_app_bar, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    R.id.action_more -> binding?.root?.showSnackbar("sdfsfd")
                    R.id.action_heart -> addToFavorite()
                }
                return true
            }

        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    //todo nasral
    private fun addToFavorite() {
        binding?.root?.showSnackbar("added to favorite")
//
//        lifecycleScope.launch {
//            DataContainer.getPlayerOverviewModelUseCase(accountId).also {
//                Constants.favoritePLayers.add(it.)
//            }
//        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    companion object {

        const val ACCOUNT_ID_TAG = "ACCOUNT_ID_TAG"

        fun newInstance(message: String, tag: String = ACCOUNT_ID_TAG) = PlayerFragment().apply {
            arguments = Bundle().apply {
                putString(tag, message)
            }
        }
    }
}
