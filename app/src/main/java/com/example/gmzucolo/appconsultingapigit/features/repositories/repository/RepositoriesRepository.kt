package com.example.gmzucolo.appconsultingapigit.features.repositories.repository

import androidx.lifecycle.LiveData
import com.example.gmzucolo.appconsultingapigit.commons.network.Resource
import com.example.gmzucolo.appconsultingapigit.features.repositories.repository.model.entities.ResultDataWithListRepository

interface RepositoriesRepository {
    fun getRepositories(pageIndex: String): LiveData<Resource<ResultDataWithListRepository>>
}