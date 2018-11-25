package com.example.adrey.mvpposts.ui.post

import android.support.annotation.StringRes
import com.example.adrey.mvpposts.base.BaseView
import com.example.adrey.mvpposts.model.Post

interface PostView : BaseView {

    fun updatePosts(posts: List<Post>)

    fun showError(error: String)

    fun showError(@StringRes errorResId: Int) {
        this.showError(getContext().getString(errorResId))
    }

    fun showLoading()

    fun hideLoading()
}