package com.example.tinkofflab2023.ui.fragment.search.recyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.RequestManager
import com.example.tinkofflab2023.data.remote.response.search.SearchResponse

class SearchPlayersAdapter(
    private val glide: RequestManager,
    private val onItemClick: (String) -> Unit,
) : ListAdapter<SearchResponse, SearchPlayersHolder>(object :
    DiffUtil.ItemCallback<SearchResponse>() {
    override fun areItemsTheSame(oldItem: SearchResponse, newItem: SearchResponse): Boolean =
        oldItem.accountId == newItem.accountId


    override fun areContentsTheSame(oldItem: SearchResponse, newItem: SearchResponse): Boolean =
        oldItem == newItem

}
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchPlayersHolder =
        SearchPlayersHolder.create(parent,glide,onItemClick)


    override fun onBindViewHolder(holder: SearchPlayersHolder, position: Int) {
        holder.onBind(currentList[position])
    }
}
