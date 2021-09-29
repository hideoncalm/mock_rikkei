package com.rikkeisoft.mockrikkei.di

import com.rikkeisoft.mockrikkei.data.repository.imp.PopularRepositoryImp
import com.rikkeisoft.mockrikkei.data.repository.NewRepository
import com.rikkeisoft.mockrikkei.data.repository.PopularRepository
import com.rikkeisoft.mockrikkei.data.repository.imp.NewRepositoryImp
import com.rikkeisoft.mockrikkei.data.source.NewDataSource
import com.rikkeisoft.mockrikkei.data.source.PopularDataSource
import com.rikkeisoft.mockrikkei.data.source.local.NewLocalDataSource
import com.rikkeisoft.mockrikkei.data.source.local.PopularLocalDataSource
import com.rikkeisoft.mockrikkei.data.source.remote.NewRemoteDataSource
import com.rikkeisoft.mockrikkei.data.source.remote.PopularRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    @Singleton
    fun provideNewLocalDataSource(local: NewLocalDataSource): NewDataSource.Local = local

    @Provides
    @Singleton
    fun provideNewRemoteDataSource(remote: NewRemoteDataSource): NewDataSource.Remote = remote

    @Provides
    @Singleton
    fun providePopularLocalDataSource(local: PopularLocalDataSource): PopularDataSource.Local =
        local

    @Provides
    @Singleton
    fun providePopularRemoteDataSource(remote: PopularRemoteDataSource): PopularDataSource.Remote =
        remote

    @Provides
    @Singleton
    fun provideNewRepository(repo: NewRepositoryImp): NewRepository = repo

    @Provides
    @Singleton
    fun providePopularRepository(repo: PopularRepositoryImp): PopularRepository = repo
}
