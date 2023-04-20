package com.example.tinkofflab2023.ui.fragment.match.overview.adapter

import com.example.tinkofflab2023.ui.model.match.TeamOutcome
import com.example.tinkofflab2023.databinding.TeamOutcomeItemBinding
import com.example.tinkofflab2023.ui.delegateadapter.ViewBindingDelegateAdapter

class TeamOutcomeDelegateAdapter : ViewBindingDelegateAdapter<TeamOutcome, TeamOutcomeItemBinding>
    (TeamOutcomeItemBinding::inflate) {
    override fun TeamOutcomeItemBinding.onBind(item: TeamOutcome) {
        with(item) {
            tvKills.text = "$summaryKills"
            tvDeaths.text = "$summaryDeaths"
            tvAssists.text = "$summaryAssists"
            tvNet.text = "$summaryNet"
        }
    }

    override fun isForViewType(item: Any): Boolean = item is TeamOutcome

    override fun TeamOutcome.getItemId(): Any = isRadiant
}
