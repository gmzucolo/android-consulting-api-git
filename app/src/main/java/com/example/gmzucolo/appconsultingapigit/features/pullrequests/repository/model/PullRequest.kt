package com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository.model

data class PullRequest(
    val title: String,
    val body: String,
    val state: String,
    val user: User
    )

