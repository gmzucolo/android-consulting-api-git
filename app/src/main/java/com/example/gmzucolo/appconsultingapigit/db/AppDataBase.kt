package com.example.gmzucolo.appconsultingapigit.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository.dao.PullRequestListDao
import com.example.gmzucolo.appconsultingapigit.features.repositories.repository.dao.RepositoryListDao
import com.example.gmzucolo.appconsultingapigit.util.Constants

abstract class AppDataBase : RoomDatabase() {

    abstract fun repositoryListDao(): RepositoryListDao
    abstract fun pullRequestLisDao(): PullRequestListDao

    companion object {
        @Volatile
        private var instance: AppDataBase? = null

        fun getDataBase(context: Context): AppDataBase = instance ?: synchronized(this) {
            instance ?: buildDataBase(context).also { appDataBase ->
                instance = appDataBase
            }
        }

        private fun buildDataBase(appContext: Context): AppDataBase {
            return Room.databaseBuilder(appContext, AppDataBase::class.java, Constants.DB_NAME)
                .fallbackToDestructiveMigration().build()
        }
    }
}