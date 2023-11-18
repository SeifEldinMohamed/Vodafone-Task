package com.example.data.data_sources.remote.dto.trending_repositories

import com.google.gson.annotations.SerializedName

data class TrendingGithubDataModel(
    @SerializedName("incomplete_results") val incompleteResults: Boolean,
    val items: List<Item>,
    @SerializedName("total_count") val totalCount: Int
)