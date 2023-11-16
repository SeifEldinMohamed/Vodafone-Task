package com.example.data.repository

import com.example.data.data_sources.local.LocalDataSource
import com.example.data.data_sources.remote.TrendingGithubApi
import com.example.data.data_sources.remote.dto.TrendingGithubDataModel
import com.example.data.mapper.toTrendingGithubDomainModel
import com.example.data.mapper.toTrendingRepositoriesEntity
import com.example.domain.model.TrendingGithubDomainModel
import com.example.domain.repository.TrendingRepository

class TrendingRepositoryImp(
    private val trendingGithubApi: TrendingGithubApi,
    private val localDataSource: LocalDataSource
) : TrendingRepository {
    override suspend fun fetchTrendingGithub(isForceFetch: Boolean): List<TrendingGithubDomainModel> {
        return if (localDataSource.readIsFirstTime() || isForceFetch) {
            // fetch
            val trendingGithubDataModel = trendingGithubApi.fetchTrendingRepositories().body() as TrendingGithubDataModel
            // cache
            localDataSource.insertTrendingRepositories(trendingGithubDataModel.toTrendingRepositoriesEntity())

            if (localDataSource.readIsFirstTime()) // only update it when first time to enter app only
                localDataSource.saveIsFirstTime(false)

            trendingGithubDataModel.toTrendingGithubDomainModel()
        } else {
            localDataSource.getTrendingRepositories().toTrendingGithubDomainModel()
        }
    }
}