package com.example.gmzucolo.appconsultingapigit.features.repositories.repository

import androidx.lifecycle.LiveData
import com.example.gmzucolo.appconsultingapigit.commons.network.Resource
import com.example.gmzucolo.appconsultingapigit.commons.performGetOperation
import com.example.gmzucolo.appconsultingapigit.features.repositories.repository.dao.RepositoryListLocalDataSource
import com.example.gmzucolo.appconsultingapigit.features.repositories.repository.mappers.toRepositoryEntity
import com.example.gmzucolo.appconsultingapigit.features.repositories.repository.mappers.toSearchRepositoriesEntity
import com.example.gmzucolo.appconsultingapigit.features.repositories.repository.model.entities.ResultDataWithListRepository
import com.example.gmzucolo.appconsultingapigit.features.repositories.repository.service.RepositoryListRemoteDataSource

class RepositoriesRepositoryImpl(
    private val remoteDataSource: RepositoryListRemoteDataSource,
    private val localDataSource: RepositoryListLocalDataSource
) : RepositoriesRepository {
    override fun getRepositories(pageIndex: String): LiveData<Resource<ResultDataWithListRepository>> {
        return performGetOperation(
            databaseQuery = {
                localDataSource.getResultRepositoryListLocalDataSource()
                            },
            networkCall = {
                remoteDataSource.getRepositories(pageIndex)
                          },
            saveCallResult = {
                localDataSource.insertFullResultDataListRepository(
                    pageIndex,
                    ResultDataWithListRepository(
                        resultDataRepositoryListEntity = it.toSearchRepositoriesEntity(),
                        repositoryListEntity = it.items?.toRepositoryEntity() ?: emptyList()
                    )
                )
            }
        )
    }
}