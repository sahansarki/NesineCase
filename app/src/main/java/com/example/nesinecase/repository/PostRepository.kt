package com.example.nesinecase.repository

import com.example.nesinecase.data.response.PostResponse
import com.example.nesinecase.util.DataHolder

interface PostRepository {

    suspend fun getAllPosts(): DataHolder<PostResponse>
}