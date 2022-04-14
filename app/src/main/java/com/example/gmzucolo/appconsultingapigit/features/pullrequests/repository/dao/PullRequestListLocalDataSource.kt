package com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository.dao

import com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository.model.entities.PullRequestAndUser

interface PullRequestListLocalDataSource {

    fun getAllPullRequestsByRepository(repositoryName: String)
    suspend fun insertAllPullRequestAndUser(data: List<PullRequestAndUser>)
}