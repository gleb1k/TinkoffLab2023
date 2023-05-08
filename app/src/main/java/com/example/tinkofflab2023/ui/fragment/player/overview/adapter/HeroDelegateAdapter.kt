package com.example.tinkofflab2023.ui.fragment.player.overview.adapter

import com.bumptech.glide.RequestManager
import com.example.tinkofflab2023.core.delegateadapter.ViewBindingDelegateAdapter
import com.example.tinkofflab2023.core.util.Converter
import com.example.tinkofflab2023.databinding.HeroItemBinding
import com.example.tinkofflab2023.ui.model.PlayerHeroItem

class HeroDelegateAdapter(
    private val glide: RequestManager,
) :
    ViewBindingDelegateAdapter<PlayerHeroItem, HeroItemBinding>(HeroItemBinding::inflate) {
    override fun HeroItemBinding.onBind(item: PlayerHeroItem) {
        with(item.heroResponse) {
            tvMatches.text = "$games"
            tvLastPlayed.text = "${Converter.epochToDate(lastPlayed)}"
            tvWl.text = "${Converter.wl(win, games - win)}"
            tvWinrate.text = "${Converter.winrate(win, games - win)}"
        }
        glide
            .load(item.heroEntity.img)
            .into(ivHero)
    }

    override fun isForViewType(item: Any): Boolean = item is PlayerHeroItem

    override fun PlayerHeroItem.getItemId(): Any = heroEntity.id

}
