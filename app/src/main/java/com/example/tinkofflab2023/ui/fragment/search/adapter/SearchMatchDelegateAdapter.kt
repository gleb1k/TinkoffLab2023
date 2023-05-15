package com.example.tinkofflab2023.ui.fragment.search.adapter

import com.example.tinkofflab2023.core.delegateadapter.ViewBindingDelegateAdapter
import com.example.tinkofflab2023.data.Constants
import com.example.tinkofflab2023.data.remote.response.matches.MatchResponse
import com.example.tinkofflab2023.databinding.SearchMatchItemBinding
import com.example.tinkofflab2023.ui.util.ViewModifier

class SearchMatchDelegateAdapter(
    private val viewModifier: ViewModifier,
    private val onItemClick: (String) -> Unit,
) :
    ViewBindingDelegateAdapter<MatchResponse, SearchMatchItemBinding>(SearchMatchItemBinding::inflate) {

    override fun SearchMatchItemBinding.onBind(item: MatchResponse) {
        tvGameMode.text = Constants.gameModes[item.gameMode]
        tvLobbyType.text = Constants.lobbyTypes[item.lobbyType]
        tvMatch.text = item.matchId
        tvTime.text = viewModifier.epochToDate(item.startTime)

        cardView.setOnClickListener {
            onItemClick(item.matchId)
        }
    }

    override fun isForViewType(item: Any): Boolean = item is MatchResponse

    override fun MatchResponse.getItemId(): Any = matchId
}
