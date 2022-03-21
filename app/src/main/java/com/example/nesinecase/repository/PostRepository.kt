package com.example.nesinecase.repository

import com.example.nesinecase.data.response.PostResponse
import com.example.nesinecase.util.DataHolder

interface PostRepository {
    fun getAllPosts(postList: (posts: DataHolder<PostResponse>) -> Unit)
}