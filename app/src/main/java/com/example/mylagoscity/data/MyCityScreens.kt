package com.example.mylagoscity.data

import androidx.annotation.StringRes
import androidx.compose.ui.res.stringResource
import com.example.mylagoscity.R

enum class MyCityScreens(@StringRes val title: Int) {
    HOME_SCREEN(title = R.string.home_screen_title),
    LOCATION_LIST(title = R.string.location_list_title),
    DETAILS(title = R.string.details_title)

}