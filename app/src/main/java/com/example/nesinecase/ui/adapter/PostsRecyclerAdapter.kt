package com.example.nesinecase.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.nesinecase.data.model.Post
import com.example.nesinecase.extension.urlMaker
import com.example.nesinecase.ui.adapter.viewholder.PostViewHolder

class PostsRecyclerAdapter(
    private val clickedItem: (post: Post) -> Unit
) : RecyclerView.Adapter<PostViewHolder>() {
    val differ = AsyncListDiffer(this, DIFF_CALLBACK)

    override fun getItemCount() = differ.currentList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder.create(
            parent
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        differ.currentList[position].url = urlMaker(position)
        holder.bind(differ.currentList[position], position, clickedItem)
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Post>() {
            override fun areItemsTheSame(oldItem: Post, newItem: Post) = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Post, newItem: Post) = oldItem == newItem
        }
    }
}

