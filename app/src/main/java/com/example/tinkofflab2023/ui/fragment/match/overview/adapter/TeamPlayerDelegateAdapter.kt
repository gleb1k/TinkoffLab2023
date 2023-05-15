package com.example.tinkofflab2023.ui.fragment.match.overview.adapter

import com.bumptech.glide.RequestManager
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.core.delegateadapter.ViewBindingDelegateAdapter
import com.example.tinkofflab2023.databinding.TeamPlayerItemBinding
import com.example.tinkofflab2023.ui.model.MatchPlayerItem
import com.example.tinkofflab2023.ui.util.ViewModifier

class TeamPlayerDelegateAdapter(
    private val viewModifier: ViewModifier,
    private val glide: RequestManager,
    private val onItemClick: (String?) -> Unit,
) : ViewBindingDelegateAdapter<MatchPlayerItem, TeamPlayerItemBinding>
    (TeamPlayerItemBinding::inflate) {

    override fun TeamPlayerItemBinding.onBind(item: MatchPlayerItem) {

        val context = root.context
        with(item.player) {
            tvPlayerName.text = personaname ?: context.getString(R.string.anonym)
            tvKills.text = "$kills"
            tvDeaths.text = "$deaths"
            tvAssists.text = "$assists"
            tvNet.text = "$netWorth"

            tvPlayerName.setOnClickListener {
                onItemClick(accountId)
            }

            glide
                .load(item.heroEntity.img)
                .placeholder(viewModifier.getCircularProgressDrawable())
                .into(ivHero)

        }
    }

    override fun isForViewType(item: Any): Boolean = item is MatchPlayerItem

    override fun MatchPlayerItem.getItemId(): Any = player.playerSlot
}

