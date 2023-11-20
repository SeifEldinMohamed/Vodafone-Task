package com.example.presentation.screens.issues

import com.example.domain.model.IssueState
import com.example.presentation.model.IssuesUiModel

val fakeIssuesUiModelList = listOf(
    IssuesUiModel(
        id = 12345,
        title = "Title 1",
        author = "Seif",
        date = "Created At: 2023-01-01, 12:00 PM",
        state = IssueState.Open
    )
)


