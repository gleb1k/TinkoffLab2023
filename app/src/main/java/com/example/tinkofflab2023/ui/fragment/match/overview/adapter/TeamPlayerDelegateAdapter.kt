package com.example.tinkofflab2023.ui.fragment.match.overview.adapter

import com.bumptech.glide.RequestManager
import com.example.tinkofflab2023.data.Constants
import com.example.tinkofflab2023.ui.model.match.TeamPlayer
import com.example.tinkofflab2023.databinding.TeamPlayerItemBinding
import com.example.tinkofflab2023.ui.delegateadapter.ViewBindingDelegateAdapter

class TeamPlayerDelegateAdapter(
    private val glide: RequestManager
) : ViewBindingDelegateAdapter<TeamPlayer, TeamPlayerItemBinding>
    (TeamPlayerItemBinding::inflate) {
    override fun TeamPlayerItemBinding.onBind(item: TeamPlayer) {
        with(item) {
            tvPlayerName.text = name
            tvKills.text = "$kills"
            tvDeaths.text = "$deaths"
            tvAssists.text = "$assists"
            tvNet.text = "$net"
            glide
                .load(Constants.DOTA_API_IMAGE_URL + heroImg)
                .into(ivHero)
        }
    }

    override fun isForViewType(item: Any): Boolean = item is TeamPlayer

    override fun TeamPlayer.getItemId(): Any = playerSlot
}

