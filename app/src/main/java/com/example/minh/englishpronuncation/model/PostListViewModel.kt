package com.example.minh.englishpronuncation.model

import com.example.minh.englishpronuncation.base.BaseViewModel
import com.example.minh.englishpronuncation.network.PostApi
import javax.inject.Inject

class PostListViewModel : BaseViewModel(){
    @Inject
    lateinit var postApi: PostApi
}