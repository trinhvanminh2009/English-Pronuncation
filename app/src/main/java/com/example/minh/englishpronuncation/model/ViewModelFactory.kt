package com.example.minh.englishpronuncation.model

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.support.v7.app.AppCompatActivity

class ViewModelFactory(private val activity: AppCompatActivity) :ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        if(modelClass.isAssignableFrom(PostListViewModel :: class.java)){

        }
    }

}