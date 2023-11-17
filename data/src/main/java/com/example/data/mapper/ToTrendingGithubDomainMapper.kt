package com.example.data.mapper

import com.example.data.data_sources.local.entities.TrendingRepositoriesEntity
import com.example.data.data_sources.remote.dto.TrendingGithubDataModel
import com.example.domain.model.TrendingGithubDomainModel

fun TrendingGithubDataModel.toTrendingGithubDomainModel(): List<TrendingGithubDomainModel> {
    return this.items.map { item ->
        TrendingGithubDomainModel(
            id = item.id,
            name = item.name,
            avatar = item.owner.avatarUrl,
            description = item.description,
            stars = item.stargazersCount,
            owner = item.owner.login
        )
    }
}

fun List<TrendingRepositoriesEntity>.toTrendingGithubDomainModel(): List<TrendingGithubDomainModel> {
    return this.map { item ->
        TrendingGithubDomainModel(
            id = item.id,
            name = item.name,
            avatar = item.avatar,
            description = item.description,
            stars = item.stars,
            owner = item.owner
        )
    }
}