package com.example.vodafonetask.di

import com.example.domain.repository.RepoDetailsRepository
import com.example.domain.repository.TrendingRepository
import com.example.domain.usecase.FetchRepositoryDetailsUseCase
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

    @Singleton
    @Provides
    fun provideFetchTrendingGithubUseCase(
        trendingRepository: TrendingRepository
    ): FetchTrendingGithubUseCase {
        return FetchTrendingGithubUseCase(trendingRepository)
    }

    @Singleton
    @Provides
    fun provideFetchRepositoryDetailsUseCase(
        repoDetailsRepository: RepoDetailsRepository
    ): FetchRepositoryDetailsUseCase {
        return FetchRepositoryDetailsUseCase(repoDetailsRepository)
    }
}