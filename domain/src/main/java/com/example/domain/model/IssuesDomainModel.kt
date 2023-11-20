package com.example.domain.model

data class IssuesDomainModel(
    val id:Int,
    val title: String,
    val author: String,
    val date: String,
    val state: IssueState,
)