package com.example.vodafonetask.di

import com.example.data.data_sources.local.LocalDataSource
import com.example.data.data_sources.remote.TrendingGithubApi
import com.example.data.repository.TrendingRepositoryImp
import com.example.domain.repository.TrendingRepository
import com.example.domain.usecase.FetchTrendingGithubUseCase
import com.example.presentation.utils.DispatcherProvider
import com.example.presentation.utils.StandardDispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDispatcherProvider(): DispatcherProvider {
        return StandardDispatcherProvider()
    }

    @Provides
    @Singleton
    fun provideTrendingGithubRepository(
        trendingGithubApi: TrendingGithubApi,
        localDataSource: LocalDataSource
    ): TrendingRepository {
        return TrendingRepositoryImp(trendingGithubApi, localDataSource)
    }

    @Singleton
    @Provides
    fun provideFetchTrendingGithubUseCase(
        trendingRepository: TrendingRepository
    ): FetchTrendingGithubUseCase {
        return FetchTrendingGithubUseCase(trendingRepository)
    }
}