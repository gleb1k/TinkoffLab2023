package com.example.tinkofflab2023.ui.fragment.match.adapter

import com.bumptech.glide.RequestManager
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.core.delegateadapter.ViewBindingDelegateAdapter
import com.example.tinkofflab2023.databinding.TeamPlayerBuildItemBinding
import com.example.tinkofflab2023.ui.model.MatchPlayerItem
import com.example.tinkofflab2023.ui.util.ViewModifier

class TeamPlayerDetailDelegateAdapter(
    private val viewModifier: ViewModifier,
    private val glide: RequestManager,
    private val onPlayerClick: (String?) -> Unit,
) : ViewBindingDelegateAdapter<MatchPlayerItem, TeamPlayerBuildItemBinding>
    (TeamPlayerBuildItemBinding::inflate) {
    override fun TeamPlayerBuildItemBinding.onBind(item: MatchPlayerItem) {

        val context = root.context

        if(item.player.playerSlot % 2 == 0 && item.player.playerSlot<128){
            root.setBackgroundColor(viewModifier.getRadiantPlayerLightColor())
        }
        if(item.player.playerSlot % 2 == 1 && item.player.playerSlot<128){
            root.setBackgroundColor(viewModifier.getRadiantPlayerDarkColor())
        }


        if(item.player.playerSlot % 2 == 0 && item.player.playerSlot>=128){
            root.setBackgroundColor(viewModifier.getDirePlayerLightColor())
        }
        if(item.player.playerSlot % 2 == 1 && item.player.playerSlot>=128){
            root.setBackgroundColor(viewModifier.getDirePlayerDarkColor())
        }

        with(item.player) {
            tvPlayerName.text = personaname?: root.context.getString(R.string.anonym)
            tvPlayerName.setOnClickListener {
                onPlayerClick(accountId)
            }
            tvGold.text = totalGold.toString()
            tvLvl.text = level.toString()
        }

        with(item.items) {
            glide
                .load(get(0).img)
                .placeholder(viewModifier.getCircularProgressDrawable())
                .error(viewModifier.getItemBackground())
                .into(ivItem0)
            glide
                .load(get(1).img)
                .placeholder(viewModifier.getCircularProgressDrawable())
                .error(viewModifier.getItemBackground())
                .into(ivItem1)
            glide
                .load(get(2).img)
                .placeholder(viewModifier.getCircularProgressDrawable())
                .error(viewModifier.getItemBackground())
                .into(ivItem2)
            glide
                .load(get(3).img)
                .placeholder(viewModifier.getCircularProgressDrawable())
                .error(viewModifier.getItemBackground())
                .into(ivItem3)
            glide
                .load(get(4).img)
                .placeholder(viewModifier.getCircularProgressDrawable())
                .error(viewModifier.getItemBackground())
                .into(ivItem4)
            glide
                .load(get(5).img)
                .placeholder(viewModifier.getCircularProgressDrawable())
                .error(viewModifier.getItemBackground())
                .into(ivItem5)
        }

        with(item.backpackItems) {
            glide
                .load(get(0).img)
                .placeholder(viewModifier.getCircularProgressDrawable())
                .error(viewModifier.getItemBackground())
                .into(ivBackpack0)
            glide
                .load(get(1).img)
                .placeholder(viewModifier.getCircularProgressDrawable())
                .error(viewModifier.getItemBackground())
                .into(ivBackpack1)
            glide
                .load(get(2).img)
                .placeholder(viewModifier.getCircularProgressDrawable())
                .error(viewModifier.getItemBackground())
                .into(ivBackpack2)
        }

        glide
            .load(item.itemNeutral.img)
            .placeholder(viewModifier.getCircularProgressDrawable())
            .error(viewModifier.getItemBackground())
            .into(ivItemNeutral)


        glide
            .load(item.heroEntity.img)
            .placeholder(viewModifier.getCircularProgressDrawable())
            .into(ivHero)
    }

    override fun isForViewType(item: Any): Boolean = item is MatchPlayerItem

    override fun MatchPlayerItem.getItemId(): Any = player.playerSlot
}
