package com.example.vodafonetask.di

import com.example.data.data_sources.local.LocalDataSource
import com.example.data.data_sources.remote.IssuesApi
import com.example.data.data_sources.remote.RepoDetailsApi
import com.example.data.data_sources.remote.TrendingGithubApi
import com.example.data.repository.IssuesRepositoryImpl
import com.example.data.repository.RepoDetailsRepositoryImp
import com.example.data.repository.TrendingRepositoryImp
import com.example.domain.repository.IssuesRepository
import com.example.domain.repository.RepoDetailsRepository
import com.example.domain.repository.TrendingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideTrendingGithubRepository(
        trendingGithubApi: TrendingGithubApi,
        localDataSource: LocalDataSource
    ): TrendingRepository {
        return TrendingRepositoryImp(trendingGithubApi, localDataSource)
    }

    @Provides
    @Singleton
    fun provideRepoDetailsRepository(
        repoDetailsApi: RepoDetailsApi
    ): RepoDetailsRepository {
        return RepoDetailsRepositoryImp(repoDetailsApi)
    }

    @Provides
    @Singleton
    fun provideIssuesRepository(
        issuesApi: IssuesApi
    ): IssuesRepository {
        return IssuesRepositoryImpl(issuesApi)
    }
}