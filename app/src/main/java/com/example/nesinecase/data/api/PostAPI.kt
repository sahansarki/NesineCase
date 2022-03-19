package com.example.nesinecase.data.api

import com.example.nesinecase.data.response.PostResponse
import retrofit2.http.GET

interface PostAPI {

    @GET("posts")
    suspend fun getAllPosts(): PostResponse
}