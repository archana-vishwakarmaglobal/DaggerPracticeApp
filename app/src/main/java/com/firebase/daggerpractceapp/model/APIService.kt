package com.firebase.daggerpractceapp.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface APIService{
    @GET("posts")
    fun makeRequest(): Call<List<Post>>
}