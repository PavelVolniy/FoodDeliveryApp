package com.chetv.fooddeliveryapp.data.service

import com.chetv.fooddeliveryapp.data.json.JsonGunterFoodApi
import io.reactivex.Observable
import retrofit2.http.GET

interface PizzaService {
    @GET("pizza")
    fun getPizzaItems(): Observable<JsonGunterFoodApi>

    @GET("dessert")
    fun getDessertItems(): Observable<JsonGunterFoodApi>

    @GET("drinks")
    fun getDrinksItems(): Observable<JsonGunterFoodApi>

    @GET("salads")
    fun getSaladsItems(): Observable<JsonGunterFoodApi>

    @GET("pasta")
    fun getPastaItems(): Observable<JsonGunterFoodApi>
}
