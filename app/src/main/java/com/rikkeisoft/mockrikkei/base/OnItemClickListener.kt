package com.rikkeisoft.mockrikkei.base

interface OnItemClickListener<T> {
    fun onItemClick(item: T)
}

interface OnButtonClickListener<T> {
    fun onButtonClick(item: T)
}