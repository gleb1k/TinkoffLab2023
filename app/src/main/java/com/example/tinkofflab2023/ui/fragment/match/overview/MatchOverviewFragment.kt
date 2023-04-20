package com.example.tinkofflab2023.ui.fragment.match.overview

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.databinding.FragmentMatchBinding
import com.example.tinkofflab2023.ui.delegateadapter.CompositeDelegateAdapter
import com.example.tinkofflab2023.ui.fragment.match.overview.adapter.MatchHeaderDelegateAdapter
import com.example.tinkofflab2023.ui.fragment.match.overview.adapter.TeamHeaderDelegateAdapter
import com.example.tinkofflab2023.ui.fragment.match.overview.adapter.TeamOutcomeDelegateAdapter
import com.example.tinkofflab2023.ui.fragment.match.overview.adapter.TeamPlayerDelegateAdapter

class MatchOverviewFragment : Fragment(R.layout.fragment_match) {

    private var binding: FragmentMatchBinding? = null

    private var adapter: CompositeDelegateAdapter? = null

    private val viewModel: MatchOverviewViewModel by viewModels {
        MatchOverviewViewModel.Factory
    }

    private var matchId: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val glide = Glide.with(this)

        adapter = CompositeDelegateAdapter(
            MatchHeaderDelegateAdapter(),
            TeamHeaderDelegateAdapter(),
            TeamOutcomeDelegateAdapter(),
            TeamPlayerDelegateAdapter(glide)
        )

        arguments?.getString(MATCH_ID_TAG)?.let {
            matchId = it
        }
        viewModel.loadData(matchId)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMatchBinding.bind(view)

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

        const val MATCH_ID_TAG = "MATCH_ID_TAG"

        fun newInstance(message: String, tag: String = MATCH_ID_TAG) = MatchOverviewFragment().apply {
            arguments = Bundle().apply {
                putString(tag, message)
            }
        }
    }
}
