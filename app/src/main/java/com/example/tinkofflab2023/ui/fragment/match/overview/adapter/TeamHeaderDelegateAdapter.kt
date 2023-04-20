package com.example.tinkofflab2023.ui.fragment.match.overview.adapter

import com.example.tinkofflab2023.databinding.TeamHeaderItemBinding
import com.example.tinkofflab2023.ui.delegateadapter.ViewBindingDelegateAdapter

//todo String == плохо?
class TeamHeaderDelegateAdapter: ViewBindingDelegateAdapter<String, TeamHeaderItemBinding>
    (TeamHeaderItemBinding::inflate){
    override fun TeamHeaderItemBinding.onBind(item: String) {
        tvTeam.text = item
    }

    override fun isForViewType(item: Any): Boolean = item is String

    override fun String.getItemId(): Any = this
}
