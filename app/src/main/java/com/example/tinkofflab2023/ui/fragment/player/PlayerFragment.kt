package com.example.tinkofflab2023.ui.fragment.player

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.core.ActivityToolBar
import com.example.tinkofflab2023.core.util.showSnackbar
import com.example.tinkofflab2023.databinding.FragmentPlayerBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlayerFragment : Fragment(R.layout.fragment_player) {

    private var binding: FragmentPlayerBinding? = null

    private var accountId: String = ""

    private var isFavorite: Boolean? = null

    private val viewModel: PlayerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.getString(ACCOUNT_ID_TAG)?.let {
            accountId = it
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpToolBar()
        viewModel.getFavoriteState(accountId)
        binding = FragmentPlayerBinding.bind(view)

        viewModel.isFavorite.observe(viewLifecycleOwner) {
            isFavorite = it
        }
        val tabLayout = binding!!.tabLayout
        val viewPager = binding!!.viewPager
        viewPager.adapter = PlayerPagerAdapter(requireActivity(), accountId)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.overview)
                1 -> tab.text = getString(R.string.matches)
                else -> tab.text = getString(R.string.heroes)
            }
        }.attach()
    }

    //todo как красиво сделать? я не успеваю получить ответ от бд, а менюшка уже создалась, поэтому не отображается иконка
    private fun setUpToolBar() {
        val menuHost: MenuHost = requireActivity().also {
            if (it is ActivityToolBar) {
                it.changeToolBarTitle("${getString(R.string.player)} $accountId")
            }
        }
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.top_app_bar_heart, menu)
                val heartItem = menu.findItem(R.id.action_heart)
                if (isFavorite == true) {
                    heartItem.icon = ResourcesCompat.getDrawable(
                        requireActivity().resources,
                        R.drawable.favorite_fill_40,
                        null
                    )
                } else {
                    heartItem.icon = ResourcesCompat.getDrawable(
                        requireActivity().resources,
                        R.drawable.favorite_40,
                        null
                    )
                }
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    R.id.action_more -> binding?.root?.showSnackbar("sdfsfd")
                    R.id.action_heart -> {
                        onFavoriteClick(menuItem)
                    }
                }
                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

    }

    private fun onFavoriteClick(menuItem: MenuItem) {
        if (isFavorite == false) {
            menuItem.icon = ResourcesCompat.getDrawable(
                requireActivity().resources,
                R.drawable.favorite_fill_40,
                null
            )
            viewModel.favorite(accountId, isFavorite ?: false)
            binding?.root?.showSnackbar(getString(R.string.added_to_favorites))
        } else {
            menuItem.icon = ResourcesCompat.getDrawable(
                requireActivity().resources,
                R.drawable.favorite_40,
                null
            )
            viewModel.favorite(accountId, isFavorite ?: true)
            binding?.root?.showSnackbar(getString(R.string.removed_from_favorites))
        }
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
