package com.example.hallodek.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.hallodek.utils.Constants

object RetrofitInstance {
    val api: OpenLibraryApi by lazy {
        Retrofit.Builder()
            .baseUrl(  Constants.BASE_URL)
            .addConverterFactory ( GsonConverterFactory.create())
            .build()
            .create(OpenLibraryApi::class.java)
    }
}