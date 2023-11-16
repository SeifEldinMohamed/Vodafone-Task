package com.example.domain.repository

import com.example.domain.model.TrendingGithubDomainModel

interface TrendingRepository {
    suspend fun fetchTrendingGithub(isForceFetch:Boolean): List<TrendingGithubDomainModel>
}