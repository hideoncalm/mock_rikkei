package com.rikkeisoft.mockrikkei.data.source.remote

import com.rikkeisoft.mockrikkei.data.model.NewResponse
import com.rikkeisoft.mockrikkei.data.source.NewDataSource
import javax.inject.Inject

class NewRemoteDataSource @Inject constructor(
    private val apiService: APIService
) : NewDataSource.Remote {

    override suspend fun getNews(): NewResponse = apiService.getNews()
}