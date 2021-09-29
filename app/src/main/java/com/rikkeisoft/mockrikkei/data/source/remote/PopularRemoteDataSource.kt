package com.rikkeisoft.mockrikkei.data.source.remote

import com.rikkeisoft.mockrikkei.data.model.PopularResponse
import com.rikkeisoft.mockrikkei.data.source.PopularDataSource
import javax.inject.Inject

class PopularRemoteDataSource @Inject constructor(
    private val apiService: APIService
) : PopularDataSource.Remote {

    override suspend fun getPopulars(): PopularResponse = apiService.getPopulars()
}