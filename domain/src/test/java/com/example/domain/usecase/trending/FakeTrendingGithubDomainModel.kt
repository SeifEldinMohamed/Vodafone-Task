package com.example.domain.usecase.trending

import androidx.paging.PagingData
import com.example.domain.model.TrendingGithubDomainModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf


private val trendingGithubDomainModel = TrendingGithubDomainModel(
    id = 12345,
    name = "seif",
    avatar = "https://fakeurl.com/avatar.png",
    description = "This is a fake repository.",
    stars = 50,
    owner = "Seif"
)

private val fakeTrendingGithubListDomainModel= listOf(
    trendingGithubDomainModel,
)


val fakeTrendingGithubLazyPagingDomainModel = createFakeTrendingLazyPagingItemsDomainModel()
private fun createFakeTrendingLazyPagingItemsDomainModel(): Flow<PagingData<TrendingGithubDomainModel>> {
    return flowOf(PagingData.from(fakeTrendingGithubListDomainModel))
}


