package com.rikkeisoft.mockrikkei.data.source.local

import com.rikkeisoft.mockrikkei.data.model.Popular
import com.rikkeisoft.mockrikkei.data.source.PopularDataSource
import javax.inject.Inject

class PopularLocalDataSource @Inject constructor(
    private val mockDao: MockDao
) : PopularDataSource.Local {
    override suspend fun getPopulars(): List<Popular> = mockDao.getPopulars()

    override suspend fun insertPopular(popular: Popular) = mockDao.insertPopular(popular)

    override suspend fun deletePopular(popular: Popular): Boolean = mockDao.deletePopular(popular) > 0
}