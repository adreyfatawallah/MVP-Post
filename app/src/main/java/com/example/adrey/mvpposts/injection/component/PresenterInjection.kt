package com.example.adrey.mvpposts.injection.component

import com.example.adrey.mvpposts.base.BaseView
import com.example.adrey.mvpposts.injection.module.ContextModule
import com.example.adrey.mvpposts.injection.module.NetworkModule
import com.example.adrey.mvpposts.ui.post.PostPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(ContextModule::class), (NetworkModule::class)])
interface PresenterInjection {

    fun inject(postPresenter: PostPresenter)

    @Component.Builder
    interface Builder {
        fun build(): PresenterInjection

        fun networkModule(networkModule: NetworkModule): Builder
        fun contextModule(contextModule: ContextModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }
}