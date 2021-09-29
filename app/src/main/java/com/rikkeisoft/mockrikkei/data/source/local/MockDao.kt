package com.rikkeisoft.mockrikkei.data.source.local

import androidx.room.*
import com.rikkeisoft.mockrikkei.data.model.New
import com.rikkeisoft.mockrikkei.data.model.Popular

@Dao
interface MockDao {
    @Query("select * from news")
    suspend fun getNews(): List<New>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNew(new: New)

    @Delete
    suspend fun deleteNew(new: New): Int

    @Query("select * from events")
    suspend fun getPopulars(): List<Popular>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertPopular(popular: Popular)

    @Delete
    suspend fun deletePopular(popular: Popular): Int
}