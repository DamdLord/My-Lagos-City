package com.example.mylagoscity

import com.example.mylagoscity.data.Category
import com.example.mylagoscity.data.Locations
import com.example.mylagoscity.data.defaultCategory
import com.example.mylagoscity.data.defaultLocation

data class MyCityUiState(
    val currentCategory: Category = defaultCategory,
    val currentLocation: Locations = defaultLocation
)
