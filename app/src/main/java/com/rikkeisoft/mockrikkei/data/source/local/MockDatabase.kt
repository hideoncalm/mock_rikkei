package com.rikkeisoft.mockrikkei.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rikkeisoft.mockrikkei.data.model.New
import com.rikkeisoft.mockrikkei.data.model.Popular

@Database(
    version = 1,
    entities = [New::class, Popular::class],
    exportSchema = false
)
abstract class MockDatabase : RoomDatabase() {
    abstract fun getMockDao(): MockDao
}
