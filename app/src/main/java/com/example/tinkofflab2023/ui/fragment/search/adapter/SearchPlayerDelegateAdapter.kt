package com.example.tinkofflab2023.ui.fragment.search.adapter

import com.bumptech.glide.RequestManager
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.core.delegateadapter.ViewBindingDelegateAdapter
import com.example.tinkofflab2023.data.remote.response.search.SearchPlayerResponse
import com.example.tinkofflab2023.databinding.SearchPlayerItemBinding
import com.example.tinkofflab2023.ui.util.ViewModifier
import javax.inject.Inject

class SearchPlayerDelegateAdapter(
    private val viewModifier: ViewModifier,
    private val glide: RequestManager,
    private val onItemClick: (String) -> Unit,
) : ViewBindingDelegateAdapter<SearchPlayerResponse, SearchPlayerItemBinding>(
    SearchPlayerItemBinding::inflate
) {


    override fun SearchPlayerItemBinding.onBind(item: SearchPlayerResponse) {
        val context = this.root.context

        tvLastMatch.text =
            "${context.getString(R.string.last_played)} ${viewModifier.toDate(item.lastMatchTime)}"
        tvNickname.text = item.personaname
        glide
            .load(item.avatarfull)
            .placeholder(viewModifier.getCircularProgressDrawable())
            .into(ivIcon)

        cardView.setOnClickListener {
            onItemClick(item.accountId)
        }
    }

    override fun isForViewType(item: Any): Boolean = item is SearchPlayerResponse

    override fun SearchPlayerResponse.getItemId(): Any = accountId
}
