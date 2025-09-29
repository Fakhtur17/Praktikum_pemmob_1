package com.example.hallodek.data.network

import com.example.hallodek.data.model.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenLibraryApi {

    @GET( value = "search.json")
    suspend fun searchBooks(
        @Query( "q") query: String,
        @Query("limit") limit: Int
    ): Response<SearchResponse>
}