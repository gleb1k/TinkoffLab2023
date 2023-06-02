package com.example.tinkofflab2023.ui.fragment.match.adapter

import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.core.delegateadapter.ViewBindingDelegateAdapter
import com.example.tinkofflab2023.databinding.TeamOutcomeItemBinding
import com.example.tinkofflab2023.ui.model.MatchTeamOutcomeItem
import com.google.android.material.color.MaterialColors

class TeamOutcomeDelegateAdapter :
    ViewBindingDelegateAdapter<MatchTeamOutcomeItem, TeamOutcomeItemBinding>
        (TeamOutcomeItemBinding::inflate) {
    override fun TeamOutcomeItemBinding.onBind(item: MatchTeamOutcomeItem) {
        with(item) {
            tvKills.text = "$summaryKills"
            tvDeaths.text = "$summaryDeaths"
            tvAssists.text = "$summaryAssists"
            tvNet.text = "$summaryNet"
        }
        if (item.isRadiant)
            root.setBackgroundColor(MaterialColors.getColor(root, R.attr.radiant_bg_2))
        else
            root.setBackgroundColor(MaterialColors.getColor(root, R.attr.dire_bg_2))
    }

    override fun isForViewType(item: Any): Boolean = item is MatchTeamOutcomeItem

    override fun MatchTeamOutcomeItem.getItemId(): Any = isRadiant
}
