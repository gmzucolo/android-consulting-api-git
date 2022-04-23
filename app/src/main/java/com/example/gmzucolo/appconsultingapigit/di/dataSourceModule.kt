package com.example.gmzucolo.appconsultingapigit.di

import com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository.dao.PullRequestListLocalDataSource
import com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository.dao.PullRequestListLocalDataSourceImpl
import com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository.service.PullRequestListRemoteDataSource
import com.example.gmzucolo.appconsultingapigit.features.repositories.repository.dao.RepositoryListLocalDataSource
import com.example.gmzucolo.appconsultingapigit.features.repositories.repository.dao.RepositoryListLocalDataSourceImpl
import com.example.gmzucolo.appconsultingapigit.features.repositories.repository.service.RepositoryListRemoteDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    single { RepositoryListRemoteDataSource(service = get()) }
    single { PullRequestListRemoteDataSource(service = get()) }
    factory<RepositoryListLocalDataSource> {
        RepositoryListLocalDataSourceImpl(dao = get())
    }
    factory<PullRequestListLocalDataSource> {
        PullRequestListLocalDataSourceImpl(dao = get())
    }
}