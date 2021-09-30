package com.rikkeisoft.mockrikkei.data.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
    val id : Int ,
    val title : String,
    val slug : String? = ""
) : Parcelable {
    
    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Category>() {
            override fun areItemsTheSame(oldItem: Category, CategoryItem: Category): Boolean {
                return oldItem.id == CategoryItem.id
            }

            override fun areContentsTheSame(oldItem: Category, CategoryItem: Category): Boolean {
                return oldItem == CategoryItem
            }

        }
    }
}
