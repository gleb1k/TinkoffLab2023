package com.example.tinkofflab2023.presentation.fragment.match

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.databinding.FragmentMatchBinding
import com.example.tinkofflab2023.presentation.delegateadapter.CompositeDelegateAdapter
import com.example.tinkofflab2023.presentation.fragment.match.adapter.MatchHeaderDelegateAdapter
import com.example.tinkofflab2023.presentation.fragment.match.adapter.TeamHeaderDelegateAdapter
import com.example.tinkofflab2023.presentation.fragment.match.adapter.TeamOutcomeDelegateAdapter
import com.example.tinkofflab2023.presentation.fragment.match.adapter.TeamPlayerDelegateAdapter
import com.example.tinkofflab2023.utils.Converter

class MatchFragment : Fragment(R.layout.fragment_match) {

    private var binding: FragmentMatchBinding? = null

    private var adapter: CompositeDelegateAdapter? = null

    private val viewModel: MatchViewModel by viewModels {
        MatchViewModel.Factory
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
        viewModel.loadData()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMatchBinding.bind(view)

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
