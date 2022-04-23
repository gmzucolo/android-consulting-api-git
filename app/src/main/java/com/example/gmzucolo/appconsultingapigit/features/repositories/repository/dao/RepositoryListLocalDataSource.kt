package com.example.gmzucolo.appconsultingapigit.features.repositories.repository.dao

import androidx.lifecycle.LiveData
import com.example.gmzucolo.appconsultingapigit.features.repositories.repository.model.entities.ResultDataWithListRepository

interface RepositoryListLocalDataSource {
    fun getResultRepositoryListLocalDataSource() : LiveData<ResultDataWithListRepository>
    suspend fun insertFullResultDataListRepository(pageIndex: String, data: ResultDataWithListRepository)
}