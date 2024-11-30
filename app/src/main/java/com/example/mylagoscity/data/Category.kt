package com.example.mylagoscity.data

import androidx.annotation.DrawableRes
import com.example.mylagoscity.R

data class Category(
   @DrawableRes val categoryIcon: Int,
    val categoryName: String,
    val categoryList: List<Locations>


)

val CategoryList: List<Category> = listOf(
    Category(categoryIcon = R.drawable.coffee_icon, categoryName = "Coffee Shops", coffeeShopList),
    Category(categoryIcon = R.drawable.food_icon, categoryName = "Restaurants", restaurantsList),
    Category(categoryIcon = R.drawable.kid_friendly_places_icon, categoryName = "Kids Friendly Places", kidFriendlyPlacesList),
    Category(categoryIcon = R.drawable.park_icon, categoryName = "Parks", parkList),
    Category(categoryIcon = R.drawable.shopping_center_icon, categoryName = "Shopping Centers", shoppingCenterList),
    Category(categoryIcon = R.drawable.hotel_icon , categoryName = "Hotels", hotelList)
)

val defaultCategory =  Category(categoryIcon = R.drawable.coffee_icon, categoryName = "Coffee Shops", coffeeShopList)
