package com.example.tinkofflab2023.presentation.fragment.player.overview

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.databinding.FragmentPlayerOverviewBinding
import com.example.tinkofflab2023.presentation.delegateadapter.CompositeDelegateAdapter
import com.example.tinkofflab2023.presentation.fragment.player.overview.adapter.HeroDelegateAdapter
import com.example.tinkofflab2023.presentation.fragment.player.overview.adapter.MatchDelegateAdapter
import com.example.tinkofflab2023.presentation.fragment.player.overview.adapter.PlayerHeaderDelegateAdapter
import com.example.tinkofflab2023.presentation.fragment.player.overview.adapter.TextCenterDelegateAdapter

class PlayerOverviewFragment : Fragment(R.layout.fragment_player_overview) {

    private var binding: FragmentPlayerOverviewBinding? = null

    private var adapter: CompositeDelegateAdapter? = null

    private val viewModel: PlayerOverviewViewModel by viewModels {
        PlayerOverviewViewModel.Factory
    }

    private var accountId: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val glide = Glide.with(this)

        adapter = CompositeDelegateAdapter(
            TextCenterDelegateAdapter(),
            PlayerHeaderDelegateAdapter(glide),
            MatchDelegateAdapter(glide),
            HeroDelegateAdapter(glide)
        )

        arguments?.getString(ACCOUNT_ID_TAG)?.let {
            accountId = it
        }
        viewModel.loadData(accountId)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPlayerOverviewBinding.bind(view)

        binding?.run {
            rvOverview.layoutManager = LinearLayoutManager(context)
            rvOverview.adapter = adapter
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
            PlayerOverviewFragment().apply {
                arguments = Bundle().apply {
                    putString(tag, message)
                }
            }
    }
}
