package com.example.presentation.mapper

import com.example.domain.model.TrendingGithubDomainModel
import com.example.presentation.model.TrendingGithubUiModel

fun TrendingGithubDomainModel.toTrendingGithubUIModel(): TrendingGithubUiModel {
    return TrendingGithubUiModel(
        id = id,
        name = name,
        avatar = avatar,
        description = description,
        stars = stars,
        owner = owner
    )
}