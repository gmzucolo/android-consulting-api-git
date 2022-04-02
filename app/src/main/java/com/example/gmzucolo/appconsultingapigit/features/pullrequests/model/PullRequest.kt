package com.example.gmzucolo.appconsultingapigit.features.pullrequests.model

data class PullRequest(
    val title: String,
    val description: String,
    val state: String,
    val username: User
)

class PullRequestBuilder {
    var title: String = ""
    var description: String = ""
    var state: String = ""
    var username: User = User("", "")

    fun build(): PullRequest = PullRequest(title, description, state, username)

}

fun pullRequest(block: PullRequestBuilder.() -> Unit): PullRequest =
    PullRequestBuilder().apply(block).build()

fun fakePullRequests():MutableList<PullRequest> = mutableListOf(
    pullRequest {
        title = "gustavo"
        description = "teste"
        state = "teste"
        username = User("teste", "teste")
    },
    pullRequest {
        title = "gustavo"
        description = "teste"
        state = "teste"
        username = User("teste", "teste")
    },
    pullRequest {
        title = "gustavo"
        description = "teste"
        state = "teste"
        username = User("teste", "teste")
    },
    pullRequest {
        title = "gustavo"
        description = "teste"
        state = "teste"
        username = User("teste", "teste")
    },
    pullRequest {
        title = "gustavo"
        description = "teste"
        state = "teste"
        username = User("teste", "teste")
    },
    pullRequest {
        title = "gustavo"
        description = "teste"
        state = "teste"
        username = User("teste", "teste")
    },
    pullRequest {
        title = "gustavo"
        description = "teste"
        state = "teste"
        username = User("teste", "teste")
    },
    pullRequest {
        title = "gustavo"
        description = "teste"
        state = "teste"
        username = User("teste", "teste")
    }
)

