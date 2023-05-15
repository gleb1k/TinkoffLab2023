package com.example.tinkofflab2023.ui.fragment.player.overview.adapter

import com.bumptech.glide.RequestManager
import com.example.tinkofflab2023.core.delegateadapter.ViewBindingDelegateAdapter
import com.example.tinkofflab2023.databinding.HeroItemBinding
import com.example.tinkofflab2023.ui.model.PlayerHeroItem
import com.example.tinkofflab2023.ui.util.ViewModifier

class HeroDelegateAdapter(
    private val viewModifier: ViewModifier,
    private val glide: RequestManager,
) :
    ViewBindingDelegateAdapter<PlayerHeroItem, HeroItemBinding>(HeroItemBinding::inflate) {

    override fun HeroItemBinding.onBind(item: PlayerHeroItem) {
        with(item.heroResponse) {
            tvMatches.text = "$games"
            tvLastPlayed.text = viewModifier.epochToDate(lastPlayed)
            tvWl.text = viewModifier.wl(win, games - win)
            tvWinrate.text = viewModifier.winrate(win, games - win)
        }
        glide
            .load(item.heroEntity.img)
            .placeholder(viewModifier.getCircularProgressDrawable())
            .into(ivHero)
    }

    override fun isForViewType(item: Any): Boolean = item is PlayerHeroItem

    override fun PlayerHeroItem.getItemId(): Any = heroEntity.id

}
