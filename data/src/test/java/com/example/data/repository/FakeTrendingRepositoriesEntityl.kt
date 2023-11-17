package com.example.data.repository

import com.example.data.data_sources.local.entities.TrendingRepositoriesEntity

val fakeTrendingRepositoryEntity = listOf(
    TrendingRepositoriesEntity(
        id = 12345,
        name = "seif",
        avatar = "https://fakeurl.com/avatar.png",
        description = "This is a fake repository.",
        forks = 10,
        language = "Kotlin",
        fullName = "fakeuser/fakerepo",
        stars = 50,
        url = "https://fakeurl.com/repo",
        owner = "Seif"
    )
)

val fakeTrendingRepositoryEntity2 = listOf(
    TrendingRepositoriesEntity(
        id = 12345,
        name = "seif",
        avatar = "https://fakeurl.com/avatar.png",
        description = "This is a fake repository.",
        forks = 10,
        language = "",
        fullName = "fakeuser/fakerepo",
        stars = 50,
        url = "https://fakeurl.com/repo",
        owner = "Seif"
    )
)