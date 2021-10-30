package com.example.segundoparcialaplicada2.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: ProductoApi by lazy{
        Retrofit.Builder()
            .baseUrl("https://aplicada2021.azurewebsites.net/api/") //Este link sólo se usa para la prueba, el verdadero link no lo puedo usar
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductoApi::class.java)
    }
}