package com.example.gmzucolo.appconsultingapigit.di

import com.example.gmzucolo.appconsultingapigit.features.pullrequests.viewmodel.PullRequestListViewModel
import com.example.gmzucolo.appconsultingapigit.features.repositories.repository.model.repository

val viewModelModule = module {
    viewModel { RepositoryListViewModel(repository = get()) }
    viewModel { PullRequestListViewModel(repository = get()) }
}