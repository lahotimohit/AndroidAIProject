package com.example.androidaiproject

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface AI_Interface {
    @GET("api/hello/{question}")
    fun getResult(@Path("question") question: String?): Call<JsonObject>
}