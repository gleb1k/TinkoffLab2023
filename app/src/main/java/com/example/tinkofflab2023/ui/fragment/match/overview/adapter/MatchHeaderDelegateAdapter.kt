package com.example.tinkofflab2023.ui.fragment.match.overview.adapter

import com.example.tinkofflab2023.core.delegateadapter.ViewBindingDelegateAdapter
import com.example.tinkofflab2023.core.util.Converter
import com.example.tinkofflab2023.databinding.MatchHeaderBinding
import com.example.tinkofflab2023.ui.model.MatchItem

class MatchHeaderDelegateAdapter : ViewBindingDelegateAdapter<MatchItem, MatchHeaderBinding>
    (MatchHeaderBinding::inflate) {
    override fun MatchHeaderBinding.onBind(item: MatchItem) {
        with(item) {
            tvMatchId.text = "$matchId"
            tvMatchTime.text = "${Converter.matchDuration(duration)}"
            tvDireKills.text = "$direScore"
            tvRadiantKills.text = "$radiantScore"
            tvWinner.text = "${Converter.winSide(radiantWin)}"
        }
    }

    override fun isForViewType(item: Any): Boolean = item is MatchItem

    override fun MatchItem.getItemId(): Any = matchId
}
