package com.chetv.fooddeliveryapp.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object{
        private var retrofit: Retrofit? = null
        private val interceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        private val clientOkhttp = OkHttpClient.Builder().addInterceptor(interceptor)
        private val BASE_URL = "https://gunter-food-api.herokuapp.com"

        fun getInstance(): Retrofit{
            if (retrofit== null){
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(clientOkhttp.build())
                    .build()
            }
            return retrofit!!
        }
    }
}