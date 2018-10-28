package com.example.minh.englishpronuncation.injection

import com.example.minh.englishpronuncation.network.PostApi
import com.example.minh.englishpronuncation.utils.BASE_URL
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

object NetworkModule{
    internal fun providePostApi(retrofit: Retrofit):PostApi{
        return retrofit.create(PostApi::class.java)
    }

    internal fun provideRetrofitInterface(): Retrofit  {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }
}