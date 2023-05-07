package com.example.tinkofflab2023.ui.fragment.player.overview.adapter

import com.bumptech.glide.RequestManager
import com.example.tinkofflab2023.core.delegateadapter.ViewBindingDelegateAdapter
import com.example.tinkofflab2023.core.util.Converter
import com.example.tinkofflab2023.data.Constants
import com.example.tinkofflab2023.data.remote.response.players.matches.PlayerMatchResponse
import com.example.tinkofflab2023.databinding.MatchItemBinding

class MatchDelegateAdapter(
    private val glide: RequestManager,
    private val onMatchClick: (String) -> Unit
) :
    ViewBindingDelegateAdapter<PlayerMatchResponse, MatchItemBinding>(MatchItemBinding::inflate) {

    override fun MatchItemBinding.onBind(item: PlayerMatchResponse) {
        with(item) {
            root.setOnClickListener {
                onMatchClick(matchId)
            }
            tvPlayerRank.text = averageRank.toString()
            tvKda.text = Converter.kda(
                kills,
                deaths,
                assists
            )
            tvDuration.text = Converter.matchDuration(duration)
            tvTime.text = Converter.epochToDate(startTime)
            tvGameMode.text = Constants.gameModes[gameMode].toString()
            tvRanked.text = Constants.lobbyTypes[lobbyType]
            tvWl.text = Converter.lostOrWonMatch(
                playerSlot,
                radiantWin
            )


//            tvHeroName.text = heroResponse.localizedName
//            glide
//                .load(Constants.DOTA_API_IMAGE_URL + heroResponse.img)
//                .into(ivHero)
        }
    }

    override fun isForViewType(item: Any): Boolean = item is PlayerMatchResponse

    override fun PlayerMatchResponse.getItemId(): Any = matchId
}
