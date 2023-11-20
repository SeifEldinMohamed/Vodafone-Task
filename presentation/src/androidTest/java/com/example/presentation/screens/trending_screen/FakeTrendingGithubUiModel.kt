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
val trendingGithubUiModel2 = TrendingGithubUiModel(
    id = 1234,
    name = "seif",
    avatar = "https://fakeurl.com/avatar.png",
    description = "This is a fake repository.",
    stars = 50,
    owner = "Seif"
)
val fakeTrendingGithubListUiModel= listOf(
    trendingGithubUiModel,
    trendingGithubUiModel2
)

val fakeTrendingGithubLazyPagingUiModel = createFakeTrendingLazyPagingItemsUiModel()

fun createFakeTrendingLazyPagingItemsUiModel(): Flow<PagingData<TrendingGithubUiModel>> {
    return flowOf(PagingData.from(fakeTrendingGithubListUiModel))
}
