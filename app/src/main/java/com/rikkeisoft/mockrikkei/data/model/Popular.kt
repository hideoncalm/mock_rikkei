package com.rikkeisoft.mockrikkei.data.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "events")
data class Popular(
    @SerializedName("id")
    @PrimaryKey
    val id: Int,
    @SerializedName("status")
    val status: String? = "",
    @SerializedName("photo")
    val photo: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("description_raw")
    val desRaw: String? = "",
    @SerializedName("description_html")
    val desHtml: String? = "",
    @SerializedName("schedule_permanent")
    val schePermanent: String? = "",
    @SerializedName(" schedule_date_warning")
    val scheWarning: String? = "",
    @SerializedName("schedule_ time_alert")
    val scheTimeAlert: String? = "",
    @SerializedName("schedule_start_date")
    val scheStartDate: String? = "",
    @SerializedName("schedule_end_date")
    val scheEndDate: String? = "",
    @SerializedName("schedule_one_day_event")
    val scheOnenDay: Boolean = false,
    @SerializedName("schedule_extra")
    val scheExtra: String? = "",
    @SerializedName("going_count")
    val goingCount: Int = 10,
    @SerializedName("went_count")
    val wentCount: Int = 10,
    @SerializedName(" my_status")
    val myStatus: Int = 10,
) : Parcelable {
    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Popular>() {
            override fun areItemsTheSame(oldItem: Popular, newItem: Popular): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Popular, newItem: Popular): Boolean {
                return oldItem == newItem
            }

        }
    }
}
