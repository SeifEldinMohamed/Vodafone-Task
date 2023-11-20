package com.example.data.repository.trending


import androidx.paging.PagingData
import com.example.domain.model.TrendingGithubDomainModel


val fakeTrendingGithubDomainModel =
    listOf(
        TrendingGithubDomainModel(
            id = 12345,
            name = "seif",
            avatar = "https://fakeurl.com/avatar.png",
            description = "This is a fake repository.",
            stars = 50,
            owner = "Seif"
        )
    )

val fakeTrendingGithubPagingDataDomainModel = PagingData.from(fakeTrendingGithubDomainModel)


val fakeTrendingGithubDomainModel2 = listOf(
    TrendingGithubDomainModel(
        id = 12345,
        name = "seif",
        avatar = "https://fakeurl.com/avatar.png",
        description = "This is a fake repository.",
        stars = 50,
        owner = "Seif"
    )
)
