package com.example.presentation.screens.trending_screen

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.presentation.common_components.AppBar
import com.example.presentation.screens.trending_screen.preview.fakeTrendingGithubListUiModel
import com.example.presentation.screens.trending_screen.ui_state.TrendingUiState
import com.example.presentation.theme.VodafoneTaskTheme
import com.example.presentation.utils.Locators.TAG_STRING_TRENDING_APP_BAR_TITLE_LABEL

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TrendingGithubScreen(
    trendingUiState: TrendingUiState,
    onPulledToRefresh: (Boolean) -> Unit,
    onRefreshButtonClicked: (Boolean) -> Unit,
    onItemClicked: (owner: String, repoName: String) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        AppBar(titleTag = TAG_STRING_TRENDING_APP_BAR_TITLE_LABEL)
        TrendingGithubSwipeRefresh(
            trendingUiState = trendingUiState,
            onPulledToRefresh = onPulledToRefresh,
            onRefreshButtonClicked = onRefreshButtonClicked,
            onItemClicked = { owner, repoName -> onItemClicked(owner, repoName) }
        )
    }
}

@ExperimentalMaterialApi
@Preview(showSystemUi = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun PreviewTrendingGithubScreenLoading() {
    TrendingGithubScreen(
        trendingUiState = TrendingUiState(isLoading = true),
        onPulledToRefresh = {},
        onRefreshButtonClicked = {},
        onItemClicked = { _, _ -> }
    )
}

@ExperimentalMaterialApi
@Preview(showSystemUi = true, backgroundColor = 0xFFFFFF)
@Composable
fun PreviewTrendingGithubScreen() {
    VodafoneTaskTheme(darkTheme = false, dynamicColor = false) {
        TrendingGithubScreen(
            trendingUiState = TrendingUiState(
                isLoading = false,
                trendingGithubList = fakeTrendingGithubListUiModel
            ), onPulledToRefresh = {},
            onRefreshButtonClicked = {},
            onItemClicked = { _, _ -> }
        )
    }
}