package com.example.tinkofflab2023.ui.fragment.player.overview.adapter

import com.bumptech.glide.RequestManager
import com.example.tinkofflab2023.data.remote.response.players.heroes.PlayerHeroResponse
import com.example.tinkofflab2023.databinding.HeroItemBinding
import com.example.tinkofflab2023.ui.delegateadapter.ViewBindingDelegateAdapter
import com.example.tinkofflab2023.utils.Converter

class HeroDelegateAdapter(
    private val glide: RequestManager,
) :
    ViewBindingDelegateAdapter<PlayerHeroResponse, HeroItemBinding>(HeroItemBinding::inflate) {
    override fun HeroItemBinding.onBind(item: PlayerHeroResponse) {
        tvMatches.text = "${item.games}"
        tvLastPlayed.text = "${Converter.epochToDate(item.lastPlayed)}"
        tvWl.text = "${Converter.wl(item.win,item.games-item.win)}"
        tvWinrate.text = "${Converter.winrate(item.win,item.games-item.win)}"

    }

    override fun isForViewType(item: Any): Boolean = item is PlayerHeroResponse

    override fun PlayerHeroResponse.getItemId(): Any = heroId

}
