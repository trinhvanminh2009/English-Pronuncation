package com.example.minh.englishpronuncation.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.minh.englishpronuncation.databinding.ItemPostBinding
import com.example.minh.englishpronuncation.model.Post
import com.example.minh.englishpronuncation.model.PostViewModel

class PostListAdapter : RecyclerView.Adapter<PostListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class ViewHolder(private val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = PostViewModel()
        fun bind(post: Post) {
            viewModel.bind(post)
            binding.viewModel = viewModel
        }

    }
}