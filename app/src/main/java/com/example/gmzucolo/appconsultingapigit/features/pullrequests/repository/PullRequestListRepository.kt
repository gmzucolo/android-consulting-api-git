package com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository

import androidx.lifecycle.LiveData

interface PullRequestListRepository {
    fun getPullRequests(
        creatorRepository: String,
        repository: String
    ): LiveData<Resource<List<PullRequestAndUser>>>
}