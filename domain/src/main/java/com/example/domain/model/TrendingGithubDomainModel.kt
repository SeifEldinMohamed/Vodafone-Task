package com.example.domain.model

data class TrendingGithubDomainModel(
    val id:Int,
    val name: String,
    val avatar: String,
    val description: String,
    val stars: Int,
    val owner: String
)