package com.example.data.mapper

import com.example.data.data_sources.remote.dto.repo_details.RepositoryDetailsDataModel
import com.example.domain.model.RepositoryDetailsDomainModel

fun RepositoryDetailsDataModel.toRepositoryDetailsDomainModel(): RepositoryDetailsDomainModel {
    return RepositoryDetailsDomainModel(
        id = this.id,
        name = this.name,
        avatar = this.owner.avatarUrl,
        description = this.description,
        stars = this.stargazersCount,
        owner = this.owner.login,
        forks = this.forks,
        language = this.language ?: "",
        fullName = this.fullName,
        url = this.url,
        createdAt = this.createdAt
    )
}