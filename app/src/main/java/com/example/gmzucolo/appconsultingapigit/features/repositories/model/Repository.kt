package com.example.gmzucolo.appconsultingapigit.features.repositories.model

data class Repository(
    val title: String,
    val description: String,
    val owner: String,
    val forksCount: String,
    val stargazersCount: String
)

class RepositoryBuilder {
    var name: String = ""
    var description: String = ""
    var owner: String = ""
    var forksCount: String = "10"
    var stargazersCount: String = "20"

    fun build(): Repository = Repository(name, description, owner, forksCount, stargazersCount)
}

fun repository(block: RepositoryBuilder.() -> Unit): Repository =
    RepositoryBuilder().apply(block).build()

fun fakeRepositories(): MutableList<Repository> = mutableListOf(
    repository {
        name = "Carol"
        description = "test repository"
        owner = "Carol"
        forksCount = "10"
        stargazersCount = "20"
    },
    repository {
        name = "Carol"
        description = "test repository"
        owner = "Carol"
        forksCount = "10"
        stargazersCount = "20"
    },
    repository {
        name = "Carol"
        description = "test repository"
        owner = "Carol"
        forksCount = "10"
        stargazersCount = "20"
    },    repository {
        name = "Carol"
        description = "test repository"
        owner = "Carol"
        forksCount = "10"
        stargazersCount = "20"
    },    repository {
        name = "Carol"
        description = "test repository"
        owner = "Carol"
        forksCount = "10"
        stargazersCount = "20"
    },    repository {
        name = "Carol"
        description = "test repository"
        owner = "Carol"
        forksCount = "10"
        stargazersCount = "20"
    },    repository {
        name = "Carol"
        description = "test repository"
        owner = "Carol"
        forksCount = "10"
        stargazersCount = "20"
    },    repository {
        name = "Carol"
        description = "test repository"
        owner = "Carol"
        forksCount = "10"
        stargazersCount = "20"
    },    repository {
        name = "Carol"
        description = "test repository"
        owner = "Carol"
        forksCount = "10"
        stargazersCount = "20"
    },    repository {
        name = "Carol"
        description = "test repository"
        owner = "Carol"
        forksCount = "10"
        stargazersCount = "20"
    },    repository {
        name = "Carol"
        description = "test repository"
        owner = "Carol"
        forksCount = "10"
        stargazersCount = "20"
    },    repository {
        name = "Carol"
        description = "test repository"
        owner = "Carol"
        forksCount = "10"
        stargazersCount = "20"
    },    repository {
        name = "Carol"
        description = "test repository"
        owner = "Carol"
        forksCount = "10"
        stargazersCount = "20"
    },
)