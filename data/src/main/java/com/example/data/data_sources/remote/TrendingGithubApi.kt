package com.example.data.data_sources.remote

import com.example.data.data_sources.remote.dto.trending_repositories.TrendingGithubDataModel
import retrofit2.Response
import retrofit2.http.GET

interface TrendingGithubApi {
    @GET("search/repositories?q=language")
    suspend fun fetchTrendingRepositories(): Response<TrendingGithubDataModel>
}