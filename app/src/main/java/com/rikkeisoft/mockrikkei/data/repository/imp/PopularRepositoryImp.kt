package com.rikkeisoft.mockrikkei.data.repository.imp

import com.rikkeisoft.mockrikkei.data.model.Popular
import com.rikkeisoft.mockrikkei.data.model.PopularResponse
import com.rikkeisoft.mockrikkei.data.repository.PopularRepository
import com.rikkeisoft.mockrikkei.data.source.PopularDataSource
import javax.inject.Inject

class PopularRepositoryImp @Inject constructor(
    private val local: PopularDataSource.Local,
    private val remote: PopularDataSource.Remote
) : PopularRepository {
    override suspend fun getLocalPopulars(): List<Popular> = local.getPopulars()

    override suspend fun insertPopular(Popular: Popular) = local.insertPopular(Popular)

    override suspend fun deletePopular(Popular: Popular): Boolean = local.deletePopular(Popular)

    override suspend fun getPopulars(): PopularResponse = remote.getPopulars()
}
