package com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository

import androidx.lifecycle.LiveData
import com.example.gmzucolo.appconsultingapigit.commons.network.Resource
import com.example.gmzucolo.appconsultingapigit.commons.performGetOperation
import com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository.dao.PullRequestListLocalDataSource
import com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository.mappers.toPullRequestEntity
import com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository.model.entities.PullRequestAndUser
import com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository.service.PullRequestListRemoteDataSource

class PullRequestListRepositoryImpl(
    private val localDataSource: PullRequestListLocalDataSource,
    private val remoteDataSource: PullRequestListRemoteDataSource
) : PullRequestListRepository {
    override fun getPullRequests(
        creatorRepository: String,
        repository: String
    ): LiveData<Resource<List<PullRequestAndUser>>> = performGetOperation(
        databaseQuery = {
            localDataSource.getAllPullRequestsByRepository(repository)
        },
        networkCall = {
            remoteDataSource.getPullRequestsByRepository(creatorRepository, repository)
        },
        saveCallResult =
        {
            val dataMapped: List<PullRequestAndUser> = it.toPullRequestEntity(repository)
            localDataSource.insertAllPullRequestAndUser(dataMapped)
        }
    )
}