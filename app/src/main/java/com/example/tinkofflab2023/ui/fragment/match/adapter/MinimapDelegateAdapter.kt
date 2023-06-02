package com.example.tinkofflab2023.ui.fragment.match.adapter

import com.example.tinkofflab2023.core.delegateadapter.ViewBindingDelegateAdapter
import com.example.tinkofflab2023.databinding.MinimapItemBinding
import com.example.tinkofflab2023.ui.model.MatchBuildingsState
import com.example.tinkofflab2023.ui.util.ViewModifier

class MinimapDelegateAdapter(
    private val viewModifier: ViewModifier
) : ViewBindingDelegateAdapter<MatchBuildingsState, MinimapItemBinding>
    (MinimapItemBinding::inflate) {
    override fun MinimapItemBinding.onBind(item: MatchBuildingsState) {
        val finalState = item.copy(
            barracksStatusRadiant = viewModifier.getBarracksInfo(item.barracksStatusRadiantNum),
            barracksStatusDire =  viewModifier.getBarracksInfo(item.barracksStatusDireNum),
            towerStatusRadiant = viewModifier.getTowerInfo(item.towerStatusRadiantNum),
            towerStatusDire =  viewModifier.getTowerInfo(item.towerStatusDireNum)
        )

        minimapView.set(finalState)
    }

    override fun isForViewType(item: Any): Boolean = item is MatchBuildingsState

    //хз
    override fun MatchBuildingsState.getItemId(): Any =
        (barracksStatusDireNum + barracksStatusRadiantNum) / 13

}
