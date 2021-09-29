package com.rikkeisoft.mockrikkei.di

import android.content.Context
import androidx.room.Room
import com.rikkeisoft.mockrikkei.data.source.local.MockDao
import com.rikkeisoft.mockrikkei.data.source.local.MockDatabase
import com.rikkeisoft.mockrikkei.data.source.remote.APIConfig.BASE_URL
import com.rikkeisoft.mockrikkei.data.source.remote.APIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(
        @ApplicationContext app: Context
    ): MockDatabase = Room.databaseBuilder(app, MockDatabase::class.java, "mock_db")
        .allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideMockDao(db: MockDatabase): MockDao = db.getMockDao()

    @Provides
    @Singleton
    fun provideOkhttpClient(): OkHttpClient = OkHttpClient()

    @Provides
    @Singleton
    fun provideRetrofitClient(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideAPIService(retrofit: Retrofit): APIService = retrofit.create(APIService::class.java)
}