package com.example.tinkofflab2023.presentation.fragment.match.adapter

import com.bumptech.glide.RequestManager
import com.example.tinkofflab2023.data.remote.response.matches.MatchResponse
import com.example.tinkofflab2023.databinding.TeamPlayerItemBinding
import com.example.tinkofflab2023.presentation.delegateadapter.ViewBindingDelegateAdapter

class TeamPlayerDelegateAdapter(
    private val glide: RequestManager
) : ViewBindingDelegateAdapter<MatchResponse, TeamPlayerItemBinding>
    (TeamPlayerItemBinding::inflate) {
    override fun TeamPlayerItemBinding.onBind(item: MatchResponse) {
        TODO("Not yet implemented")
    }

    override fun isForViewType(item: Any): Boolean {
        TODO("Not yet implemented")
    }

    override fun MatchResponse.getItemId(): Any {
        TODO("Not yet implemented")
    }
}
