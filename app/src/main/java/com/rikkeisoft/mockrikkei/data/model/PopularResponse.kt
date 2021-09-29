package com.rikkeisoft.mockrikkei.data.model

import com.google.gson.annotations.SerializedName

data class PopularResponse(
    @SerializedName("status")
    val status: Int,
    @SerializedName("events")
    val populars: List<Popular>
)