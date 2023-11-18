package com.example.data.data_sources.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.data_sources.local.entities.TrendingRepositoriesEntity

@Dao
interface TrendingRepositoriesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrendingRepositories(trendingRepositoriesEntity: List<TrendingRepositoriesEntity>)

    @Query("SELECT * FROM TRENDING_REPOSITORIES_TABLE")
    fun getTrendingRepositories(): PagingSource<Int, TrendingRepositoriesEntity>

}