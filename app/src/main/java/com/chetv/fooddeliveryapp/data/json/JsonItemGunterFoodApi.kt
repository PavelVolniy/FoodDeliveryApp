package com.chetv.fooddeliveryapp.data.json

import android.graphics.Bitmap

data class JsonItemGunterFoodApi(
    val description: String,
    val id: Int,
    val image: String,
    val ingredients: List<String>,
    val name: String,
    val price: Double,
    val spicy: Boolean,
    val vegetarian: Boolean
)