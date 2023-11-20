package com.example.presentation.model

import com.example.domain.model.IssueState

data class IssuesUiModel(
    val id:Int,
    val title: String,
    val author: String,
    val date: String,
    val state: IssueState,
)