package com.example.tinkofflab2023.ui.fragment.player.adapter

import android.annotation.SuppressLint
import com.bumptech.glide.RequestManager
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.core.delegateadapter.ViewBindingDelegateAdapter
import com.example.tinkofflab2023.data.Constants
import com.example.tinkofflab2023.databinding.MatchItemBinding
import com.example.tinkofflab2023.ui.model.PlayerMatchItem
import com.example.tinkofflab2023.ui.util.ViewModifier

class MatchDelegateAdapter(
    private val viewModifier: ViewModifier,
    private val glide: RequestManager,
    private val onMatchClick: (String) -> Unit
) :
    ViewBindingDelegateAdapter<PlayerMatchItem, MatchItemBinding>(MatchItemBinding::inflate) {

    @SuppressLint("SetTextI18n")
    override fun MatchItemBinding.onBind(item: PlayerMatchItem) {
        val rank = viewModifier.getRank(item.matchResponse.averageRank)

        with(item.matchResponse) {
            root.setOnClickListener {
                onMatchClick(matchId)
            }


            if (rank.tier == -1)
                tvPlayerRank.text = rank.name
            else
                tvPlayerRank.text = "${rank.name} ${rank.tier}"

            tvKda.text = viewModifier.kda(kills, deaths, assists)

            tvDuration.text = viewModifier.matchDuration(duration)
            tvTime.text = viewModifier.epochToDate(startTime)
            tvGameMode.text = Constants.gameModes[gameMode].toString()
            tvRanked.text = Constants.lobbyTypes[lobbyType]
            tvWl.text = viewModifier.lostOrWonMatch(
                playerSlot,
                radiantWin
            ).also {
                if (it == root.context.getString(R.string.won_match))
                    tvWl.setTextColor(viewModifier.getRadiantGreen())
                else
                    tvWl.setTextColor(viewModifier.getDireRedColor())
            }
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
