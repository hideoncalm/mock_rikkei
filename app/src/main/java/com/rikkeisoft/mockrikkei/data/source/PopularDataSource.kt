package com.rikkeisoft.mockrikkei.data.source

import com.rikkeisoft.mockrikkei.data.model.Popular
import com.rikkeisoft.mockrikkei.data.model.PopularResponse

interface PopularDataSource {
    interface Local {
        suspend fun getPopulars(): List<Popular>
        suspend fun insertPopular(popular: Popular)
        suspend fun deletePopular(popular: Popular): Boolean
    }

    interface Remote {
        suspend fun getPopulars(): PopularResponse
    }

}