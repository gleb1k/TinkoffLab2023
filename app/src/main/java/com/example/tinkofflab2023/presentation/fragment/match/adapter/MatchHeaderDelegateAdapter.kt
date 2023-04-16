package com.example.tinkofflab2023.presentation.fragment.match.adapter

import com.example.tinkofflab2023.data.remote.response.matches.MatchResponse
import com.example.tinkofflab2023.databinding.MatchHeaderBinding
import com.example.tinkofflab2023.presentation.delegateadapter.ViewBindingDelegateAdapter

class MatchHeaderDelegateAdapter : ViewBindingDelegateAdapter<MatchResponse, MatchHeaderBinding>
    (MatchHeaderBinding::inflate) {
    override fun MatchHeaderBinding.onBind(item: MatchResponse) {
        TODO("Not yet implemented")
    }

    override fun isForViewType(item: Any): Boolean {
        TODO("Not yet implemented")
    }

    override fun MatchResponse.getItemId(): Any {
        TODO("Not yet implemented")
    }
}
