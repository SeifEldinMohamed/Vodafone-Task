package com.example.presentation.model

data class TrendingGithubUiModel(
    val id:Int,
    val name: String,
    val avatar: String,
    val description: String,
    val stars: Int,
    val owner: String
)