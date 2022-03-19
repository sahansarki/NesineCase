package com.example.nesinecase.ui.fragment.detailScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.navArgs
import com.example.nesinecase.R
import com.example.nesinecase.data.model.Post
import com.example.nesinecase.databinding.FragmentDetailBottomSheetBinding
import com.example.nesinecase.extension.loadImage
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailBottomSheetFragment(
    private val post: Post,
    private val updateCallback: (post: Post) -> Unit
) : BottomSheetDialogFragment() {

    private lateinit var bottomSheetBinding: FragmentDetailBottomSheetBinding

    companion object {
        const val TAG = "DetailBottomSheetFragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.ThemeOverlay_BottomSheetDialog)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bottomSheetBinding = FragmentDetailBottomSheetBinding.inflate(layoutInflater)
        return bottomSheetBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomSheetBinding.post = post
        bottomSheetBinding.postImage.loadImage(post.url)

        bottomSheetBinding.updateButton.setOnClickListener {
            post.title = bottomSheetBinding.postTitle.text.toString()
            post.body = bottomSheetBinding.postBody.text.toString()
            updateCallback(post)
            this@DetailBottomSheetFragment.dismiss()
        }

    }

}