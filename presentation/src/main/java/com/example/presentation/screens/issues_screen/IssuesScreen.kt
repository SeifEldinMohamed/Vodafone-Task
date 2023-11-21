package com.example.presentation.screens.issues_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.presentation.R
import com.example.presentation.common_components.AppBar
import com.example.presentation.common_components.ErrorSection
import com.example.presentation.common_components.shimmer.issues.AnimateShimmerIssuesList
import com.example.presentation.model.IssuesUiModel
import com.example.presentation.screens.issues_screen.preview.issuesUiModelPreviewData
import com.example.presentation.screens.issues_screen.ui_state.IssuesUiState
import com.example.presentation.theme.LightGreen
import com.example.presentation.theme.VodafoneTaskTheme
import com.example.presentation.utils.Locators.TAG_STRING_ISSUES_APP_BAR_TITLE_LABEL

@Composable
fun IssuesScreen(
    issuesUiState: IssuesUiState,
    onRefreshList: () -> Unit,
    onBackArrowClicked: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colorScheme.background)) {
        AppBar(
            titleText = stringResource(R.string.issues_app_bar_title),
            titleTag = TAG_STRING_ISSUES_APP_BAR_TITLE_LABEL,
            onBackArrowClicked = { onBackArrowClicked() }
        )
        when {
            issuesUiState.isLoading -> {
                AnimateShimmerIssuesList()
            }
            issuesUiState.issuesList != null -> {
                IssuesContent(issuesUiState.issuesList, onPulledToRefresh = onRefreshList)
            }
            else ->{
                ErrorSection(
                    onRefreshButtonClicked = onRefreshList,
                    customErrorExceptionUiModel = issuesUiState.customErrorExceptionUiModel
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun IssuesContent(
    issuesList: List<IssuesUiModel>,
    onPulledToRefresh: () -> Unit
) {
    val refreshingState = rememberPullRefreshState(false, { onPulledToRefresh() })
    Box(
        Modifier
            .fillMaxSize()
            .pullRefresh(refreshingState)
    ) {
        IssuesLazyColumn(
            issuesList = issuesList
        )

        PullRefreshIndicator(
            refreshing = false,
            state = refreshingState,
            modifier = Modifier.align(Alignment.TopCenter),
            contentColor = LightGreen
        )
    }

}

@ExperimentalMaterialApi
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewTrendingGithubScreen() {
    VodafoneTaskTheme(darkTheme = false) {
        IssuesScreen(
            issuesUiState = IssuesUiState(
                issuesList  = listOf(issuesUiModelPreviewData)
            ),
            onRefreshList = {},
            onBackArrowClicked = {}
        )
    }
}