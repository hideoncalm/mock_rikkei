package com.rikkeisoft.mockrikkei.ui.home.news.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.rikkeisoft.mockrikkei.base.BaseAdapter
import com.rikkeisoft.mockrikkei.base.BaseViewHolder
import com.rikkeisoft.mockrikkei.base.OnItemClickListener
import com.rikkeisoft.mockrikkei.data.model.New
import com.rikkeisoft.mockrikkei.databinding.ItemHomeNewsBinding
import com.rikkeisoft.mockrikkei.utils.loadImageFromUrl

class HomeNewsAdapter(
    private val listener: OnItemClickListener<New>
) : BaseAdapter<New, HomeNewsAdapter.HomeNewsHolder>(New.diffCallback, listener) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeNewsHolder = HomeNewsHolder(
        ItemHomeNewsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ), listener
    )

    class HomeNewsHolder(
        private val binding: ItemHomeNewsBinding,
        private val listener: OnItemClickListener<New>
    ) : BaseViewHolder<New>(binding, listener) {

        override fun onBindData(itemData: New) {
            super.onBindData(itemData)
        }
    }
}