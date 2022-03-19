package com.example.nesinecase.ui.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nesinecase.data.model.Post
import com.example.nesinecase.databinding.ItemPostRowBinding
import com.example.nesinecase.extension.loadImage
import com.example.nesinecase.extension.urlMaker

class PostViewHolder(
    private val binding: ItemPostRowBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(post: Post, itemPosition: Int) {
        binding.post = post
        val uriString = urlMaker(itemPosition)
        binding.postImage.loadImage(uriString)
    }

    companion object {
        fun create(
            parent: ViewGroup,
        ): PostViewHolder {
            val view = ItemPostRowBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            return PostViewHolder(view)
        }
    }
}