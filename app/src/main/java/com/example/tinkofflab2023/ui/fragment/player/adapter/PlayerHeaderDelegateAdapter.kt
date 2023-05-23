package com.example.tinkofflab2023.ui.fragment.player.adapter

import com.bumptech.glide.RequestManager
import com.example.tinkofflab2023.core.delegateadapter.ViewBindingDelegateAdapter
import com.example.tinkofflab2023.databinding.PlayerHeaderBinding
import com.example.tinkofflab2023.ui.model.PlayerHeaderItem
import com.example.tinkofflab2023.ui.util.ViewModifier

class PlayerHeaderDelegateAdapter(
    private val viewModifier: ViewModifier,
    private val glide: RequestManager,
) : ViewBindingDelegateAdapter<PlayerHeaderItem, PlayerHeaderBinding>
    (PlayerHeaderBinding::inflate) {

    override fun PlayerHeaderBinding.onBind(item: PlayerHeaderItem) {
        val rank = viewModifier.getRank(item.playerDataResponse.rankTier)
        with(item) {
            tvNickname.text = playerDataResponse.profile.personaname
            tvAccountId.text = playerDataResponse.profile.accountId
            if (rank.tier == -1)
                tvRating.text = rank.name
            else
                tvRating.text = "${rank.name} ${rank.tier}"
            tvWinrate.text = viewModifier.winrate(playerWL.win, playerWL.lose)
            tvWl.text = viewModifier.wl(playerWL.win, playerWL.lose)
            tvEstimate.text = playerDataResponse.mmrEstimate.estimate.toString()

            glide
                .load(playerDataResponse.profile.avatarfull)
                .placeholder(viewModifier.getCircularProgressDrawable())
                .into(ivAvatar)

            glide
                .load(rank.img)
                .placeholder(viewModifier.getCircularProgressDrawable())
                .into(ivRating)
        }
    }

    override fun isForViewType(item: Any): Boolean = item is PlayerHeaderItem

    override fun PlayerHeaderItem.getItemId(): Any = playerDataResponse.profile.accountId

}
