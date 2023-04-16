package com.example.tinkofflab2023.presentation.fragment.player.overview.adapter

import com.bumptech.glide.RequestManager
import com.example.tinkofflab2023.data.remote.response.players.recentmatches.PlayerRecentMatchResponse
import com.example.tinkofflab2023.databinding.MatchItemBinding
import com.example.tinkofflab2023.presentation.delegateadapter.ViewBindingDelegateAdapter
import com.example.tinkofflab2023.utils.Converter

class MatchDelegateAdapter(
    private val glide: RequestManager,
) :
    ViewBindingDelegateAdapter<PlayerRecentMatchResponse, MatchItemBinding>(MatchItemBinding::inflate) {

    override fun MatchItemBinding.onBind(item: PlayerRecentMatchResponse) {
        //ivHero
        tvHeroName.text = item.heroId.toString()
        tvPlayerRank.text = item.averageRank.toString()
        tvKda.text = "${item.kills}k${item.deaths}d${item.assists}a"
        tvDuration.text = Converter.matchDuration(item.duration)
    }

    override fun isForViewType(item: Any): Boolean = item is PlayerRecentMatchResponse

    override fun PlayerRecentMatchResponse.getItemId(): Any = matchId
}
