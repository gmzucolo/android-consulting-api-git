package com.example.gmzucolo.appconsultingapigit.di

import com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository.PullRequestListRepository
import com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository.PullRequestListRepositoryImpl
import com.example.gmzucolo.appconsultingapigit.features.repositories.repository.RepositoriesRepository
import com.example.gmzucolo.appconsultingapigit.features.repositories.repository.RepositoriesRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory<RepositoriesRepository> {
        RepositoriesRepositoryImpl(remoteDataSource = get(), localDataSource = get())
    }
    factory<PullRequestListRepository> {
        PullRequestListRepositoryImpl(remoteDataSource = get(), localDataSource = get())
    }
}