package com.example.nesinecase.data.api

import com.example.nesinecase.data.response.PostResponse
import io.reactivex.Single
import retrofit2.http.GET

interface PostAPI {

    @GET("posts")
    fun getAllPosts(): Single<PostResponse>
}