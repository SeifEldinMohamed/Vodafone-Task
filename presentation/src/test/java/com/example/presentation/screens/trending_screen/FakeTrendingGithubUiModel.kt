package com.example.presentation.screens.trending_screen

import com.example.presentation.model.TrendingGithubUiModel

val trendingGithubUiModel = TrendingGithubUiModel(
    id = 12345,
    name = "seif",
    avatar = "https://fakeurl.com/avatar.png",
    description = "This is a fake repository.",
    stars = 50,
    owner = "Seif"
)
val fakeTrendingGithubListUiModel = listOf(
    trendingGithubUiModel
)