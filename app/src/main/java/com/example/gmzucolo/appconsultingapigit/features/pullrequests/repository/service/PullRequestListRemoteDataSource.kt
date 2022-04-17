package com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository.service

import com.example.gmzucolo.appconsultingapigit.commons.network.Resource
import com.example.gmzucolo.appconsultingapigit.commons.base.BaseDataSource
import com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository.model.api.PullRequesResponse

class PullRequestListRemoteDataSource(
    private val service: PullRequestListService
) : BaseDataSource() {

    suspend fun getPullRequestsByRepository(
        creatorRepository: String,
        repository: String
    ): Resource<List<PullRequesResponse>> {
        return getResult { service.getPullRequestsByRepository(creatorRepository, repository) }
    }
}
