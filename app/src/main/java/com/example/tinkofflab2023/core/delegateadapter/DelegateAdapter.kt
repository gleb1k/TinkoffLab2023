package com.example.tinkofflab2023.core.delegateadapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder

interface DelegateAdapter {
    // same rv.adapter methods to delegate
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    fun onBindViewHolder(holder: ViewHolder, items: List<Any>, position: Int)
    fun onRecycled(holder: ViewHolder)

    /** to know that current adapter can work with item at position */
    fun isForViewType(items: List<Any>, position: Int): Boolean

    /** [DiffUtilCallback] uses this to know that two items are the same */
    fun itemId(item: Any): Any

    /** [DiffUtilCallback] uses this to know that two items has the same content */
    fun itemContent(item: Any): Any

    fun onAttachedToWindow(holder: ViewHolder)

    fun onDetachedFromWindow(holder: ViewHolder)
}
