package com.example.data.data_sources.remote.dto.issues

import com.google.gson.annotations.SerializedName

data class Reactions(
    @SerializedName("+1")
    val plusOne: Int,
    @SerializedName("-1")
    val minusOne: Int,
    val confused: Int,
    val eyes: Int,
    val heart: Int,
    val hooray: Int,
    val laugh: Int,
    val rocket: Int,
    @SerializedName("total_count")
    val totalCount: Int,
    val url: String
)