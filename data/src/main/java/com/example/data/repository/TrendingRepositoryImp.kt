package com.example.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.data.data_sources.local.LocalDataSource
import com.example.data.data_sources.remote.TrendingGithubApi
import com.example.data.data_sources.remote.dto.trending_repositories.TrendingGithubDataModel
import com.example.data.mapper.toTrendingGithubDomainModel
import com.example.data.mapper.toTrendingRepositoriesEntity
import com.example.domain.model.TrendingGithubDomainModel
import com.example.domain.repository.TrendingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class TrendingRepositoryImp(
    private val trendingGithubApi: TrendingGithubApi,
    private val localDataSource: LocalDataSource
) : TrendingRepository {
    override fun fetchTrendingGithub(isForceFetch: Boolean): Flow<PagingData<TrendingGithubDomainModel>> =
        flow{
            if (localDataSource.readIsFirstTime() || isForceFetch) {
                // fetch
                val trendingGithubDataModel = trendingGithubApi.fetchTrendingRepositories().body() as TrendingGithubDataModel

                // cache
                localDataSource.insertTrendingRepositories(trendingGithubDataModel.items.map { it.toTrendingRepositoriesEntity() })

                if (localDataSource.readIsFirstTime()) // only update it when first time to enter app only
                    localDataSource.saveIsFirstTime(false)

                // read cached data
                emitAll(
                    Pager(
                        config = PagingConfig(pageSize = 4, enablePlaceholders = false),
                        pagingSourceFactory = { localDataSource.getTrendingRepositories() }
                    ).flow
                        .map { pagingData ->
                            pagingData.map { it.toTrendingGithubDomainModel() }
                        }
                )
            } else {
                // read cached data
                emitAll(
                    Pager(
                        config = PagingConfig(pageSize = 4, enablePlaceholders = false),
                        pagingSourceFactory = { localDataSource.getTrendingRepositories() }
                    ).flow
                        .map { pagingData ->
                            pagingData.map { it.toTrendingGithubDomainModel() }
                        }
                )
            }
        }
}
/**
 * first time it loads pageSize * 3
 * **/