package com.example.tinkofflab2023.ui.fragment.player.overview.adapter

import com.bumptech.glide.RequestManager
import com.example.tinkofflab2023.core.delegateadapter.ViewBindingDelegateAdapter
import com.example.tinkofflab2023.databinding.PlayerHeaderBinding
import com.example.tinkofflab2023.ui.model.player.PlayerHeaderItem
import com.example.tinkofflab2023.utils.Converter

class PlayerHeaderDelegateAdapter(
    private val glide: RequestManager,
) : ViewBindingDelegateAdapter<PlayerHeaderItem, PlayerHeaderBinding>
    (PlayerHeaderBinding::inflate) {

    override fun PlayerHeaderBinding.onBind(item: PlayerHeaderItem) {
        with(item) {
            tvNickname.text = playerDataResponse.profile.personaname
            tvAccountId.text = playerDataResponse.profile.accountId.toString()
            tvRating.text = playerDataResponse.rankTier.toString()
            tvWinrate.text = Converter.winrate(playerWL.win, playerWL.lose)
            tvWl.text = Converter.wl(playerWL.win, playerWL.lose)
            tvLastOnline.text = Converter.toDate(playerDataResponse.profile.lastLogin)

            glide
                .load(playerDataResponse.profile.avatarfull)
                .into(ivAvatar)
        }
    }

    override fun isForViewType(item: Any): Boolean = item is PlayerHeaderItem

    override fun PlayerHeaderItem.getItemId(): Any = playerDataResponse.profile.accountId

}
