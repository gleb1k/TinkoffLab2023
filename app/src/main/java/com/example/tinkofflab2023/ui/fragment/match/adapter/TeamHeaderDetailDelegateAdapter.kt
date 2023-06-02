package com.example.tinkofflab2023.ui.fragment.match.adapter

import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.core.delegateadapter.ViewBindingDelegateAdapter
import com.example.tinkofflab2023.databinding.TeamHeaderDetailItemBinding

class TeamHeaderDetailDelegateAdapter :
    ViewBindingDelegateAdapter<String, TeamHeaderDetailItemBinding>
        (TeamHeaderDetailItemBinding::inflate) {
    override fun TeamHeaderDetailItemBinding.onBind(item: String) {
        val context = root.context

        tvTeam.text = item

        if (item == context.getString(R.string.the_radiant))
            tvTeam.setTextColor(context.getColor(R.color.radiant_green))
        else
            tvTeam.setTextColor(context.getColor(R.color.dire_red))
    }

    override fun isForViewType(item: Any): Boolean = item is String

    override fun String.getItemId(): Any = this
}
