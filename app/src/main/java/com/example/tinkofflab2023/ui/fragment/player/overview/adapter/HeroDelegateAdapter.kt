package com.example.tinkofflab2023.ui.fragment.player.overview.adapter

import com.bumptech.glide.RequestManager
import com.example.tinkofflab2023.core.delegateadapter.ViewBindingDelegateAdapter
import com.example.tinkofflab2023.core.utils.Converter
import com.example.tinkofflab2023.data.Constants
import com.example.tinkofflab2023.data.remote.response.players.heroes.PlayerHeroResponse
import com.example.tinkofflab2023.data.remote.response.players.heroes.PlayerHeroesResponse
import com.example.tinkofflab2023.databinding.HeroItemBinding

class HeroDelegateAdapter(
    private val glide: RequestManager,
) :
    ViewBindingDelegateAdapter<PlayerHeroResponse, HeroItemBinding>(HeroItemBinding::inflate) {
    override fun HeroItemBinding.onBind(item: PlayerHeroResponse) {
        with(item) {
            tvMatches.text = "$games"
            tvLastPlayed.text = "${Converter.epochToDate(lastPlayed)}"
            tvWl.text = "${Converter.wl(win, games - win)}"
            tvWinrate.text = "${Converter.winrate(win, games - win)}"

//            glide
//                .load(Constants.DOTA_API_IMAGE_URL + heroResponse.img)
//                .into(ivHero)
        }
    }

    override fun isForViewType(item: Any): Boolean = item is PlayerHeroResponse

    override fun PlayerHeroResponse.getItemId(): Any = heroId

}
