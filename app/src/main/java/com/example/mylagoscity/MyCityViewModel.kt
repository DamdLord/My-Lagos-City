package com.example.mylagoscity

import android.location.Location
import androidx.lifecycle.ViewModel
import com.example.mylagoscity.data.Category
import com.example.mylagoscity.data.Locations
import com.example.mylagoscity.data.defaultCategory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class MyCityViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(MyCityUiState())
    val uiState: StateFlow<MyCityUiState> = _uiState

    fun updateCategorySelected(category: Category){
        _uiState.update {
            it.copy(
                currentCategory = category
            )
        }
    }

    fun updateLocationSelected(location: Locations){
        _uiState.update {
            it.copy(
               currentLocation = location
            )
        }
    }


}