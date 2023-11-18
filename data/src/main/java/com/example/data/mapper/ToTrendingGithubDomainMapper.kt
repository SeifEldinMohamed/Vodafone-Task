package com.example.data.mapper

import com.example.data.data_sources.local.entities.TrendingRepositoriesEntity
import com.example.data.data_sources.remote.dto.trending_repositories.TrendingGithubDataModel
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

fun TrendingRepositoriesEntity.toTrendingGithubDomainModel(): TrendingGithubDomainModel {
    return TrendingGithubDomainModel(
        id = this.id,
        name = this.name,
        avatar = this.avatar,
        description = this.description,
        stars = this.stars,
        owner = this.owner
    )
}