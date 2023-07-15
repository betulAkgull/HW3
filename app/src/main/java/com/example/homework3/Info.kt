package com.example.homework3

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Info(
    val university: String,
    val major: String,
    val gpa: Double,
    val user: User
) : Parcelable
