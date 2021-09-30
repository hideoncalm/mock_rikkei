package com.rikkeisoft.mockrikkei.data.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "news")
data class New(
    @SerializedName("new_id")
    @PrimaryKey
    val id: Int,
    @SerializedName("feed")
    val feed: String? = "",
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("thumb_img")
    @ColumnInfo(name = "thumb")
    val imageThumb: String? = "",
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("author")
    val author: String? = "",
    @SerializedName("publish_date")
    @ColumnInfo(name = "publish_date")
    val date: Int = 0,
    @SerializedName("detail_url")
    @ColumnInfo(name = "detail_url")
    val detailUrl: String? = ""
) : Parcelable {

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<New>() {
            override fun areItemsTheSame(oldItem: New, newItem: New): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: New, newItem: New): Boolean {
                return oldItem == newItem
            }

        }
    }

}
