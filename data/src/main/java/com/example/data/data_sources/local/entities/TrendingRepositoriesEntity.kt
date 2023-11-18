package com.example.data.data_sources.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.Constants.Companion.TRENDING_REPOSITORIES_TABLE

@Entity(tableName = TRENDING_REPOSITORIES_TABLE)
data class TrendingRepositoriesEntity(
    @PrimaryKey(autoGenerate = false)
    val id:Int,
    val name: String,
    val avatar: String,
    val description: String,
    val forks: Int,
    val language: String,
    val fullName: String,
    val stars: Int,
    val url: String,
    val owner: String
)