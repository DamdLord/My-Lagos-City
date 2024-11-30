package com.example.mylagoscity

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mylagoscity.data.Locations
import com.example.mylagoscity.data.coffeeShopList
import com.example.mylagoscity.ui.theme.MyLagosCityTheme

@Composable
fun Details(
    selectedLocation: Locations,
    modifier: Modifier = Modifier
){
    Surface {
        Column(
            modifier
                .fillMaxSize()
        ) {
            Box(modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(selectedLocation.locationBanner),
                    contentDescription = null,
                    modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier
                    .verticalScroll(rememberScrollState())
                    .padding(8.dp)
            ) {
                Row {
                    Text(
                        text = "Name:",
                        style = MaterialTheme.typography.labelLarge,
                        fontSize = 20.sp,
                        modifier = modifier.padding(top = 12.dp)
                    )
                    Spacer(modifier = modifier.width(8.dp))
                    Text(
                        text = stringResource(id = selectedLocation.locationName),
                        fontSize = 20.sp,
                        style = MaterialTheme.typography.displayMedium
                    )
                }
                Spacer(modifier = modifier.height(12.dp))
                Divider(Modifier.height(2.dp))
                Spacer(modifier = modifier.height(12.dp))
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.address_icon),
                        contentDescription = null,
                        modifier = modifier.padding(2.dp)
                    )
                    Text(
                        text = "Address:",
                        style = MaterialTheme.typography.labelLarge,
                        fontSize = 20.sp,
                    )
                    Spacer(modifier = modifier.width(8.dp))
                    Text(
                        text = stringResource(selectedLocation.locationAddress),
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 20.sp,
                        modifier = modifier.width(310.dp)
                    )
                }
                Spacer(modifier = modifier.height(12.dp))
                Divider(Modifier.height(2.dp))
                Spacer(modifier = modifier.height(12.dp))
                Row {
                    Row(modifier = modifier.padding(top = 12.dp)) {
                        Icon(
                            painter = painterResource(id = R.drawable.time_icon),
                            contentDescription = null,
                            modifier = modifier.padding(2.dp)
                        )
                        Text(
                            text = "Hours:",
                            style = MaterialTheme.typography.labelLarge,
                            fontSize = 20.sp
                        )
                    }
                    Spacer(modifier.width(8.dp))
                    Text(
                        text = selectedLocation.time,
                        style = MaterialTheme.typography.displayMedium,
                        fontSize = 20.sp
                    )
                }
                Spacer(modifier = modifier.height(12.dp))
                Divider(Modifier.height(2.dp))
                Spacer(modifier = modifier.height(12.dp))
                Row {
                    Text(
                        text = "Social media:",
                        style = MaterialTheme.typography.labelLarge,
                        fontSize = 18.sp,
                        modifier = modifier.padding(top = 4.dp)
                    )
                    Spacer(modifier.width(8.dp))
                    Image(
                        painter = painterResource(id = R.drawable.download),
                        contentDescription = null,
                        modifier = modifier.height(27.dp)
                    )
                    Spacer(modifier.width(8.dp))
                    Text(
                        text = selectedLocation.socialMedia,
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Blue,
                        fontSize = 18.sp,
                        modifier = modifier.padding(top = 1.dp)
                    )
                }
                Spacer(modifier = modifier.height(12.dp))
                Divider(Modifier.height(2.dp))
                Spacer(modifier = modifier.height(12.dp))
                Row {
                    Row(modifier = modifier.padding(top = 12.dp)){
                        Icon(
                            painter = painterResource(id = R.drawable.phone_icon),
                            contentDescription = null,
                            modifier = modifier.padding(2.dp)
                        )
                        Spacer(modifier = modifier.width(4.dp))
                        Text(
                            text = "Contact:",
                            style = MaterialTheme.typography.labelLarge,
                            fontSize = 20.sp
                        )
                    }
                    Spacer(modifier.width(8.dp))
                    Text(
                        text = selectedLocation.contact,
                        style = MaterialTheme.typography.displayMedium,
                        fontSize = 20.sp
                    )
                }
                Spacer(modifier = modifier.height(12.dp))
                Divider(Modifier.height(2.dp))
                Spacer(modifier = modifier.height(12.dp))
                Row {
                    Text(
                        text = "About:",
                        style = MaterialTheme.typography.labelLarge,
                        fontSize = 20.sp
                    )
                    Spacer(modifier.width(8.dp))
                    Text(
                        text = stringResource(id = selectedLocation.locationDetails),
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 20.sp
                    )
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsPreview(){
    val  selectedLocation = coffeeShopList[0]
    MyLagosCityTheme(darkTheme = false) {
        Details(selectedLocation = selectedLocation)
    }
}