package com.example.tinkofflab2023.ui.fragment.player.overview.adapter

import com.bumptech.glide.RequestManager
import com.example.tinkofflab2023.data.remote.response.players.recentmatches.PlayerRecentMatchResponse
import com.example.tinkofflab2023.databinding.MatchItemBinding
import com.example.tinkofflab2023.ui.delegateadapter.ViewBindingDelegateAdapter
import com.example.tinkofflab2023.utils.Converter

class MatchDelegateAdapter(
    private val glide: RequestManager,
    private val onMatchClick : (String) -> Unit
) :
    ViewBindingDelegateAdapter<PlayerRecentMatchResponse, MatchItemBinding>(MatchItemBinding::inflate) {

    override fun MatchItemBinding.onBind(item: PlayerRecentMatchResponse) {
        //ivHero
        root.setOnClickListener {
            onMatchClick(item.matchId)
        }
        tvHeroName.text = item.heroId.toString()
        tvPlayerRank.text = item.averageRank.toString()
        tvKda.text = "${item.kills}k${item.deaths}d${item.assists}a"
        tvDuration.text = Converter.matchDuration(item.duration)
    }

    override fun isForViewType(item: Any): Boolean = item is PlayerRecentMatchResponse

    override fun PlayerRecentMatchResponse.getItemId(): Any = matchId
}
