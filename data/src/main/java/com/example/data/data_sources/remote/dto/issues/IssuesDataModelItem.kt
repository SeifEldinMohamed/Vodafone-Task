package com.example.data.data_sources.remote.dto.issues

import com.google.gson.annotations.SerializedName

data class IssuesDataModelItem(
    @SerializedName("active_lock_reason")
    val activeLockReason: Any,
    val assignee: Any,
    val assignees: List<Any>,
    @SerializedName("author_association")
    val authorAssociation: String,
    val body: String,
    @SerializedName("closed_at")
    val closedAt: Any,
    val comments: Int,
    @SerializedName("comments_url")
    val commentsUrl: String,
    @SerializedName("created_at")
    val createdAt: String,
    val draft: Boolean,
    @SerializedName("events_url")
    val eventsUrl: String,
    @SerializedName("html_url")
    val htmlUrl: String,
    val id: Int,
    val labels: List<Any>,
    @SerializedName("labels_url")
    val labelsUrl: String,
    val locked: Boolean,
    val milestone: Any,
    @SerializedName("node_id")
    val nodeId: String,
    val number: Int,
    @SerializedName("performed_via_github_app")
    val performedViaGithubApp: Any,
    @SerializedName("pull_request")
    val pullRequest: PullRequest,
    val reactions: Reactions,
    @SerializedName("repository_url")
    val repositoryUrl: String,
    val state: String,
    @SerializedName("state_reason")
    val stateReason: String,
    @SerializedName("timeline_url")
    val timelineUrl: String,
    val title: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    val url: String,
    val user: User
)