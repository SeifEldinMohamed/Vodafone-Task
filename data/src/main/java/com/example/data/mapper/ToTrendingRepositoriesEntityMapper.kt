package com.example.data.mapper

import com.example.data.data_sources.local.entities.TrendingRepositoriesEntity
import com.example.data.data_sources.remote.dto.TrendingGithubDataModel

fun TrendingGithubDataModel.toTrendingRepositoriesEntity(): List<TrendingRepositoriesEntity> {
    return this.items.map { item ->
        TrendingRepositoriesEntity(
            id = item.id,
            name = item.name,
            avatar = item.owner.avatarUrl,
            description = item.description,
            forks = item.forks,
            language = item.language ?: "",
            fullName = item.fullName,
            stars = item.stargazersCount,
            url = item.url,
            owner = item.owner.login
        )
    }
}

