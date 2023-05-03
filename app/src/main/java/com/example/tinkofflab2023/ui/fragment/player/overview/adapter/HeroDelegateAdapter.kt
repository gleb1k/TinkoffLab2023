package com.example.tinkofflab2023.ui.fragment.player.overview.adapter

import com.bumptech.glide.RequestManager
import com.example.tinkofflab2023.core.delegateadapter.ViewBindingDelegateAdapter
import com.example.tinkofflab2023.data.Constants
import com.example.tinkofflab2023.databinding.HeroItemBinding
import com.example.tinkofflab2023.ui.fragment.player.model.PlayerHeroItem
import com.example.tinkofflab2023.core.utils.Converter

class HeroDelegateAdapter(
    private val glide: RequestManager,
) :
    ViewBindingDelegateAdapter<PlayerHeroItem, HeroItemBinding>(HeroItemBinding::inflate) {
    override fun HeroItemBinding.onBind(item: PlayerHeroItem) {
        with(item) {
            tvMatches.text = "${playerHeroResponse.games}"
            tvLastPlayed.text = "${Converter.epochToDate(playerHeroResponse.lastPlayed)}"
            tvWl.text = "${
                Converter.wl(
                    playerHeroResponse.win,
                    playerHeroResponse.games - playerHeroResponse.win
                )
            }"
            tvWinrate.text = "${
                Converter.winrate(
                    playerHeroResponse.win,
                    playerHeroResponse.games - playerHeroResponse.win
                )
            }"
            glide
                .load(Constants.DOTA_API_IMAGE_URL + heroResponse.img)
                .into(ivHero)
        }
    }

    override fun isForViewType(item: Any): Boolean = item is PlayerHeroItem

    override fun PlayerHeroItem.getItemId(): Any = playerHeroResponse.heroId

}
