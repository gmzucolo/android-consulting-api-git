package com.example.gmzucolo.appconsultingapigit.features.pullrequests.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.gmzucolo.appconsultingapigit.commons.network.Resource
import com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository.PullRequestListRepository
import com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository.model.entities.PullRequestAndUser

class PullRequestListViewModel(
    private val repository: PullRequestListRepository
) : ViewModel() {

    fun loadPullRequests(
        creatorRepository: String,
        repositoryName: String
    ): LiveData<Resource<List<PullRequestAndUser>>> {
        return repository.getPullRequests(creatorRepository, repositoryName)
    }
}