package com.example.nesinecase.repository

import com.example.nesinecase.data.response.PostResponse

interface PostRepository {

    suspend fun getAllPosts(): PostResponse
}