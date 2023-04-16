package com.example.tinkofflab2023.presentation.fragment.player.overview.adapter

import com.example.tinkofflab2023.databinding.TextCenterItemBinding
import com.example.tinkofflab2023.presentation.delegateadapter.ViewBindingDelegateAdapter

//todo String == bad ?
class TextCenterDelegateAdapter :
    ViewBindingDelegateAdapter<String, TextCenterItemBinding>(TextCenterItemBinding::inflate) {
    override fun TextCenterItemBinding.onBind(item: String) {
        tvText.text = item
    }

    override fun isForViewType(item: Any): Boolean = item is String

    override fun String.getItemId(): Any = this

}
