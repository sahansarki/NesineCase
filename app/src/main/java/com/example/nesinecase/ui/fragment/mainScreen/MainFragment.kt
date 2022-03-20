package com.example.nesinecase.ui.fragment.mainScreen

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nesinecase.R
import com.example.nesinecase.data.model.Post
import com.example.nesinecase.databinding.FragmentMainBinding
import com.example.nesinecase.enum.RepositoryStatus
import com.example.nesinecase.extension.dismissProgress
import com.example.nesinecase.extension.showProgress
import com.example.nesinecase.ui.adapter.PostsRecyclerAdapter
import com.example.nesinecase.ui.adapter.base.BaseFragment
import com.example.nesinecase.ui.fragment.detailScreen.DetailBottomSheetFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private lateinit var postsAdapter: PostsRecyclerAdapter
    private val mainFragmentViewModel: MainFragmentViewModel by viewModels()

    override fun getLayoutResId(): Int = R.layout.fragment_main

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postsAdapter = PostsRecyclerAdapter{ clickedItem ->
            val bottomSheet = DetailBottomSheetFragment(clickedItem){ clickedPost ->

                val postList = mutableListOf<Post>()

                postsAdapter.differ.currentList.toMutableList().map { post ->
                    val localPost = post.copy()
                    if(localPost.id == clickedPost.id){
                        localPost.title = clickedPost.title
                        localPost.body = clickedPost.body
                    }
                    postList.add(localPost)
                }
                postsAdapter.differ.submitList(postList)
            }
            bottomSheet.show(
                parentFragmentManager, DetailBottomSheetFragment.TAG
            )

        }

        val mDividerItemDecoration =
            DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)

        with(fragmentDataBinding.postsRc) {
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )
            adapter = postsAdapter
            addItemDecoration(mDividerItemDecoration)
        }

        mainFragmentViewModel.getAllPosts()
        observePostsList()
    }

    private fun observePostsList() {
        mainFragmentViewModel.postList.observe(this){
            when(it.status){
                RepositoryStatus.OK -> {
                    requireContext().dismissProgress()
                    postsAdapter.differ.submitList(it.data!!)
                }

                RepositoryStatus.LOADING -> {
                    requireContext().showProgress()
                }

                RepositoryStatus.ERROR -> {
                    requireContext().dismissProgress()
                    Toast.makeText(requireContext(),it.error!!.message,Toast.LENGTH_LONG).show()
                }
            }
        }
    }

}