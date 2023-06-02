package com.example.tinkofflab2023.ui.fragment.match.adapter

import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.core.delegateadapter.ViewBindingDelegateAdapter
import com.example.tinkofflab2023.databinding.TeamPlayerBuildItemBinding
import com.example.tinkofflab2023.ui.model.MatchPlayerItem
import com.example.tinkofflab2023.ui.util.ViewModifier
import com.google.android.material.color.MaterialColors
import jp.wasabeef.glide.transformations.GrayscaleTransformation

class TeamPlayerDetailDelegateAdapter(
    private val viewModifier: ViewModifier,
    private val glide: RequestManager,
    private val onPlayerClick: (String?) -> Unit,
) : ViewBindingDelegateAdapter<MatchPlayerItem, TeamPlayerBuildItemBinding>
    (TeamPlayerBuildItemBinding::inflate) {
    override fun TeamPlayerBuildItemBinding.onBind(item: MatchPlayerItem) {

        val rank = viewModifier.getRank(item.player.rankTier)

        if (item.player.playerSlot % 2 == 0 && item.player.playerSlot < 128) {
            root.setBackgroundColor(MaterialColors.getColor(root, R.attr.radiant_bg_1))
        }
        if (item.player.playerSlot % 2 == 1 && item.player.playerSlot < 128) {
            root.setBackgroundColor(MaterialColors.getColor(root, R.attr.radiant_bg_2))
        }


        if (item.player.playerSlot % 2 == 0 && item.player.playerSlot >= 128) {
            root.setBackgroundColor(MaterialColors.getColor(root, R.attr.dire_bg_1))
        }
        if (item.player.playerSlot % 2 == 1 && item.player.playerSlot >= 128) {
            root.setBackgroundColor(MaterialColors.getColor(root, R.attr.dire_bg_2))
        }


        with(item.player) {
            tvPlayerName.text = personaname ?: root.context.getString(R.string.anonym)
//            tvPlayerName.setOnClickListener {
//                onPlayerClick(accountId)
//            }
            root.setOnClickListener {
                onPlayerClick(accountId)
            }
            tvGold.text = totalGold.toString()
            tvLvl.text = level.toString()
            tvExpPerMinute.text = xpPerMin.toString()
            tvGoldPerMinute.text = goldPerMin.toString()
            val totalDamage = heroDamage + towerDamage
            tvDamage.text = totalDamage.toString()
            tvLastHits.text = lastHits.toString()
        }

        glide
            .load(rank.img)
            .placeholder(viewModifier.getCircularProgressDrawable())
            .into(ivRating)

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
                .error(viewModifier.getItemBackgroundGray())
                .apply(RequestOptions.bitmapTransform(GrayscaleTransformation()))
                .into(ivBackpack0)
            glide
                .load(get(1).img)
                .placeholder(viewModifier.getCircularProgressDrawable())
                .error(viewModifier.getItemBackgroundGray())
                .apply(RequestOptions.bitmapTransform(GrayscaleTransformation()))
                .into(ivBackpack1)
            glide
                .load(get(2).img)
                .placeholder(viewModifier.getCircularProgressDrawable())
                .error(viewModifier.getItemBackgroundGray())
                .apply(RequestOptions.bitmapTransform(GrayscaleTransformation()))
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
