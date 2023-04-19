package com.example.tinkofflab2023.presentation.fragment.match.adapter

import com.example.tinkofflab2023.databinding.TeamHeaderItemBinding
import com.example.tinkofflab2023.presentation.delegateadapter.ViewBindingDelegateAdapter

//todo String == плохо?
class TeamHeaderDelegateAdapter: ViewBindingDelegateAdapter<String, TeamHeaderItemBinding>
    (TeamHeaderItemBinding::inflate){
    override fun TeamHeaderItemBinding.onBind(item: String) {
        tvTeam.text = item
    }

    override fun isForViewType(item: Any): Boolean = item is String

    override fun String.getItemId(): Any = this
}
