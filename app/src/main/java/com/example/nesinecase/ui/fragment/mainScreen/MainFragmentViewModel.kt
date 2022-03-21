package com.example.nesinecase.ui.fragment.mainScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nesinecase.data.response.PostResponse
import com.example.nesinecase.di.PostRepositoryImpl
import com.example.nesinecase.repository.PostRepository
import com.example.nesinecase.ui.adapter.base.BaseViewModel
import com.example.nesinecase.util.DataHolder
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel @Inject constructor(
    @PostRepositoryImpl private val postRepository: PostRepository
) : BaseViewModel() {

    private val mutablePostList = MutableLiveData<DataHolder<PostResponse>>()
    val postList: LiveData<DataHolder<PostResponse>>
        get() = mutablePostList

    init {
        mutablePostList.value = DataHolder.loading()
    }

    fun getAllPosts() {
        postRepository.getAllPosts {
            mutablePostList.value = it
        }

    }
}