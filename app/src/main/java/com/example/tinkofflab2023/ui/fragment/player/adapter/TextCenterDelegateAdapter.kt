package com.example.tinkofflab2023.ui.fragment.player.adapter

import com.example.tinkofflab2023.core.delegateadapter.ViewBindingDelegateAdapter
import com.example.tinkofflab2023.databinding.TextCenterItemBinding

class TextCenterDelegateAdapter :
    ViewBindingDelegateAdapter<String, TextCenterItemBinding>(TextCenterItemBinding::inflate) {
    override fun TextCenterItemBinding.onBind(item: String) {
        tvText.text = item
    }

    override fun isForViewType(item: Any): Boolean = item is String

    override fun String.getItemId(): Any = this

}
