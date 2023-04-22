package com.example.tinkofflab2023.ui.fragment.match.overview.adapter

import com.example.tinkofflab2023.data.remote.response.matches.MatchResponse
import com.example.tinkofflab2023.databinding.MatchHeaderBinding
import com.example.tinkofflab2023.ui.delegateadapter.ViewBindingDelegateAdapter
import com.example.tinkofflab2023.utils.Converter

class MatchHeaderDelegateAdapter : ViewBindingDelegateAdapter<MatchResponse, MatchHeaderBinding>
    (MatchHeaderBinding::inflate) {
    override fun MatchHeaderBinding.onBind(item: MatchResponse) {
        with (item) {
            tvMatchId.text = "$matchId"
            tvMatchTime.text = "${Converter.matchDuration(duration)}"
            tvDireKills.text = "$direScore"
            tvRadiantKills.text = "$radiantScore"
            tvWinner.text = "${Converter.winSide(radiantWin)}"
        }
    }

    override fun isForViewType(item: Any): Boolean = item is MatchResponse

    override fun MatchResponse.getItemId(): Any = matchId
}