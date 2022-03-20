package com.example.nesinecase.data.repository

import com.example.nesinecase.data.api.PostAPI
import com.example.nesinecase.data.response.PostResponse
import com.example.nesinecase.repository.PostRepository
import com.example.nesinecase.util.DataHolder
import com.example.nesinecase.util.NesineError
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val postAPI: PostAPI
): PostRepository {

    override suspend fun getAllPosts(): DataHolder<PostResponse> {
        return try {
            val response = postAPI.getAllPosts()
            DataHolder.success(response)
        } catch(e: Exception) {
            DataHolder.error(NesineError(e.localizedMessage),null)
        }
    }
}