package com.example.gmzucolo.appconsultingapigit.features.repositories.repository.model.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class OwnerEntity(
    @PrimaryKey val idUser: Long = 0,
    val idPullRequest: Long = 0,
    val login: String = "",
    val avatarUrl: String = ""
) : Parcelable
