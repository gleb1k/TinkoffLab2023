package com.example.tinkofflab2023.ui.fragment.favorite

import com.bumptech.glide.RequestManager
import com.example.tinkofflab2023.core.delegateadapter.ViewBindingDelegateAdapter
import com.example.tinkofflab2023.data.Constants
import com.example.tinkofflab2023.data.local.entity.PlayerEntity
import com.example.tinkofflab2023.data.remote.response.search.SearchPlayerResponse
import com.example.tinkofflab2023.databinding.FavoritePlayerItemBinding
import com.example.tinkofflab2023.ui.util.ViewModifier

class FavoritePlayerDelegateAdapter(
    private val viewModifier: ViewModifier,
    private val glide: RequestManager,
    private val onItemClick: (String) -> Unit,
) : ViewBindingDelegateAdapter<PlayerEntity, FavoritePlayerItemBinding>(
    FavoritePlayerItemBinding::inflate
) {

    override fun FavoritePlayerItemBinding.onBind(item: PlayerEntity) {
        val rank = viewModifier.getRank(item.playerData.rankTier)

        glide
            .load(rank.img)
            .into(ivRating)

        if (rank.tier == -1)
            tvRating.text = rank.name
        else
            tvRating.text = "${rank.name} ${rank.tier}"

        tvNickname.text = item.playerData.profile.personaname
        glide
            .load(item.playerData.profile.avatarfull)
            .placeholder(viewModifier.getCircularProgressDrawable())
            .into(ivIcon)

        cardView.setOnClickListener {
            onItemClick(item.playerData.profile.accountId)
        }
    }

    override fun isForViewType(item: Any): Boolean = item is PlayerEntity

    override fun PlayerEntity.getItemId(): Any = playerData.profile.accountId
}
