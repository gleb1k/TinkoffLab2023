package com.example.tinkofflab2023.ui.fragment.player.overview.adapter

import com.bumptech.glide.RequestManager
import com.example.tinkofflab2023.core.delegateadapter.ViewBindingDelegateAdapter
import com.example.tinkofflab2023.data.Constants
import com.example.tinkofflab2023.databinding.MatchItemBinding
import com.example.tinkofflab2023.ui.model.PlayerMatchItem
import com.example.tinkofflab2023.ui.util.ViewModifier
import javax.inject.Inject

class MatchDelegateAdapter(
    private val viewModifier: ViewModifier,
    private val glide: RequestManager,
    private val onMatchClick: (String) -> Unit
) :
    ViewBindingDelegateAdapter<PlayerMatchItem, MatchItemBinding>(MatchItemBinding::inflate) {

    override fun MatchItemBinding.onBind(item: PlayerMatchItem) {
        with(item.matchResponse) {
            root.setOnClickListener {
                onMatchClick(matchId)
            }
            tvPlayerRank.text = averageRank.toString()
            tvKda.text = viewModifier.kda(
                kills,
                deaths,
                assists
            )
            tvDuration.text = viewModifier.matchDuration(duration)
            tvTime.text = viewModifier.epochToDate(startTime)
            tvGameMode.text = Constants.gameModes[gameMode].toString()
            tvRanked.text = Constants.lobbyTypes[lobbyType]
            tvWl.text = viewModifier.lostOrWonMatch(
                playerSlot,
                radiantWin
            )
        }

        tvHeroName.text = item.heroEntity.localizedName
        glide
            .load(item.heroEntity.img)
            .placeholder(viewModifier.getCircularProgressDrawable())
            .into(ivHero)

    }

    override fun isForViewType(item: Any): Boolean = item is PlayerMatchItem

    override fun PlayerMatchItem.getItemId(): Any = matchResponse.matchId
}
