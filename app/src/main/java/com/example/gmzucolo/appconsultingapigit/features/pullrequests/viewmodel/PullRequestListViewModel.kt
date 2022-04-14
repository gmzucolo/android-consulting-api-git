package com.example.gmzucolo.appconsultingapigit.features.pullrequests.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository.PullRequestListRepository

class PullRequestListViewModel(
    private val repository: PullRequestListRepository
) : ViewModel() {

    fun loadPullRequests(
        creatorRepository: String,
        repositoryName: String
    ): LiveData<Resource<List<PullRequesAndUser>>> {
        return repository.getPullRequests(creatorRepository, repositoryName)
    }
}