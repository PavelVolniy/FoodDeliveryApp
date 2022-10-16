package com.chetv.fooddeliveryapp.data.json


data class DodoPizzaJson(
    val number: Int,
    val offset: Int,
    val results: List<Result>,
    val totalResults: Int
)