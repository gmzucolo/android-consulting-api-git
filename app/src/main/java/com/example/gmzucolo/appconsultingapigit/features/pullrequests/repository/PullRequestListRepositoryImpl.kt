package com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository

import androidx.lifecycle.LiveData
import com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository.model.entities.PullRequestAndUser

class PullRequestListRepositoryImpl(
    private val localDataSource: PullRequestListDataSource,
    private val remoteDataSource: PullRequestListRemoteDataSource
) : PullRequestListRepository {
    override fun getPullRequests(
        creatorRepository: String,
        repository: String
    ): LiveData<Resource<List<PullRequestAndUser>>> = performGetOperation()
}