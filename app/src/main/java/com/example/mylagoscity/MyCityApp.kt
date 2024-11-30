package com.example.mylagoscity

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mylagoscity.data.MyCityScreens
import com.example.mylagoscity.ui.theme.DisplayType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityApp(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
){
    val navController: NavHostController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = MyCityScreens.valueOf(
        backStackEntry?.destination?.route ?: MyCityScreens.HOME_SCREEN.name
    )

    val viewModel: MyCityViewModel = viewModel()
    val uiState = viewModel.uiState.collectAsState().value
    val categories = com.example.mylagoscity.data.CategoryList

    val displayType: DisplayType = when(windowSize){
        WindowWidthSizeClass.Compact -> {
            DisplayType.LIST_ONLY
        }
        WindowWidthSizeClass.Medium -> {
            DisplayType.LIST_AND_DISPLAY
        }
        WindowWidthSizeClass.Expanded -> {
            DisplayType.LIST_AND_DISPLAY
        }
        else -> {
            DisplayType.LIST_ONLY
        }

    }


    when(displayType) {
        DisplayType.LIST_AND_DISPLAY->
        ListAndDetailsScreen(
            categories = categories,
            currentCategory = uiState.currentCategory,
            onCategoryClicked = { viewModel.updateCategorySelected(it) } ,
            selectedLocations = uiState.currentLocation,
            onLocationCardClicked = { viewModel.updateLocationSelected(it) } ,
            myCityUiState = uiState
        )

        else -> Scaffold(
            topBar = {
                androidx.compose.material3.TopAppBar(title = {
                    TopAppBar(
                        currentScreens = currentScreen,
                        currentCategory = uiState.currentCategory,
                        currentLocation = uiState.currentLocation,
                        onBackClick = { navController.navigateUp() })
                })
            }
        ) { innerPadding ->



            NavHost(
                navController = navController,
                startDestination = MyCityScreens.HOME_SCREEN.name,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(route = MyCityScreens.HOME_SCREEN.name) {
                    HomeScreen(
                        categories = categories,
                        onCategoryClicked = {
                            viewModel.updateCategorySelected(it)
                            navController.navigate(MyCityScreens.LOCATION_LIST.name)
                        }
                    )
                }
                composable(route = MyCityScreens.LOCATION_LIST.name) {
                    CoffeeShopsScreen(
                        currentCategory = uiState.currentCategory,
                        onLocationsCardClicked = {
                            viewModel.updateLocationSelected(it)
                            navController.navigate(MyCityScreens.DETAILS.name)
                        },
                        myCityUiState = uiState
                    )
                }
                composable(route = MyCityScreens.DETAILS.name) {
                    Details(selectedLocation = uiState.currentLocation)
                }
            }

        }
    }
}