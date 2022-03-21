package com.example.nesinecase.data.repository

import com.example.nesinecase.data.api.PostAPI
import com.example.nesinecase.data.response.PostResponse
import com.example.nesinecase.repository.PostRepository
import com.example.nesinecase.util.DataHolder
import com.example.nesinecase.util.NesineError
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val postAPI: PostAPI
) : PostRepository {


    override fun getAllPosts(postList: (posts: DataHolder<PostResponse>) -> Unit) {
        postAPI.getAllPosts()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<PostResponse>() {
                override fun onSuccess(t: PostResponse) {
                    postList(DataHolder.success(t))
                }

                override fun onError(e: Throwable) {
                    postList(DataHolder.error(NesineError(e.localizedMessage), null))
                }

            })

    }
}