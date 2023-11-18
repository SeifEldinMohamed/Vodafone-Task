package com.example.domain.repository

import androidx.paging.PagingData
import com.example.domain.model.TrendingGithubDomainModel
import kotlinx.coroutines.flow.Flow

interface TrendingRepository {
    fun fetchTrendingGithub(isForceFetch:Boolean): Flow<PagingData<TrendingGithubDomainModel>>
}