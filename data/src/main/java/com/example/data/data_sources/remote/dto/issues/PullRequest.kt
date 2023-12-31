package com.example.data.data_sources.remote.dto.issues

import com.google.gson.annotations.SerializedName

data class PullRequest(
    @SerializedName("diff_url")
    val diffUrl: String,
    @SerializedName("html_url")
    val htmlUrl: String,
    @SerializedName("merged_at")
    val mergedAt: Any,
    @SerializedName("patch_url")
    val patchUrl: String,
    val url: String
)