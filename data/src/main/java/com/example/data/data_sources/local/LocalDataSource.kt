package com.example.data.data_sources.local

import com.example.data.data_sources.local.data_store.DataStorePreference
import com.example.data.data_sources.local.entities.TrendingRepositoriesEntity

class LocalDataSource(
    private val trendingRepositoriesDao: TrendingRepositoriesDao,
    private val datsStorePreference: DataStorePreference
) {
    suspend fun getTrendingRepositories(): List<TrendingRepositoriesEntity> {
        return trendingRepositoriesDao.getTrendingRepositories()
    }

    suspend fun insertTrendingRepositories(trendingRepositoriesEntity: List<TrendingRepositoriesEntity>) {
        trendingRepositoriesDao.insertTrendingRepositories(trendingRepositoriesEntity)
    }

    suspend fun readIsFirstTime(): Boolean {
        return datsStorePreference.readIsFirstTime()
    }

    suspend fun saveIsFirstTime(isFirstTime: Boolean) {
        datsStorePreference.saveIsFirstTime(isFirstTime = isFirstTime)
    }
}
