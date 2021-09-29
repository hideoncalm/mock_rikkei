package com.rikkeisoft.mockrikkei.data.repository

import com.rikkeisoft.mockrikkei.data.model.New
import com.rikkeisoft.mockrikkei.data.model.NewResponse

interface NewRepository {
    suspend fun getLocalNews(): List<New>
    suspend fun insertNew(new: New)
    suspend fun deleteNew(new: New): Boolean

    suspend fun getNews(): NewResponse
}