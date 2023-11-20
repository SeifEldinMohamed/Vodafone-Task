package com.example.presentation.mapper

import com.example.domain.model.IssuesDomainModel
import com.example.presentation.model.IssuesUiModel

fun IssuesDomainModel.toIssuesUiModel(): IssuesUiModel {
    return IssuesUiModel(
        id = id,
        title = title,
        author = author,
        date = date,
        state = state
    )
}