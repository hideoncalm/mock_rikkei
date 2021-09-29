package com.rikkeisoft.mockrikkei.ui.home.popular.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.rikkeisoft.mockrikkei.base.BaseAdapter
import com.rikkeisoft.mockrikkei.base.BaseViewHolder
import com.rikkeisoft.mockrikkei.base.OnButtonClickListener
import com.rikkeisoft.mockrikkei.base.OnItemClickListener
import com.rikkeisoft.mockrikkei.data.model.Popular
import com.rikkeisoft.mockrikkei.databinding.ItemHomePopularBinding

class HomePopularAdapter(
    private val listener: OnItemClickListener<Popular>,
    private val buttonListener: OnButtonClickListener<Popular>
) : BaseAdapter<Popular, HomePopularAdapter.HomePopularHolder>(Popular.diffCallback, listener) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomePopularHolder {
        return HomePopularHolder(
            ItemHomePopularBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), listener, buttonListener
        )
    }

    class HomePopularHolder(
        private val binding: ItemHomePopularBinding,
        private val listener: OnItemClickListener<Popular>,
        private val buttonListener: OnButtonClickListener<Popular>
    ) : BaseViewHolder<Popular>(binding, listener) {

        init {
            binding.buttonJoin.setOnClickListener {
                itemData?.let { it1 -> buttonListener.onButtonClick(it1) }
            }
        }

        override fun onBindData(itemData: Popular) {
            super.onBindData(itemData)
        }
    }
}