package com.example.gmzucolo.appconsultingapigit.features.repositories.model

data class Repository(
    val title: String,
    val description: String,
    val owner: String,
    val forksCount: Int,
    val stargazersCount: Int
)

class RepositoryBuilder {
    var name: String = ""
    var description: String = ""
    var owner: String = ""
    var forksCount: Int = 1
    var stargazersCount: Int = 1

    fun build(): Repository = Repository(name, description, owner, forksCount, stargazersCount)
}

fun repository(block: RepositoryBuilder.() -> Unit): Repository =
    RepositoryBuilder().apply(block).build()

fun fakeRepositories(): MutableList<Repository> = mutableListOf(
    repository {
        name = "Carol"
        description = "test repository"
        owner = "Carol"
        forksCount = 10
        stargazersCount = 20
    },
    repository {
        name = "Carol"
        description = "test repository"
        owner = "Carol"
        forksCount = 10
        stargazersCount = 20
    },
    repository {
        name = "Carol"
        description = "test repository"
        owner = "Carol"
        forksCount = 10
        stargazersCount = 20
    },
    repository {
        name = "Carol"
        description = "test repository"
        owner = "Carol"
        forksCount = 10
        stargazersCount = 20
    },
    repository {
        name = "Carol"
        description = "test repository"
        owner = "Carol"
        forksCount = 10
        stargazersCount = 20
    },
    repository {
        name = "Carol"
        description = "test repository"
        owner = "Carol"
        forksCount = 10
        stargazersCount = 20
    },
    repository {
        name = "Carol"
        description = "test repository"
        owner = "Carol"
        forksCount = 10
        stargazersCount = 20
    },
    repository {
        name = "Carol"
        description = "test repository"
        owner = "Carol"
        forksCount = 10
        stargazersCount = 20
    },
    repository {
        name = "Carol"
        description = "test repository"
        owner = "Carol"
        forksCount = 10
        stargazersCount = 20
    },
    repository {
        name = "Carol"
        description = "test repository"
        owner = "Carol"
        forksCount = 10
        stargazersCount = 20
    }
)