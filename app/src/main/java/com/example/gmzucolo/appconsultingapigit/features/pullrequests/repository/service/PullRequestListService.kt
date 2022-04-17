package com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository.service

import com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository.model.api.PullRequesResponse
import com.example.gmzucolo.appconsultingapigit.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PullRequestListService {

    @GET(Constants.URL_PULLS)
    suspend fun getPullRequestsByRepository(
        @Path("creator") creatorRepository: String,
        @Path("repository") repository: String
    ): Response<List<PullRequesResponse>>
}