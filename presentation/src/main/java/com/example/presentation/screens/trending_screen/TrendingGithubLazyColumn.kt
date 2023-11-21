package com.example.presentation.screens.trending_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import com.example.presentation.model.TrendingGithubUiModel
import com.example.presentation.utils.Locators.TAG_STRING_TRENDING_LIST

@Composable
fun TrendingGithubLazyColumn(
    trendingGithubList: LazyPagingItems<TrendingGithubUiModel>,
    onItemClicked: (owner: String, repoName: String) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .testTag(TAG_STRING_TRENDING_LIST)
            .padding(horizontal = 10.dp)
            .padding(top = 4.dp)
            .padding(bottom = 2.dp)
    ) {
        items(
            count = trendingGithubList.itemCount,
            key = trendingGithubList.itemKey { trendingGithubList -> trendingGithubList.id },
            contentType = trendingGithubList.itemContentType { "repos" }
        ) { index ->
            val trendingGithubUiModel = trendingGithubList[index]
            if (trendingGithubUiModel != null) {
                TrendingItem(
                    trendingGithubUiModel = trendingGithubUiModel,
                    index = index,
                    onItemClicked = { owner, repoName -> onItemClicked(owner, repoName) }
                )
            }
        }

        if (!trendingGithubList.loadState.append.endOfPaginationReached && trendingGithubList.itemCount != 0) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
        }
    }
}