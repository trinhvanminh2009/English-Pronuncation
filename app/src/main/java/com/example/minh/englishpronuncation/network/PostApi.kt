package com.example.minh.englishpronuncation.network

import com.example.minh.englishpronuncation.model.Post
import retrofit2.http.GET
import retrofit2.http.POST
import java.util.*

interface PostApi {
    @GET("/posts")
    fun getPosts(): Observable<List<Post>>
}