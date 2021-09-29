package com.rikkeisoft.mockrikkei.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<T>(
    private val binding: ViewBinding,
    private val listener: OnItemClickListener<T>
) : RecyclerView.ViewHolder(binding.root) {

    var itemData: T? = null

    init {
        itemView.setOnClickListener {
            itemData?.let { it1 -> listener.onItemClick(it1) }
        }
    }

    open fun onBindData(itemData: T) {
        this.itemData = itemData
    }
}