package com.example.presentation.screens.trending_screen

import androidx.paging.PagingData
import com.example.presentation.model.TrendingGithubUiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

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

val fakeTrendingGithubLazyPagingUiModel = createFakeTrendingLazyPagingItemsUiModel()
private fun createFakeTrendingLazyPagingItemsUiModel(): Flow<PagingData<TrendingGithubUiModel>> {
    return flowOf(PagingData.from(fakeTrendingGithubListUiModel))
}
