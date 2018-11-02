package com.example.minh.englishpronuncation.model

import android.arch.lifecycle.MutableLiveData
import com.example.minh.englishpronuncation.base.BaseViewModel

class PostViewModel:BaseViewModel(){
    private val posTitle = MutableLiveData<String>()
    private val posBody = MutableLiveData<String>()

    fun bind(post: Post){
        posTitle.value = post.title
        posBody.value =  post.body
    }

    fun getPostTitle(): MutableLiveData<String>{
        return posTitle
    }


    fun getPostBody():MutableLiveData<String>{
        return posBody
    }


}