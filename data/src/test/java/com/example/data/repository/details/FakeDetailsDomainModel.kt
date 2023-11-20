package com.example.data.repository.details

import com.example.domain.model.RepositoryDetailsDomainModel

val fakeDetailsDomainModel = RepositoryDetailsDomainModel(
    id = 123,
    name = "repo",
    avatar = "https://avatars.githubusercontent.com/u/owner_id?v=4",
    description = "A sample repository",
    stars = 50,
    owner = "owner",
    forks = 10,
    language = "Kotlin",
    fullName = "owner/repo",
    url = "https://api.github.com/repos/owner/repo",
    createdAt = "2023-01-01T14:00:00Z"
)


