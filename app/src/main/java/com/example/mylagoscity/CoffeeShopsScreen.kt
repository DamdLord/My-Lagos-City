package com.example.mylagoscity

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mylagoscity.data.Category
import com.example.mylagoscity.data.Locations
import com.example.mylagoscity.data.coffeeShopList
import com.example.mylagoscity.ui.theme.MyLagosCityTheme


@Composable
fun CoffeeShopsScreen(
    modifier: Modifier = Modifier,
    currentCategory: Category,
    onLocationsCardClicked: (Locations) -> Unit,
    myCityUiState: MyCityUiState
){
    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
         currentCategory.categoryList.forEach {coffeeShop->
             LocationItem(locations = coffeeShop ,
                 onCardClicked = { onLocationsCardClicked(coffeeShop) },
                 isLocationSelected = myCityUiState.currentLocation == coffeeShop
             )

         }
    }
}






@Composable
fun LocationItem(
    locations: Locations,
    onCardClicked: () -> Unit,
    modifier: Modifier = Modifier,
    isLocationSelected: Boolean
){
    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(),
        onClick = onCardClicked,
        colors = CardDefaults.cardColors(
            if (isLocationSelected){
                MaterialTheme.colorScheme.secondaryContainer}
            else{ MaterialTheme.colorScheme.primaryContainer}
        )
    ) {
        Row(modifier.padding(8.dp)) {
            Box {
                Image(painter = painterResource(locations.locationLogo), contentDescription = null, modifier = modifier.size(width =90.dp, height = 90.dp))
            }
            Column(
                modifier.padding(6.dp, top = 16.dp)
            ) {
                Text(
                    text = stringResource(locations.locationName),
                    style = MaterialTheme.typography.labelLarge,
                    fontSize = 20.sp
                )
                Spacer(modifier = modifier.height(4.dp))
                Text(
                    text = stringResource(locations.locationAddress),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.labelMedium,
                    fontSize = 16.sp,
                    modifier = modifier.width(250.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun ThisPreview(){
    val locations = coffeeShopList[3]
    MyLagosCityTheme {
        LocationItem(locations = locations, onCardClicked = {}, isLocationSelected = false)

    }
}

@Preview(showBackground = false)
@Composable
fun ThisPreviewTow(){
    val currentCategory = com.example.mylagoscity.data.CategoryList[0]
    MyLagosCityTheme(darkTheme = true) {
        CoffeeShopsScreen(currentCategory = currentCategory , onLocationsCardClicked = {}, myCityUiState = MyCityUiState())

    }
}

