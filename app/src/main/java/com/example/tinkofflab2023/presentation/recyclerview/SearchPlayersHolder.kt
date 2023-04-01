package com.example.tinkofflab2023.presentation.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.tinkofflab2023.data.remote.response.search.SearchResponse
import com.example.tinkofflab2023.databinding.SearchPlayerItemBinding

class SearchPlayersHolder(
    private val binding: SearchPlayerItemBinding,
    private val glide: RequestManager,
    private val onItemClick: (Int) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(player: SearchResponse) {
        binding.run {
            tvLastMatch.text = player.lastMatchTime
            tvNickname.text = player.personaname
            glide
                .load(player.avatarfull)
                .into(ivIcon)

            //todo ?? обычно не работает кликабельность всей вьюшки
            root.setOnClickListener {
                onItemClick
            }
        }
    }

    companion object {
        fun create(
            parent: ViewGroup,
            glide: RequestManager,
            onItemClick: (Int) -> Unit,
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
