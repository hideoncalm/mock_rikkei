package com.rikkeisoft.mockrikkei.data.source.local

import com.rikkeisoft.mockrikkei.data.model.New
import com.rikkeisoft.mockrikkei.data.source.NewDataSource
import javax.inject.Inject

class NewLocalDataSource @Inject constructor(
    private val mockDao: MockDao
) : NewDataSource.Local {
    override suspend fun getNews(): List<New> = mockDao.getNews()

    override suspend fun insetNew(new: New) = mockDao.insertNew(new)

    override suspend fun deleteNew(new: New): Boolean = mockDao.deleteNew(new) > 0
}