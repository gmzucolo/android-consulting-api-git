package com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository

import androidx.lifecycle.LiveData
import com.example.gmzucolo.appconsultingapigit.commons.network.Resource
import com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository.model.entities.PullRequestAndUser

interface PullRequestListRepository {
    fun getPullRequests(
        creatorRepository: String,
        repository: String
    ): LiveData<Resource<List<PullRequestAndUser>>>
}