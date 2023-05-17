package com.example.tinkofflab2023.ui.fragment.match.adapter

import com.example.tinkofflab2023.core.delegateadapter.ViewBindingDelegateAdapter
import com.example.tinkofflab2023.databinding.TeamHeaderItemBinding

class TeamHeaderDelegateAdapter : ViewBindingDelegateAdapter<String, TeamHeaderItemBinding>
    (TeamHeaderItemBinding::inflate) {
    override fun TeamHeaderItemBinding.onBind(item: String) {
        tvTeam.text = item
    }

    override fun isForViewType(item: Any): Boolean = item is String

    override fun String.getItemId(): Any = this
}
