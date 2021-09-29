package com.rikkeisoft.mockrikkei.data.repository

import com.rikkeisoft.mockrikkei.data.model.Popular
import com.rikkeisoft.mockrikkei.data.model.PopularResponse

interface PopularRepository {
    suspend fun getLocalPopulars(): List<Popular>
    suspend fun insertPopular(Popular: Popular)
    suspend fun deletePopular(Popular: Popular): Boolean

    suspend fun getPopulars(): PopularResponse
}