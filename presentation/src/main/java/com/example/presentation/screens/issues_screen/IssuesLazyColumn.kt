package com.example.presentation.screens.issues_screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.example.presentation.model.IssuesUiModel
import com.example.presentation.utils.Locators

@Composable
fun IssuesLazyColumn(
    issuesList: List<IssuesUiModel>,
) {
    LazyColumn(
        modifier = Modifier
            .testTag(Locators.TAG_STRING_ISSUES_LIST)
            .padding(horizontal = 10.dp)
            .padding(top = 4.dp)
            .padding(bottom = 2.dp)
    ) {
        itemsIndexed(items = issuesList){ index, issueUiModel ->
            IssueItem(
                issuesUiModel = issueUiModel,
                index = index,
            )
            Divider()
        }
    }
}