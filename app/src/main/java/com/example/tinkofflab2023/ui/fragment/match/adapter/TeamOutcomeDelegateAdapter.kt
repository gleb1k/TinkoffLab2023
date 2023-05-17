package com.example.tinkofflab2023.ui.fragment.match.adapter

import com.example.tinkofflab2023.core.delegateadapter.ViewBindingDelegateAdapter
import com.example.tinkofflab2023.databinding.TeamOutcomeItemBinding
import com.example.tinkofflab2023.ui.model.MatchTeamOutcomeItem

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
    }

    override fun isForViewType(item: Any): Boolean = item is MatchTeamOutcomeItem

    override fun MatchTeamOutcomeItem.getItemId(): Any = isRadiant
}
