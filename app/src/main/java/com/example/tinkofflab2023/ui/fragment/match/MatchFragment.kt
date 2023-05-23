package com.example.tinkofflab2023.ui.fragment.match

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
import androidx.lifecycle.lifecycleScope
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.core.ActivityToolBar
import com.example.tinkofflab2023.core.util.showSnackbar
import com.example.tinkofflab2023.databinding.FragmentMatchBinding
import com.example.tinkofflab2023.di.Screens
import com.github.terrakok.cicerone.Router
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MatchFragment : Fragment(R.layout.fragment_match) {

    private var binding: FragmentMatchBinding? = null

    private var matchId: String = ""

    private var isFavorite: Boolean? = null

    private val viewModel: MatchViewModel by viewModels()

    @Inject
    lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.getString(MATCH_ID_TAG)?.let {
            matchId = it
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpToolBar()

        binding = FragmentMatchBinding.bind(view)

        viewModel.isFavorite.observe(viewLifecycleOwner) {
            isFavorite = it
        }

        val tabLayout = binding!!.tabLayout
        val viewPager = binding!!.viewPager
        viewPager.adapter = MatchPagerAdapter(requireActivity(), matchId)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.overview)
                else -> tab.text = getString(R.string.details)
            }
        }.attach()
    }

    private fun setUpToolBar() {
        lifecycleScope.launch {
            viewModel.getFavoriteState(matchId)

            val menuHost: MenuHost = requireActivity().also {
                if (it is ActivityToolBar) {
                    it.changeToolBarTitle("${getString(R.string.match)} $matchId")
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
                        R.id.action_more -> router.navigateTo(Screens.Settings())
                        R.id.action_heart -> {
                            onFavoriteClick(menuItem)
                        }
                    }
                    return true
                }
            }, viewLifecycleOwner, Lifecycle.State.RESUMED)
        }
    }

    private fun onFavoriteClick(menuItem: MenuItem) {
        when (isFavorite) {
            false -> {
                menuItem.icon = ResourcesCompat.getDrawable(
                    requireActivity().resources,
                    R.drawable.favorite_fill_40,
                    null
                )
                viewModel.favorite(matchId, isFavorite ?: false)
                binding?.root?.showSnackbar(getString(R.string.added_to_favorites))
            }

            true -> {
                menuItem.icon = ResourcesCompat.getDrawable(
                    requireActivity().resources,
                    R.drawable.favorite_40,
                    null
                )
                viewModel.favorite(matchId, isFavorite ?: true)
                binding?.root?.showSnackbar(getString(R.string.removed_from_favorites))
            }

            null -> {
                binding?.root?.showSnackbar("null")
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    companion object {

        const val MATCH_ID_TAG = "MATCH_ID_TAG"

        fun newInstance(message: String, tag: String = MATCH_ID_TAG) = MatchFragment().apply {
            arguments = Bundle().apply {
                putString(tag, message)
            }
        }
    }
}
