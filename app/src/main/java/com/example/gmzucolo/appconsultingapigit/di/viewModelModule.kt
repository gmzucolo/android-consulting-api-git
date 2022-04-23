package com.example.gmzucolo.appconsultingapigit.di

import com.example.gmzucolo.appconsultingapigit.features.pullrequests.viewmodel.PullRequestListViewModel
import com.example.gmzucolo.appconsultingapigit.features.repositories.viewmodel.RepositoryListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { RepositoryListViewModel(repository = get()) }
    viewModel { PullRequestListViewModel(repository = get()) }
}