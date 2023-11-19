package com.example.presentation.model

data class RepositoryDetailsUiModel(
    val id:Int,
    val name: String,
    val avatar: String,
    val description: String,
    val forks: String,
    val language: String,
    val fullName: String,
    val stars: String,
    val url: String,
    val owner: String
)