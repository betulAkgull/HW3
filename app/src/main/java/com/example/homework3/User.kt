package com.example.homework3

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val nameSurname: String,
    val email: String,
    val address: String
) : Parcelable


