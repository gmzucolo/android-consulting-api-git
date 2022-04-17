package com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository.model.entities.PullRequestAndUser
import com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository.model.entities.PullRequestEntity
import com.example.gmzucolo.appconsultingapigit.features.pullrequests.repository.model.entities.UserEntity

@Dao
abstract class PullRequestListDao {

    @Transaction
    @Query("SELECT * FROM PullRequestEntity WHERE repoName = :repositoryName")
    abstract fun getAppPullRequestsByRepository(repositoryName: String): LiveData<List<PullRequestAndUser>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertUser(userEntity: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertPullRequest(pullRequestEntity: PullRequestEntity)
}