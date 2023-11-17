package com.example.presentation.screens.trending_screen

import com.example.domain.model.TrendingGithubDomainModel

val trendingGithubDomainModel = TrendingGithubDomainModel(
    id = 12345,
    name = "seif",
    avatar = "https://fakeurl.com/avatar.png",
    description = "This is a fake repository.",
    stars = 50,
    owner = "Seif"
)
val fakeTrendingGithubListDomainModel = listOf(
    trendingGithubDomainModel
)