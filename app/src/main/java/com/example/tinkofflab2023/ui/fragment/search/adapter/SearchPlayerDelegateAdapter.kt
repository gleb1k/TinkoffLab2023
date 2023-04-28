package com.example.tinkofflab2023.ui.fragment.search.adapter

import android.content.Context
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.RequestManager
import com.example.tinkofflab2023.data.remote.response.search.SearchPlayerResponse
import com.example.tinkofflab2023.databinding.SearchPlayerItemBinding
import com.example.tinkofflab2023.ui.delegateadapter.ViewBindingDelegateAdapter
import com.example.tinkofflab2023.utils.Converter

//todo как провайдить контекст в адаптеры? или сразу дравабле в конструктор передавать?
class SearchPlayerDelegateAdapter(
    private val glide: RequestManager,
    private val onItemClick: (String) -> Unit,
    private val context: Context
) : ViewBindingDelegateAdapter<SearchPlayerResponse, SearchPlayerItemBinding>(
    SearchPlayerItemBinding::inflate
) {
    override fun SearchPlayerItemBinding.onBind(item: SearchPlayerResponse) {

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

        root.setOnClickListener {
            onItemClick(item.accountId)
        }
    }

    override fun isForViewType(item: Any): Boolean = item is SearchPlayerResponse

    override fun SearchPlayerResponse.getItemId(): Any = accountId
}