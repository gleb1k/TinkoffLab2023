package com.example.tinkofflab2023.ui.fragment.search.adapter

import android.content.Context
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.RequestManager
import com.example.tinkofflab2023.core.delegateadapter.ViewBindingDelegateAdapter
import com.example.tinkofflab2023.core.util.Converter
import com.example.tinkofflab2023.data.remote.response.search.SearchPlayerResponse
import com.example.tinkofflab2023.databinding.SearchPlayerItemBinding

class SearchPlayerDelegateAdapter(
    private val glide: RequestManager,
    private val onItemClick: (String) -> Unit,
    private val context: Context
) : ViewBindingDelegateAdapter<SearchPlayerResponse, SearchPlayerItemBinding>(
    SearchPlayerItemBinding::inflate
) {
    override fun SearchPlayerItemBinding.onBind(item: SearchPlayerResponse) {

        //todo context
        this.root.context

        val circularProgressDrawable = CircularProgressDrawable(context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        tvLastMatch.text = "Last match: ${Converter.toDate(item.lastMatchTime)}"
        tvNickname.text = item.personaname
        glide
            .load(item.avatarfull)
            .placeholder(circularProgressDrawable)
            .into(ivIcon)

        cardView.setOnClickListener {
            onItemClick(item.accountId)
        }
    }

    override fun isForViewType(item: Any): Boolean = item is SearchPlayerResponse

    override fun SearchPlayerResponse.getItemId(): Any = accountId
}
