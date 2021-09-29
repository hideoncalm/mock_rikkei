package com.rikkeisoft.mockrikkei.data.model

import com.google.gson.annotations.SerializedName

data class NewResponse(
    @SerializedName("status")
    val status: Int,
    @SerializedName("news")
    val news: List<New>
)