package com.example.adrey.mvpposts.ui.post

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.adrey.mvpposts.R
import com.example.adrey.mvpposts.databinding.ItemPostBinding
import com.example.adrey.mvpposts.model.Post

class PostAdapter(private val context: Context) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    private var posts: List<Post> = listOf()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PostViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding: ItemPostBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_post, p0, false)
        return PostViewHolder(binding)
    }

    override fun getItemCount(): Int = posts.size

    fun updatePosts(posts: List<Post>) {
        this.posts = posts
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(p0: PostViewHolder, p1: Int) {
        p0.bind(posts[p1])
    }

    class PostViewHolder(private val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(post: Post) {
            binding.post = post
            binding.executePendingBindings()
        }
    }
}