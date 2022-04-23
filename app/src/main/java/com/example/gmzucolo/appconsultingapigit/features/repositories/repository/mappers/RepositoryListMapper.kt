package com.example.gmzucolo.appconsultingapigit.features.repositories.repository.mappers

import com.example.gmzucolo.appconsultingapigit.commons.ext.orZero
import com.example.gmzucolo.appconsultingapigit.features.repositories.repository.model.Repository
import com.example.gmzucolo.appconsultingapigit.features.repositories.repository.model.api.OwnerResponse
import com.example.gmzucolo.appconsultingapigit.features.repositories.repository.model.api.RepositoryListResponse
import com.example.gmzucolo.appconsultingapigit.features.repositories.repository.model.api.RepositoryResponse
import com.example.gmzucolo.appconsultingapigit.features.repositories.repository.model.entities.OwnerEntity
import com.example.gmzucolo.appconsultingapigit.features.repositories.repository.model.entities.RepositoryEntity
import com.example.gmzucolo.appconsultingapigit.features.repositories.repository.model.entities.ResultDataRepositoryListEntity
import com.example.gmzucolo.appconsultingapigit.features.repositories.repository.model.entities.ResultDataWithListRepository
import com.example.gmzucolo.appconsultingapigit.features.repositories.viewmodel.model.RepositoryListResult
import com.example.gmzucolo.appconsultingapigit.features.repositories.viewmodel.model.Owner

fun ResultDataWithListRepository.toRepositoryListResult() =
    RepositoryListResult(
        totalCount = resultDataRepositoryListEntity.totalCount,
        incompleteResults = resultDataRepositoryListEntity.incompleteResults,
        items = repositoryListEntity.toRepository()
    )

fun List<RepositoryEntity>.toRepository() = map {
    Repository(
        name = it.name,
        description = it.description,
        owner = it.owner?.toUser() ?: getOwnerEmpty(),
        forksCount = it.forksCount,
        stargazersCount = it.stargazersCount
    )
}

fun OwnerEntity.toUser() =
    Owner(
        login = login,
        avatarUrl = avatarUrl
    )

fun RepositoryListResponse.toSearchRepositoriesEntity() =
    ResultDataRepositoryListEntity(
        incompleteResults = incompleteResults ?: false,
        totalCount = totalCount.orZero()
    )

fun List<RepositoryResponse>.toRepositoryEntity(): List<RepositoryEntity> = map {
    RepositoryEntity(
        id = it.id.orZero(),
        name = it.name.orEmpty(),
        description = it.description.orEmpty(),
        owner = it.owner?.toUserEntity() ?: OwnerEntity(),
        forksCount = it.forksCount.orZero(),
        stargazersCount   = it.stargazersCount.orZero()
    )
}

fun OwnerResponse.toUserEntity() =
    OwnerEntity(
        idUser = id.orZero(),
        login = login.orEmpty(),
        avatarUrl = avatarUrl.orEmpty()
    )

fun getOwnerEmpty() =
    Owner(
        login = "",
        avatarUrl = ""
    )