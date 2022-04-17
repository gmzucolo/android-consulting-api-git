package com.example.gmzucolo.appconsultingapigit.di

import com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository.PullRequestListRepositoryImpl

val repositoryModule = module {
    factory<RepositoriesRepository> {
        RepositoriesRepositoryImpl(remoteDataSource = get(), localDataSource = get())
    }
    factory<PullRequestListRepository> {
        PullRequestListRepositoryImpl(remoteDataSource = get(), localDataSource = get())
    }
}