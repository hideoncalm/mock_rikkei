package com.rikkeisoft.mockrikkei.ui.near.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.rikkeisoft.mockrikkei.base.BaseAdapter
import com.rikkeisoft.mockrikkei.base.BaseViewHolder
import com.rikkeisoft.mockrikkei.base.OnItemClickListener
import com.rikkeisoft.mockrikkei.data.model.Popular
import com.rikkeisoft.mockrikkei.databinding.ItemNewHorizontalBinding

class NearAdapter(
    private val listener: OnItemClickListener<Popular>
) : BaseAdapter<Popular, NearAdapter.NearAdapterHolder>(Popular.diffCallback, listener) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NearAdapterHolder = NearAdapterHolder(
        ItemNewHorizontalBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ), listener
    )

    class NearAdapterHolder(
        private val binding: ItemNewHorizontalBinding,
        private val listener: OnItemClickListener<Popular>
    ) : BaseViewHolder<Popular>(binding, listener) {

        override fun onBindData(itemData: Popular) {
            super.onBindData(itemData)
        }
    }
}
