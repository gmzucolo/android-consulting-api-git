package com.example.gmzucolo.appconsultingapigit.util

import android.view.View
import androidx.annotation.NonNull
import com.google.android.material.snackbar.Snackbar

internal fun notify(@NonNull viewContainer: View, message: String) =
    Snackbar.make(viewContainer, message, Snackbar.LENGTH_LONG).show()