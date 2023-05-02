package com.example.tinkofflab2023.ui.fragment.match.overview.adapter

import android.content.Context
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.RequestManager
import com.example.tinkofflab2023.core.delegateadapter.ViewBindingDelegateAdapter
import com.example.tinkofflab2023.data.Constants
import com.example.tinkofflab2023.databinding.TeamPlayerItemBinding
import com.example.tinkofflab2023.ui.model.match.MatchPlayerHeroItem

class TeamPlayerDelegateAdapter(
    private val glide: RequestManager,
    private val onItemClick: (String?) -> Unit,
    private val context: Context,
) : ViewBindingDelegateAdapter<MatchPlayerHeroItem, TeamPlayerItemBinding>
    (TeamPlayerItemBinding::inflate) {
    override fun TeamPlayerItemBinding.onBind(item: MatchPlayerHeroItem) {
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

            glide
                .load(Constants.DOTA_API_IMAGE_URL + item.heroResponse.img)
                .placeholder(circularProgressDrawable)
                .into(ivHero)

            tvPlayerName.setOnClickListener {
                onItemClick(accountId)
            }
        }
    }

    override fun isForViewType(item: Any): Boolean = item is MatchPlayerHeroItem

    override fun MatchPlayerHeroItem.getItemId(): Any = player.playerSlot
}

