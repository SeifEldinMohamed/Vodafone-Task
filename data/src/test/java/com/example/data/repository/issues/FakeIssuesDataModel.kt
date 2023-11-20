package com.example.data.repository.issues


import com.example.data.data_sources.remote.dto.issues.IssuesDataModelItem
import com.example.data.data_sources.remote.dto.issues.PullRequest
import com.example.data.data_sources.remote.dto.issues.Reactions
import com.example.data.data_sources.remote.dto.issues.User

val fakeIssuesDataModelList = arrayListOf(
    IssuesDataModelItem(
        activeLockReason = "SomeLockReason",
        assignee = Any(),
        assignees = listOf(),
        authorAssociation = "MEMBER",
        body = "This is the body of the issue",
        closedAt = "",
        comments = 3,
        commentsUrl = "https://api.github.com/issues/1/comments",
        createdAt = "2023-01-01T12:00:00Z",
        draft = false,
        eventsUrl = "https://api.github.com/issues/1/events",
        htmlUrl = "https://github.com/user/repo/issues/1",
        id = 1,
        labels = listOf(),
        labelsUrl = "https://api.github.com/issues/1/labels",
        locked = false,
        milestone = "",
        nodeId = "abc123",
        number = 1,
        performedViaGithubApp = "",
        pullRequest = PullRequest(
            diffUrl = "https://github.com/user/repo/pull/1.diff",
            htmlUrl = "https://github.com/user/repo/pull/1",
            mergedAt = "",
            patchUrl = "https://github.com/user/repo/pull/1.patch",
            url = "https://api.github.com/pulls/1"
        ),
        reactions = Reactions(
            plusOne = 5,
            minusOne = 1,
            confused = 0,
            eyes = 2,
            heart = 10,
            hooray = 3,
            laugh = 4,
            rocket = 2,
            totalCount = 27,
            url = "https://api.github.com/issues/1/reactions"
        ),
        repositoryUrl = "https://api.github.com/repos/user/repo",
        state = "open",
        stateReason = "SomeReason",
        timelineUrl = "https://github.com/user/repo/issues/1/timeline",
        title = "Example Issue Title",
        updatedAt = "2023-01-02T10:30:00Z",
        url = "https://api.github.com/issues/1",
        user = User(
            avatar_url = "https://avatars.githubusercontent.com/u/123",
            events_url = "https://api.github.com/users/exampleUser/events{/privacy}",
            followers_url = "https://api.github.com/users/exampleUser/followers",
            following_url = "https://api.github.com/users/exampleUser/following{/other_user}",
            gists_url = "https://api.github.com/users/exampleUser/gists{/gist_id}",
            gravatar_id = "someGravatarId",
            html_url = "https://github.com/exampleUser",
            id = 123,
            login = "exampleUser",
            node_id = "userNodeId",
            organizations_url = "https://api.github.com/users/exampleUser/orgs",
            received_events_url = "https://api.github.com/users/exampleUser/received_events",
            repos_url = "https://api.github.com/users/exampleUser/repos",
            site_admin = false,
            starred_url = "https://api.github.com/users/exampleUser/starred{/owner}{/repo}",
            subscriptions_url = "https://api.github.com/users/exampleUser/subscriptions",
            type = "User",
            url = "https://api.github.com/users/exampleUser"
        )
    )
)


