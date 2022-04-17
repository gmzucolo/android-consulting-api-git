package com.example.gmzucolo.appconsultingapigit.di

import com.example.gmzucolo.appconsultingapigit.db.AppDataBase

val daoModule = module {
    single { AppDataBase.getDataBase(get()) }
    single { get<AppDataBase>().repositoryListDao() }
    single { get<AppDataBase>().pullRequestListDao() }
}