package com.example.data.data_sources.remote

import com.example.data.data_sources.remote.dto.TrendingGithubDataModel
import retrofit2.Response
import retrofit2.http.GET

interface TrendingGithubApi {
    @GET("search/repositories?q=language=+sort:stars")
    suspend fun fetchTrendingRepositories(): Response<TrendingGithubDataModel>
}