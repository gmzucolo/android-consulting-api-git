package com.example.gmzucolo.appconsultingapigit.features.repositories.viewmodel.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Owner(
    val login: String,
    val avatarUrl: String
) : Parcelable