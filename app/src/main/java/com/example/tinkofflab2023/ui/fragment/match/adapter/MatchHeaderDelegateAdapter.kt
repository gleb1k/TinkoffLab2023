package com.example.tinkofflab2023.ui.fragment.match.adapter

import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.core.delegateadapter.ViewBindingDelegateAdapter
import com.example.tinkofflab2023.databinding.MatchHeaderBinding
import com.example.tinkofflab2023.ui.model.MatchItem
import com.example.tinkofflab2023.ui.util.ViewModifier

class MatchHeaderDelegateAdapter(
    private val viewModifier: ViewModifier
) : ViewBindingDelegateAdapter<MatchItem, MatchHeaderBinding>
    (MatchHeaderBinding::inflate) {
    override fun MatchHeaderBinding.onBind(item: MatchItem) {
        val context = root.context
        if (item.radiantWin)
            tvWinner.setTextColor(context.getColor(R.color.radiant_green))
        else
            tvWinner.setTextColor(context.getColor(R.color.dire_red))

        with(item) {
            tvMatchTime.text = viewModifier.matchDuration(duration)
            tvDireKills.text = "$direScore"
            tvRadiantKills.text = "$radiantScore"
            tvWinner.text = viewModifier.winSide(radiantWin)
        }
    }

    override fun isForViewType(item: Any): Boolean = item is MatchItem

    override fun MatchItem.getItemId(): Any = matchId
}
