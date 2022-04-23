package com.example.gmzucolo.appconsultingapigit.features.repositories.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.gmzucolo.appconsultingapigit.commons.network.Resource
import com.example.gmzucolo.appconsultingapigit.features.repositories.repository.RepositoriesRepository
import com.example.gmzucolo.appconsultingapigit.features.repositories.repository.model.entities.ResultDataWithListRepository

class RepositoryListViewModel(
    private val repository: RepositoriesRepository
) : ViewModel() {
    fun getRepositories(pageIndex: Int): LiveData<Resource<ResultDataWithListRepository>> =
        repository.getRepositories(pageIndex.toString())
}