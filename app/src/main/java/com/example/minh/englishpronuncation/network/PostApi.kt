package com.example.minh.englishpronuncation.network

import android.database.Observable
import com.example.minh.englishpronuncation.model.Post
import retrofit2.http.GET

interface PostApi {
    @GET("/posts")
    fun getPosts(): io.reactivex.Observable<List<Post>>
}