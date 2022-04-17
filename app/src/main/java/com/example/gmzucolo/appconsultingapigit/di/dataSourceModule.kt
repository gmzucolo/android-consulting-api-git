package com.example.gmzucolo.appconsultingapigit.di

import com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository.dao.PullRequestListLocalDataSource

val dataSourceModule = module {
    single { RepositoryListRemoteDataSource(service = get()) }
    single { PullRequestListLocalDataSource(service = get()) }
    factory<RepositoryListLocalDataSource> {
        RepositoryListLocalDataSourceImpl(dao - get())
    }
    factory<PullRequestListLocalDataSource> {
        PullRequestListDataSourceImpl(dao = get())
    }
}