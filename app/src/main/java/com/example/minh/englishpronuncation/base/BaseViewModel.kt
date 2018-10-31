package com.example.minh.englishpronuncation.base

import android.arch.lifecycle.ViewModel
import com.example.minh.englishpronuncation.injection.NetworkModule
import com.example.minh.englishpronuncation.model.DaggerViewModelInjector
import com.example.minh.englishpronuncation.model.PostListViewModel
import com.example.minh.englishpronuncation.model.ViewModelInjector


abstract class BaseViewModel:ViewModel(){
        private val injector:ViewModelInjector = DaggerViewModelInjector
                .builder()
                .networkModule(NetworkModule)
                .build()


        init {
                inject()
        }

        private fun inject(){
                when(this){
                        is PostListViewModel -> injector.inject(this)
                }
        }
}
