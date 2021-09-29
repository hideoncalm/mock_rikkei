package com.rikkeisoft.mockrikkei.data.source

import com.rikkeisoft.mockrikkei.data.model.New
import com.rikkeisoft.mockrikkei.data.model.NewResponse

interface NewDataSource {
    interface Remote {
        suspend fun getNews(): NewResponse
    }

    interface Local {
        suspend fun getNews(): List<New>
        suspend fun insetNew(new: New)
        suspend fun deleteNew(new: New): Boolean
    }
}