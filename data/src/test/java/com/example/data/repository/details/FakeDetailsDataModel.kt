package com.example.data.repository.details


import com.example.data.data_sources.remote.dto.repo_details.RepositoryDetailsDataModel
import com.example.data.data_sources.remote.dto.trending_repositories.Owner

val fakeDetailsDataModel = RepositoryDetailsDataModel(
    allowForking = true,
    archiveUrl = "https://api.github.com/repos/owner/repo/{archive_format}{/ref}",
    archived = false,
    assigneesUrl = "https://api.github.com/repos/owner/repo/assignees{/user}",
    blobsUrl = "https://api.github.com/repos/owner/repo/git/blobs{/sha}",
    branchesUrl = "https://api.github.com/repos/owner/repo/branches{/branch}",
    cloneUrl = "https://github.com/owner/repo.git",
    collaboratorsUrl = "https://api.github.com/repos/owner/repo/collaborators{/collaborator}",
    commentsUrl = "https://api.github.com/repos/owner/repo/comments{/number}",
    commitsUrl = "https://api.github.com/repos/owner/repo/commits{/sha}",
    compareUrl = "https://api.github.com/repos/owner/repo/compare/{base}...{head}",
    contentsUrl = "https://api.github.com/repos/owner/repo/contents/{+path}",
    contributorsUrl = "https://api.github.com/repos/owner/repo/contributors",
    createdAt = "2023-01-01T14:00:00Z",
    defaultBranch = "main",
    deploymentsUrl = "https://api.github.com/repos/owner/repo/deployments",
    description = "A sample repository",
    disabled = false,
    downloadsUrl = "https://api.github.com/repos/owner/repo/downloads",
    eventsUrl = "https://api.github.com/repos/owner/repo/events",
    fork = false,
    forks = 10,
    forksCount = 10,
    forksUrl = "https://api.github.com/repos/owner/repo/forks",
    fullName = "owner/repo",
    gitCommitsUrl = "https://api.github.com/repos/owner/repo/git/commits{/sha}",
    gitRefsUrl = "https://api.github.com/repos/owner/repo/git/refs{/sha}",
    gitTagsUrl = "https://api.github.com/repos/owner/repo/git/tags{/sha}",
    gitUrl = "git://github.com/owner/repo.git",
    hasDiscussions = true,
    hasDownloads = true,
    hasIssues = true,
    hasPages = true,
    hasProjects = true,
    hasWiki = true,
    homepage = "https://github.com/owner/repo",
    hooksUrl = "https://api.github.com/repos/owner/repo/hooks",
    htmlUrl = "https://github.com/owner/repo",
    id = 123,
    isTemplate = false,
    issueCommentUrl = "https://api.github.com/repos/owner/repo/issues/comments{/number}",
    issueEventsUrl = "https://api.github.com/repos/owner/repo/issues/events{/number}",
    issuesUrl = "https://api.github.com/repos/owner/repo/issues{/number}",
    keysUrl = "https://api.github.com/repos/owner/repo/keys{/key_id}",
    labelsUrl = "https://api.github.com/repos/owner/repo/labels{/name}",
    language = "Kotlin",
    languagesUrl = "https://api.github.com/repos/owner/repo/languages",
    license = Any(), // Replace with the appropriate license object
    mergesUrl = "https://api.github.com/repos/owner/repo/merges",
    milestonesUrl = "https://api.github.com/repos/owner/repo/milestones{/number}",
    mirrorUrl = Any(),
    name = "repo",
    networkCount = 5,
    nodeId = "MDEwOlJlcG9zaXRvcnkxMjM=",
    notificationsUrl = "https://api.github.com/repos/owner/repo/notifications{?since,all,participating}",
    openIssues = 3,
    openIssuesCount = 3,
    owner = Owner(
        avatarUrl = "https://avatars.githubusercontent.com/u/owner_id?v=4",
        eventsUrl = "https://api.github.com/users/owner/events{/privacy}",
        followersUrl = "https://api.github.com/users/owner/followers",
        followingUrl = "https://api.github.com/users/owner/following{/other_user}",
        gistsUrl = "https://api.github.com/users/owner/gists{/gist_id}",
        gravatarId = "",
        htmlUrl = "https://github.com/owner",
        id = 456,
        login = "owner",
        nodeId = "MDQ6VXNlcjU2Nzk3NzY=",
        organizationsUrl = "https://api.github.com/users/owner/orgs",
        receivedEventsUrl = "https://api.github.com/users/owner/received_events",
        reposUrl = "https://api.github.com/users/owner/repos",
        siteAdmin = false,
        starredUrl = "https://api.github.com/users/owner/starred{/owner}{/repo}",
        subscriptionsUrl = "https://api.github.com/users/owner/subscriptions",
        type = "User",
        url = "https://api.github.com/users/owner"
    ),
    isPrivate = false,
    pullsUrl = "https://api.github.com/repos/owner/repo/pulls{/number}",
    pushedAt = "2023-01-02T10:00:00Z",
    releasesUrl = "https://api.github.com/repos/owner/repo/releases{/id}",
    size = 1024,
    sshUrl = "git@github.com:owner/repo.git",
    stargazersCount = 50,
    stargazersUrl = "https://api.github.com/repos/owner/repo/stargazers",
    statusesUrl = "https://api.github.com/repos/owner/repo/statuses/{sha}",
    subscribersCount = 20,
    subscribersUrl = "https://api.github.com/repos/owner/repo/subscribers",
    subscriptionUrl = "https://api.github.com/repos/owner/repo/subscription",
    svnUrl = "https://github.com/owner/repo",
    tagsUrl = "https://api.github.com/repos/owner/repo/tags",
    teamsUrl = "https://api.github.com/repos/owner/repo/teams",
    tempCloneToken = Any(),
    topics = listOf(),
    treesUrl = "https://api.github.com/repos/owner/repo/git/trees{/sha}",
    updatedAt = "2023-01-03T08:00:00Z",
    url = "https://api.github.com/repos/owner/repo",
    visibility = "public",
    watchers = 30,
    watchersCount = 30,
    webCommitSignoffRequired = true
)


