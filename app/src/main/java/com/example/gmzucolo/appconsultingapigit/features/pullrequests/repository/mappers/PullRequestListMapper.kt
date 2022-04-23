package com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository.mappers

import com.example.gmzucolo.appconsultingapigit.commons.ext.orZero
import com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository.model.PullRequest
import com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository.model.User
import com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository.model.api.PullRequesResponse
import com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository.model.entities.PullRequestAndUser
import com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository.model.entities.PullRequestEntity
import com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository.model.entities.UserEntity

fun List<PullRequesResponse>.toPullRequestEntity(repository: String): List<PullRequestAndUser> =
    map {
        PullRequestAndUser(
            pullRequestEntity = PullRequestEntity(
                id = it.id.orZero(),
                repoName = repository,
                title = it.title.orEmpty(),
                body = it.body.orEmpty(),
                state = it.state.orEmpty()
            ),
            userEntity = UserEntity(
                idUser = it.user?.id.orZero(),
                login = it.user?.login.orEmpty(),
                avatarUrl = it.user?.avatarUrl.orEmpty()
            )
        )
    }

fun List<PullRequestAndUser>.toPullRequestList() = map {
    PullRequest(
        title = it.pullRequestEntity?.title.orEmpty(),
        body = it.pullRequestEntity?.title.orEmpty(),
        state = it.pullRequestEntity?.title.orEmpty(),
        user = it.userEntity?.toUser() ?: getUserEmpty(),
    )
}

fun UserEntity.toUser() =
    User(
        login = login,
        avatarUrl = avatarUrl
    )

fun getUserEmpty() =
    User(
        login = "",
        avatarUrl = ""
    )