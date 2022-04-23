package com.example.gmzucolo.appconsultingapigit.di

import com.example.gmzucolo.appconsultingapigit.BuildConfig
import com.example.gmzucolo.appconsultingapigit.commons.network.AuthInterceptor
import com.example.gmzucolo.appconsultingapigit.commons.network.NetworkService
import com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository.service.PullRequestListService
import com.example.gmzucolo.appconsultingapigit.features.repositories.repository.service.RepositoryListService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val serviceModule = module {
    single { AuthInterceptor() }
    single { provideOkHttpClient(get()) }
    single { provideRetrofit(get()) }
    factory { provideRepositoryListService(get()) }
    factory { providePullRequestListService(get()) }
    single { NetworkService(get()) }

}

fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor(authInterceptor).build()
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BuildConfig.API_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideRepositoryListService(retrofit: Retrofit): RepositoryListService {
    return retrofit.create(RepositoryListService::class.java)
}

fun providePullRequestListService(retrofit: Retrofit): PullRequestListService {
    return retrofit.create(PullRequestListService::class.java)
}