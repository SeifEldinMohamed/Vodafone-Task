package com.example.data.mapper

import com.example.data.data_sources.local.entities.TrendingRepositoriesEntity
import com.example.data.data_sources.remote.dto.trending_repositories.Item
import com.example.data.data_sources.remote.dto.trending_repositories.TrendingGithubDataModel

fun Item.toTrendingRepositoriesEntity(): TrendingRepositoriesEntity {
    return TrendingRepositoriesEntity(
            id = id,
            name = name,
            avatar = owner.avatarUrl,
            description = description,
            forks = forks,
            language = language ?: "",
            fullName = fullName,
            stars = stargazersCount,
            url = url,
            owner = owner.login
        )
}

