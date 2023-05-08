package com.example.tinkofflab2023.ui.fragment.match.overview.adapter

import android.content.Context
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.RequestManager
import com.example.tinkofflab2023.core.delegateadapter.ViewBindingDelegateAdapter
import com.example.tinkofflab2023.databinding.TeamPlayerItemBinding
import com.example.tinkofflab2023.ui.model.MatchPlayerItem

class TeamPlayerDelegateAdapter(
    private val glide: RequestManager,
    private val onItemClick: (String?) -> Unit,
    private val context: Context,
) : ViewBindingDelegateAdapter<MatchPlayerItem, TeamPlayerItemBinding>
    (TeamPlayerItemBinding::inflate) {
    override fun TeamPlayerItemBinding.onBind(item: MatchPlayerItem) {
        val circularProgressDrawable = CircularProgressDrawable(context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        with(item.player) {
            tvPlayerName.text = personaname ?: "Profile Closed"
            tvKills.text = "$kills"
            tvDeaths.text = "$deaths"
            tvAssists.text = "$assists"
            tvNet.text = "$netWorth"

            tvPlayerName.setOnClickListener {
                onItemClick(accountId)
            }

            glide
                .load(item.heroEntity.img)
                .placeholder(circularProgressDrawable)
                .into(ivHero)

        }
    }

    override fun isForViewType(item: Any): Boolean = item is MatchPlayerItem

    override fun MatchPlayerItem.getItemId(): Any = player.playerSlot
}

