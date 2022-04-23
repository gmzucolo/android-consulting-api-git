package com.example.gmzucolo.appconsultingapigit.features.repositories.viewmodel.model

import com.example.gmzucolo.appconsultingapigit.features.repositories.repository.model.Repository

data class RepositoryListResult(
    val totalCount: Int,
    val incompleteResults: Boolean,
    val items: List<Repository>
)
