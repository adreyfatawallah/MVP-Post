package com.example.adrey.mvpposts.base

import com.example.adrey.mvpposts.injection.component.DaggerPresenterInjection
import com.example.adrey.mvpposts.injection.component.PresenterInjection
import com.example.adrey.mvpposts.injection.module.ContextModule
import com.example.adrey.mvpposts.injection.module.NetworkModule
import com.example.adrey.mvpposts.ui.post.PostPresenter

abstract class BasePresenter<out V: BaseView>(protected val view: V) {

    private val injector: PresenterInjection = DaggerPresenterInjection
            .builder()
            .baseView(view)
            .contextModule(ContextModule)
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    open fun onViewCreated(){}

    open fun onViewDestroyed(){}

    private fun inject() {
        when(this) {
            is PostPresenter -> injector.inject(this)
        }
    }
}