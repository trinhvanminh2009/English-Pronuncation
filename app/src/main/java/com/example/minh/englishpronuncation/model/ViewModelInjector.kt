package com.example.minh.englishpronuncation.model

import com.example.minh.englishpronuncation.injection.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    fun inject(postListViewModel: PostListViewModel)

    @Component.Builder

    interface Builder{
        fun build() : ViewModelInjector

        fun networkModule(networkModule: NetworkModule):Builder
    }

}