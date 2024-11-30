package com.example.mylagoscity


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mylagoscity.data.Category
import com.example.mylagoscity.data.CategoryList
import com.example.mylagoscity.data.Locations
import com.example.mylagoscity.data.MyCityScreens
import com.example.mylagoscity.data.defaultCategory
import com.example.mylagoscity.data.defaultLocation
import com.example.mylagoscity.ui.theme.MyLagosCityTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    categories: List<Category>,
    onCategoryClicked: (Category) -> Unit
){

    Column(
        modifier
            .padding(top = 4.dp, start = 4.dp, end = 4.dp, bottom = 4.dp)
            .fillMaxSize()
    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.welcome_ro_lagos),
                contentDescription = null,
                modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = modifier.height(8.dp))
        LazyVerticalGrid(columns = GridCells.Fixed(2),
            userScrollEnabled = true,
            verticalArrangement = Arrangement.spacedBy(30.dp),
            horizontalArrangement = Arrangement.spacedBy(3.dp),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(categories){
                    category -> CategoryItem(
                selected = false,
                onCategoryClicked = { onCategoryClicked(category)},
                category =category
            )
            }

        }

    }

}



@Composable
fun CategoryList(
    categories: List<Category>
){
    LazyColumn(Modifier.padding(4.dp)) {
        items(categories){ category ->
            CategoryItem(
                selected = false,
                category = category,
                onCategoryClicked = {}
            )
        }

    }

}


@Composable
fun CategoryItem(
    modifier: Modifier = Modifier,
    selected: Boolean,
    onCategoryClicked: () -> Unit,
    category: Category
){
    Card(
        modifier = modifier
            .padding(4.dp)
            .height(90.dp)
            .size(200.dp, 200.dp),
        onClick = onCategoryClicked,
        colors = CardDefaults.cardColors(
            if (selected){
                MaterialTheme.colorScheme.secondaryContainer}
            else{ MaterialTheme.colorScheme.primaryContainer}
        )
    ) {
         Row(
             modifier.padding(8.dp, top = 24.dp),
             verticalAlignment = Alignment.CenterVertically
         ) {
             Icon(
                 painter = painterResource(category.categoryIcon),
                 contentDescription = category.categoryName,
                 modifier.size(40.dp)
             )
             Text(text = category.categoryName,
                 modifier
                     .width(150.dp)
                     .padding(start = 4.dp, top = 2.dp),
                 color = MaterialTheme.colorScheme.onSurface,
                 style = MaterialTheme.typography.labelLarge,
                 fontSize = 20.sp
             )
         }
    }
}

@Composable
fun TopAppBar(
    currentScreens: MyCityScreens,
    onBackClick: () -> Unit,
    currentCategory: Category,
    currentLocation: Locations,
    modifier: Modifier = Modifier
){
    Row(modifier.padding(6.dp)) {
        if (currentScreens != MyCityScreens.HOME_SCREEN){
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(id = R.string.back)
                )
            }
        }
        if (currentScreens == MyCityScreens.HOME_SCREEN) {
            Text(
                text = stringResource(currentScreens.title),
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 30.sp,
                modifier = modifier.padding(top = 10.dp)
            )
        }else if (currentScreens == MyCityScreens.LOCATION_LIST){
            Text(
                text = currentCategory.categoryName,
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 30.sp,
                modifier = modifier.padding(top = 7.dp)
            )
        } else{
            Text(
                text = stringResource(id = currentLocation.locationName),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 25.sp,
                modifier = modifier.padding(top = 10.dp)
                )
        }



    }
}

@Composable
fun ListAndDetailsScreen(
    modifier: Modifier = Modifier,
    categories: List<Category>,
    onCategoryClicked: (Category) -> Unit,
    currentCategory: Category,
    onLocationCardClicked: (Locations) -> Unit,
    selectedLocations: Locations,
    myCityUiState: MyCityUiState
){
    Column(
        modifier
            .padding(4.dp)

    ) {
        Box(modifier) {
            Image(
                painter = painterResource(id = R.drawable.welcome_ro_lagos),
                contentDescription = null,
                modifier = modifier
                    .fillMaxWidth()
                    .height(140.dp),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = modifier.height(8.dp))
        Row(modifier = modifier.padding(4.dp)) {
            LazyColumn {

                items(categories) { category ->
                    CategoryItem(
                        selected = myCityUiState.currentCategory == category,
                        onCategoryClicked = {
                            onCategoryClicked(category)
                                            },
                        category = category
                    )

                }
            }

            Column(modifier = modifier.width(320.dp)) {
                CoffeeShopsScreen(
                    currentCategory = currentCategory,
                    onLocationsCardClicked = onLocationCardClicked,
                    myCityUiState = MyCityUiState()
                )
            }
            Details(selectedLocation = selectedLocations)
        }
    }

}


@Preview(showBackground = true)
@Composable
fun Preview(){
    MyLagosCityTheme {
       TopAppBar(
           currentScreens = MyCityScreens.DETAILS,
           onBackClick = { /*TODO*/ },
           currentCategory = defaultCategory,
           currentLocation = defaultLocation
       )
    }
}


//@Preview
//@Composable
//fun PreviewTwo(){
//    MyLagosCityTheme(darkTheme = true) {
//        CategoryList(categories = CategoryList)
//    }
//}
@Preview(showBackground = false)
@Composable
fun PreviewThree(){
    MyLagosCityTheme(darkTheme = true) {
        HomeScreen(categories = CategoryList, onCategoryClicked = { })
    }
}

@Preview(widthDp = 1000)
@Composable
fun PreviewListAndDetails(){
    MyLagosCityTheme {
        ListAndDetailsScreen(
            categories = CategoryList,
            onCategoryClicked = {  },
            currentCategory = defaultCategory ,
            onLocationCardClicked = {},
            selectedLocations = defaultLocation,
            myCityUiState = MyCityUiState()
        )
    }
}