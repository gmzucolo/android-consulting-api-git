package com.example.gmzucolo.appconsultingapigit.features.repositories.repository.dao

import androidx.lifecycle.LiveData
import com.example.gmzucolo.appconsultingapigit.App
import com.example.gmzucolo.appconsultingapigit.commons.Prefs
import com.example.gmzucolo.appconsultingapigit.features.repositories.repository.model.entities.RepositoryEntity
import com.example.gmzucolo.appconsultingapigit.features.repositories.repository.model.entities.ResultDataWithListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RepositoryListLocalDataSourceImpl(
    private val dao: RepositoryListDao
) : RepositoryListLocalDataSource {

    private val prefs by lazy {
        Prefs(App.instance)
    }

    override fun getResultRepositoryListLocalDataSource(): LiveData<ResultDataWithListRepository> {
        val id = prefs.getValueString(Prefs.PREF_ID_REPO).orEmpty()
        return if (id.isEmpty()) {
            dao.getAllRepositories()
        } else {
            dao.getAllRepositories(id)
        }
    }

    override suspend fun insertFullResultDataListRepository(
        pageIndex: String,
        data: ResultDataWithListRepository
    ) {
        withContext(Dispatchers.IO) {
            val repositoryListEntity: List<RepositoryEntity> = data.repositoryListEntity
            val resultDataRepositoryListEntity = data.resultDataRepositoryListEntity
            prefs.save(Prefs.PREF_ID_REPO, resultDataRepositoryListEntity.id)
            repositoryListEntity.forEach { it.resultDataId = resultDataRepositoryListEntity.id }
            dao.insertFullResultDataListRepository(
                resultDataRepositoryListEntity,
                repositoryListEntity
            )
        }
    }
}