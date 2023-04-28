package com.example.tinkofflab2023.ui.fragment.match.overview.adapter

import com.example.tinkofflab2023.ui.model.match.TeamOutcomeItem
import com.example.tinkofflab2023.databinding.TeamOutcomeItemBinding
import com.example.tinkofflab2023.ui.delegateadapter.ViewBindingDelegateAdapter

class TeamOutcomeDelegateAdapter : ViewBindingDelegateAdapter<TeamOutcomeItem, TeamOutcomeItemBinding>
    (TeamOutcomeItemBinding::inflate) {
    override fun TeamOutcomeItemBinding.onBind(item: TeamOutcomeItem) {
        with(item) {
            tvKills.text = "$summaryKills"
            tvDeaths.text = "$summaryDeaths"
            tvAssists.text = "$summaryAssists"
            tvNet.text = "$summaryNet"
        }
    }

    override fun isForViewType(item: Any): Boolean = item is TeamOutcomeItem

    override fun TeamOutcomeItem.getItemId(): Any = isRadiant
}
