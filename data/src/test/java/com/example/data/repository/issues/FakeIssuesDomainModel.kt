package com.example.data.repository.issues


import com.example.domain.model.IssueState
import com.example.domain.model.IssuesDomainModel

val fakeIssuesDomainModelList =
    listOf(
        IssuesDomainModel(
            id = 1,
            title = "Example Issue Title",
            author = "MEMBER",
            date = "Created At: 2023-1-1, 12:0 PM",
            state = IssueState.Open
        )
    )

