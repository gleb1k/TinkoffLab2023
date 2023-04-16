package com.example.tinkofflab2023.presentation.fragment.player.overview.adapter

import com.bumptech.glide.RequestManager
import com.example.tinkofflab2023.data.remote.response.players.data.PlayerDataResponse
import com.example.tinkofflab2023.databinding.PlayerHeaderBinding
import com.example.tinkofflab2023.presentation.delegateadapter.ViewBindingDelegateAdapter
import com.example.tinkofflab2023.utils.Converter

class PlayerHeaderDelegateAdapter(
    private val glide: RequestManager,
)
    : ViewBindingDelegateAdapter<PlayerDataResponse, PlayerHeaderBinding>
    (PlayerHeaderBinding::inflate) {

    override fun PlayerHeaderBinding.onBind(item: PlayerDataResponse) {
        tvNickname.text = item.profile.personaname
        tvAccountId.text = item.profile.accountId.toString()
        tvRating.text = item.rankTier.toString()
//        tvWinrate.text = Converter.winrate(item.)

        glide
            .load(item.profile.avatarfull)
            .into(ivAvatar)
        //wl.text = ----
    }

    override fun isForViewType(item: Any): Boolean = item is PlayerDataResponse

    override fun PlayerDataResponse.getItemId(): Any = profile.accountId

}
