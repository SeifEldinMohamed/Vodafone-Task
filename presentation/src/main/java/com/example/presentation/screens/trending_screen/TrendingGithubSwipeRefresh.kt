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
import com.example.presentation.common_components.AnimateShimmerList
import com.example.presentation.common_components.ErrorSection
import com.example.presentation.screens.trending_screen.preview.fakeTrendingGithubListUiModel
import com.example.presentation.screens.trending_screen.ui_state.TrendingUiState
import com.example.presentation.theme.LightGreen
import com.example.presentation.theme.VodafoneTaskTheme

@ExperimentalMaterialApi
@Composable
fun TrendingGithubSwipeRefresh(
    trendingUiState: TrendingUiState,
    onPulledToRefresh: (Boolean) -> Unit,
    onRefreshButtonClicked: (Boolean) -> Unit,
    onItemClicked: (owner: String, repoName: String) -> Unit
) {
    val refreshingState = rememberPullRefreshState(false, { onPulledToRefresh(true) })
    Box(
        Modifier
            .fillMaxSize()
            .pullRefresh(refreshingState)
    ) {
        when {
            trendingUiState.isLoading -> {
                AnimateShimmerList()
            }

            trendingUiState.isError -> {
                ErrorSection(onRefreshButtonClicked = onRefreshButtonClicked)
            }

            else -> {
                TrendingGithubLazyColumn(trendingGithubList = trendingUiState.trendingGithubList,
                    onItemClicked = { owner, repoName -> onItemClicked(owner, repoName) })
            }
        }

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
        TrendingGithubSwipeRefresh(
            trendingUiState = TrendingUiState(trendingGithubList = fakeTrendingGithubListUiModel),
            onPulledToRefresh = {},
            onRefreshButtonClicked = {},
            onItemClicked = { _, _ ->  }
        )
    }
}