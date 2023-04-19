package com.example.tinkofflab2023.presentation.fragment.match.adapter

import com.bumptech.glide.RequestManager
import com.example.tinkofflab2023.data.model.TeamPlayer
import com.example.tinkofflab2023.data.remote.response.matches.MatchResponse
import com.example.tinkofflab2023.databinding.TeamPlayerItemBinding
import com.example.tinkofflab2023.presentation.delegateadapter.ViewBindingDelegateAdapter

class TeamPlayerDelegateAdapter(
    private val glide: RequestManager
) : ViewBindingDelegateAdapter<TeamPlayer, TeamPlayerItemBinding>
    (TeamPlayerItemBinding::inflate) {
    override fun TeamPlayerItemBinding.onBind(item: TeamPlayer) {
        with (item) {
            tvPlayerName.text = name
            tvKills.text = "$kills"
            tvDeaths.text = "$deaths"
            tvAssists.text = "$assists"
            tvNet.text = "$net"
            glide
                .load(heroImg)
                .into(ivHero)
        }
    }

    override fun isForViewType(item: Any): Boolean = item is TeamPlayer

    override fun TeamPlayer.getItemId(): Any = name
}

