package com.example.domain.usecase.issues

import com.example.domain.model.IssueState
import com.example.domain.model.IssuesDomainModel

val issuesDomainModel = IssuesDomainModel(
    id = 12345,
    title = "",
    author = "",
    date = "",
    state = IssueState.Open
)
val fakeIssuesDomainModel = listOf(
    issuesDomainModel
)