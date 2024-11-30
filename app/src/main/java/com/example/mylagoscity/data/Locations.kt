package com.example.mylagoscity.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.mylagoscity.R

data class Locations(
    @DrawableRes val locationLogo: Int,
    @DrawableRes val locationBanner: Int,
    @StringRes val locationName: Int,
    @StringRes val locationAddress: Int,
    @StringRes val locationDetails: Int,
    val socialMedia: String,
    val time: String,
    val contact: String
)

val defaultLocation =  Locations(
    R.drawable.topbeanslogo, R.drawable.topbeansbanner, R.string.top_beans_name,
    R.string.top_beans_address, R.string.top_beans_details, "@topbeans.lagos", "Opens 8am", "0811 588 8885")
