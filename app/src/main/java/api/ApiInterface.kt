package com.yoga.tinderapp.api

import com.yoga.tinderapp.api.model.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("search")
    fun searchSong(@Query("term") searchTerm: String): Call<SearchResponse>
}