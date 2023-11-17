package com.example.presentation.screens.trending_screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.example.presentation.model.TrendingGithubUiModel
import com.example.presentation.utils.Locators.TAG_STRING_TRENDING_LIST

@Composable
fun TrendingGithubLazyColumn(
    trendingGithubList: List<TrendingGithubUiModel>,
    onItemClicked: (owner: String, repoName: String) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .testTag(TAG_STRING_TRENDING_LIST)
            .padding(horizontal = 10.dp)
    ) {
        itemsIndexed(trendingGithubList) { index, trendingGithubUiModel ->
            key(trendingGithubUiModel.id) {
                TrendingItem(
                    trendingGithubUiModel = trendingGithubUiModel,
                    index = index,
                    onItemClicked = { owner, repoName -> onItemClicked(owner, repoName) }
                )
                Divider()
            }
        }
    }
}