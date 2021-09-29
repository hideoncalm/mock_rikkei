package com.rikkeisoft.mockrikkei.data.repository.imp

import com.rikkeisoft.mockrikkei.data.model.New
import com.rikkeisoft.mockrikkei.data.model.NewResponse
import com.rikkeisoft.mockrikkei.data.repository.NewRepository
import com.rikkeisoft.mockrikkei.data.source.NewDataSource
import javax.inject.Inject

class NewRepositoryImp @Inject constructor(
    private val local: NewDataSource.Local,
    private val remote: NewDataSource.Remote
) : NewRepository {
    override suspend fun getLocalNews(): List<New> = local.getNews()

    override suspend fun insertNew(new: New) = local.insetNew(new)

    override suspend fun deleteNew(new: New): Boolean = local.deleteNew(new)

    override suspend fun getNews(): NewResponse = remote.getNews()
}