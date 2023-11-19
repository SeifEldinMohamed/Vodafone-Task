package com.example.presentation.mapper

import com.example.domain.model.RepositoryDetailsDomainModel
import com.example.presentation.model.RepositoryDetailsUiModel

fun RepositoryDetailsDomainModel.toRepositoryDetailsUIModel(): RepositoryDetailsUiModel {
    return RepositoryDetailsUiModel(
        id = id,
        name = name,
        avatar = avatar,
        description = description,
        stars = stars.toString(),
        owner = owner,
        forks = forks.toString(),
        language = language,
        fullName = fullName,
        url = url
    )
}