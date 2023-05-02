package com.example.tinkofflab2023.ui.fragment.player.overview.adapter

import com.bumptech.glide.RequestManager
import com.example.tinkofflab2023.core.delegateadapter.ViewBindingDelegateAdapter
import com.example.tinkofflab2023.data.Constants
import com.example.tinkofflab2023.databinding.MatchItemBinding
import com.example.tinkofflab2023.ui.model.player.PlayerRecentMatchItem
import com.example.tinkofflab2023.utils.Converter

class MatchDelegateAdapter(
    private val glide: RequestManager,
    private val onMatchClick: (String) -> Unit
) :
    ViewBindingDelegateAdapter<PlayerRecentMatchItem, MatchItemBinding>(MatchItemBinding::inflate) {

    override fun MatchItemBinding.onBind(item: PlayerRecentMatchItem) {
        with(item) {
            root.setOnClickListener {
                onMatchClick(playerRecentMatchResponse.matchId)
            }
            tvPlayerRank.text = playerRecentMatchResponse.averageRank.toString()
            tvKda.text = Converter.kda(
                playerRecentMatchResponse.kills,
                playerRecentMatchResponse.deaths,
                playerRecentMatchResponse.assists
            )
            tvDuration.text = Converter.matchDuration(playerRecentMatchResponse.duration)
            tvHeroName.text = heroResponse.localizedName
            tvTime.text = Converter.epochToDate(playerRecentMatchResponse.startTime)
            tvGameMode.text = Constants.gameModes[playerRecentMatchResponse.gameMode].toString()
            tvRanked.text = Constants.lobbyTypes[playerRecentMatchResponse.lobbyType]
            tvWl.text = Converter.lostOrWonMatch(
                playerRecentMatchResponse.playerSlot,
                playerRecentMatchResponse.radiantWin
            )

            glide
                .load(Constants.DOTA_API_IMAGE_URL + heroResponse.img)
                .into(ivHero)
        }
    }

    override fun isForViewType(item: Any): Boolean = item is PlayerRecentMatchItem

    override fun PlayerRecentMatchItem.getItemId(): Any = playerRecentMatchResponse.matchId
}
