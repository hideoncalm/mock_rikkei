package com.rikkeisoft.mockrikkei.data.source.remote

import com.rikkeisoft.mockrikkei.data.model.NewResponse
import com.rikkeisoft.mockrikkei.data.model.PopularResponse
import com.rikkeisoft.mockrikkei.data.source.remote.APIConfig.BASE_NEW
import com.rikkeisoft.mockrikkei.data.source.remote.APIConfig.BASE_POPULAR
import retrofit2.http.GET

interface APIService {
    /**
     * Get all news
     * http://meetup.rikkei.org/api/v0/listNews
     */
    @GET(BASE_NEW)
    suspend fun getNews(): NewResponse

    /**
     * Get all populars
     * http://meetup.rikkei.org/api/v0/listPopularEvents
     */
    @GET(BASE_POPULAR)
    suspend fun getPopulars(): PopularResponse
}