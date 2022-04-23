package com.example.gmzucolo.appconsultingapigit.features.repositories.repository.model

import android.os.Parcelable
import com.example.gmzucolo.appconsultingapigit.features.repositories.viewmodel.model.Owner
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Repository(
    val name: String,
    val description: String,
    val owner: Owner,
    val forksCount: Int,
    val stargazersCount: Int
) : Parcelable