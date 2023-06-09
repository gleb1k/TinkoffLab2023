package com.example.tinkofflab2023.ui.fragment.player.heroes

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.core.delegateadapter.CompositeDelegateAdapter
import com.example.tinkofflab2023.databinding.FragmentPlayerHeroesBinding
import com.example.tinkofflab2023.ui.fragment.player.adapter.HeroDelegateAdapter
import com.example.tinkofflab2023.ui.fragment.player.overview.PlayerOverviewFragment
import com.example.tinkofflab2023.ui.util.ViewModifier
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PlayerHeroesFragment : Fragment(R.layout.fragment_player_heroes) {

    private var binding: FragmentPlayerHeroesBinding? = null

    private var adapter: CompositeDelegateAdapter? = null

    private val viewModel: PlayerHeroesViewModel by viewModels()

    private var accountId: String = ""

    @Inject
    lateinit var viewModifier: ViewModifier

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val glide = Glide.with(this)

        adapter = CompositeDelegateAdapter(
            HeroDelegateAdapter(
                viewModifier,
                glide
            ),
        )
        arguments?.getString(PlayerOverviewFragment.ACCOUNT_ID_TAG)?.let {
            accountId = it
        }
        viewModel.loadData(accountId)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPlayerHeroesBinding.bind(view)

        binding?.run {
            //todo из-за swipeRefreshLayout не сразу прогружается список
//            swipeRefreshLayout.setOnRefreshListener {
//                viewModel.refreshData(accountId)
//            }

            rvHeroes.layoutManager = LinearLayoutManager(context)
            rvHeroes.adapter = adapter

            viewModel.error.observe(viewLifecycleOwner) {
                tvError.text = it
            }
//            viewModel.refreshing.observe(viewLifecycleOwner) {
//                swipeRefreshLayout.isRefreshing = it
//            }
            viewModel.loading.observe(viewLifecycleOwner) {
                if (it == true)
                    progressBar.visibility = View.VISIBLE
                else
                    progressBar.visibility = View.GONE
            }

            viewModel.viewList.observe(viewLifecycleOwner) {
                if (it == null) return@observe
                adapter?.swapData(it)
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    companion object {

        const val ACCOUNT_ID_TAG = "ACCOUNT_ID_TAG"

        fun newInstance(message: String, tag: String = ACCOUNT_ID_TAG) =
            PlayerHeroesFragment().apply {
                arguments = Bundle().apply {
                    putString(tag, message)
                }
            }
    }


}
