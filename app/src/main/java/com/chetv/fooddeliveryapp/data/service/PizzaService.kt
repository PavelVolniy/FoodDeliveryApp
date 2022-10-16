package com.chetv.fooddeliveryapp.data.service

import com.chetv.fooddeliveryapp.data.json.DodoPizzaJson
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers

interface PizzaService {
    @GET("recipes/complexSearch")
    @Headers("Content-Type:application/json")
    fun getFoodItems(): Observable<DodoPizzaJson>
}
