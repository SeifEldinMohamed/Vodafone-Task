package com.example.presentation.screens.trending_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.compose.LazyPagingItems
import com.example.presentation.model.TrendingGithubUiModel
import com.example.presentation.screens.trending_screen.preview.createFakeTrendingLazyPagingItemsUiModel
import com.example.presentation.theme.LightGreen
import com.example.presentation.theme.VodafoneTaskTheme

@ExperimentalMaterialApi
@Composable
fun TrendingGithubContent(
    trendingRepositoriesLazyPagingItems: LazyPagingItems<TrendingGithubUiModel>,
    onPulledToRefresh: (Boolean) -> Unit,
    onItemClicked: (owner: String, repoName: String) -> Unit
) {
    val refreshingState = rememberPullRefreshState(false, { onPulledToRefresh(true) })
    Box(
        Modifier
            .fillMaxSize()
            .pullRefresh(refreshingState)
    ) {
        TrendingGithubLazyColumn(
            trendingGithubList = trendingRepositoriesLazyPagingItems
        ) { owner, repoName -> onItemClicked(owner, repoName) }

        PullRefreshIndicator(
            refreshing = false,
            state = refreshingState,
            modifier = Modifier.align(Alignment.TopCenter),
            contentColor = LightGreen
        )
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun PreviewSwipeRefreshCompose() {
    VodafoneTaskTheme {
        TrendingGithubContent(
            trendingRepositoriesLazyPagingItems = createFakeTrendingLazyPagingItemsUiModel(),
            onPulledToRefresh = {},
        ) { _, _ -> }
    }
}