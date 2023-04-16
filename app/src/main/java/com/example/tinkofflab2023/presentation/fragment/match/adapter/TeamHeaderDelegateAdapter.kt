package com.example.tinkofflab2023.presentation.fragment.match.adapter

import com.example.tinkofflab2023.databinding.TeamHeaderItemBinding
import com.example.tinkofflab2023.presentation.delegateadapter.ViewBindingDelegateAdapter

class TeamHeaderDelegateAdapter: ViewBindingDelegateAdapter<String, TeamHeaderItemBinding>
    (TeamHeaderItemBinding::inflate){
    override fun TeamHeaderItemBinding.onBind(item: String) {
        TODO("Not yet implemented")
    }

    override fun isForViewType(item: Any): Boolean {
        TODO("Not yet implemented")
    }

    override fun String.getItemId(): Any {
        TODO("Not yet implemented")
    }
}
