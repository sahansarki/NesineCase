package com.example.nesinecase.data.repository

import com.example.nesinecase.data.api.PostAPI
import com.example.nesinecase.data.response.PostResponse
import com.example.nesinecase.repository.PostRepository

class PostRepositoryImpl(
    private val postAPI: PostAPI
): PostRepository {

    override suspend fun getAllPosts(): PostResponse {
        return postAPI.getAllPosts()
    }
}