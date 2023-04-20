package com.example.tinkofflab2023.ui.fragment.search.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.tinkofflab2023.data.remote.response.search.SearchResponse
import com.example.tinkofflab2023.databinding.SearchPlayerItemBinding
import com.example.tinkofflab2023.utils.Converter

class SearchPlayersHolder(
    private val binding: SearchPlayerItemBinding,
    private val glide: RequestManager,
    private val onItemClick: (String) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(player: SearchResponse) {
        binding.run {
            tvLastMatch.text = "Last match: ${Converter.lastMatchTime(player.lastMatchTime)}"
            tvNickname.text = player.personaname
            glide
                .load(player.avatarfull)
                .into(ivIcon)

            //todo ?? обычно не работает кликабельность всей вьюшки
//            root.setOnClickListener {
//                onItemClick(player.accountId.toString())
//            }
            tvNickname.setOnClickListener {
                onItemClick(player.accountId.toString())
            }
        }
    }

    companion object {
        fun create(
            parent: ViewGroup,
            glide: RequestManager,
            onItemClick: (String) -> Unit,
        ): SearchPlayersHolder = SearchPlayersHolder(
            binding = SearchPlayerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            glide,
            onItemClick = onItemClick
        )
    }
}
