package com.example.presentation.screens.trending_screen.preview

import com.example.presentation.model.TrendingGithubUiModel

val trendingGithubUiModel = TrendingGithubUiModel(
    id = 12345,
    name = "seif",
    avatar = "https://fakeurl.com/avatar.png",
    description = "This is a fake repository. This is a fake repository. This is a fake repository. This is a fake repository. This is a fake repository.",
    stars = 50,
    owner = "SeifMohamed"
)
val fakeTrendingGithubListUiModel = listOf(
    trendingGithubUiModel,
    trendingGithubUiModel
)