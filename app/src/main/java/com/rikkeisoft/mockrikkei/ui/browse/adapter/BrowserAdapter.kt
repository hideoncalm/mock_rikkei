package com.rikkeisoft.mockrikkei.ui.browse.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.rikkeisoft.mockrikkei.base.BaseAdapter
import com.rikkeisoft.mockrikkei.base.BaseViewHolder
import com.rikkeisoft.mockrikkei.base.OnButtonClickListener
import com.rikkeisoft.mockrikkei.base.OnItemClickListener
import com.rikkeisoft.mockrikkei.data.model.Category
import com.rikkeisoft.mockrikkei.databinding.ItemCategoryBinding

class BrowserAdapter(
    private val listener: OnItemClickListener<Category>,
    private val buttonListener: OnButtonClickListener<Category>
) : BaseAdapter<Category, BrowserAdapter.BrowserHolder>(Category.diffCallback, listener) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BrowserHolder = BrowserHolder(
        ItemCategoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ), listener, buttonListener
    )

    class BrowserHolder(
        private val binding: ItemCategoryBinding,
        private val listener: OnItemClickListener<Category>,
        private val buttonListener: OnButtonClickListener<Category>
    ) : BaseViewHolder<Category>(binding, listener) {

        init {
            binding.buttonForward.setOnClickListener {
                itemData?.let { itemData -> buttonListener.onButtonClick(itemData) }
            }
        }

        override fun onBindData(itemData: Category) {
            super.onBindData(itemData)
        }
    }
}
