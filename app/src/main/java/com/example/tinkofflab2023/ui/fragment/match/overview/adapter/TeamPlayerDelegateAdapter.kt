package com.example.tinkofflab2023.ui.fragment.match.overview.adapter

import android.content.Context
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.RequestManager
import com.example.tinkofflab2023.data.Constants
import com.example.tinkofflab2023.ui.model.match.TeamPlayerItem
import com.example.tinkofflab2023.databinding.TeamPlayerItemBinding
import com.example.tinkofflab2023.ui.delegateadapter.ViewBindingDelegateAdapter

class TeamPlayerDelegateAdapter(
    private val glide: RequestManager,
    private val context: Context,
) : ViewBindingDelegateAdapter<TeamPlayerItem, TeamPlayerItemBinding>
    (TeamPlayerItemBinding::inflate) {
    override fun TeamPlayerItemBinding.onBind(item: TeamPlayerItem) {
        val circularProgressDrawable = CircularProgressDrawable(context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        with(item) {
            tvPlayerName.text = name
            tvKills.text = "$kills"
            tvDeaths.text = "$deaths"
            tvAssists.text = "$assists"
            tvNet.text = "$net"
            glide
                .load(Constants.DOTA_API_IMAGE_URL + heroImg)
                .placeholder(circularProgressDrawable)
                .into(ivHero)
        }
    }

    override fun isForViewType(item: Any): Boolean = item is TeamPlayerItem

    override fun TeamPlayerItem.getItemId(): Any = playerSlot
}

