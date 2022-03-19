package com.example.nesinecase.ui.fragment.mainScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.nesinecase.data.response.PostResponse
import com.example.nesinecase.repository.PostRepository
import com.example.nesinecase.ui.adapter.base.BaseViewModel
import com.example.nesinecase.util.DataHolder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainFragmentViewModel(
    private val postRepository: PostRepository
): BaseViewModel() {

    private val mutablePostList =  MutableLiveData<DataHolder<PostResponse>>()
    val postList: LiveData<DataHolder<PostResponse>>
        get() = mutablePostList

    init {
        mutablePostList.value = DataHolder.loading()
    }
    fun getAllPosts(){
        viewModelScope.launch(Dispatchers.Main) {
            mutablePostList.value = DataHolder.success(postRepository.getAllPosts())
        }
    }
}