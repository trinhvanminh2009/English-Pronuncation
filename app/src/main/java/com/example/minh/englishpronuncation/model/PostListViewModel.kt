package com.example.minh.englishpronuncation.model

import android.arch.lifecycle.MutableLiveData
import android.view.View
import com.example.minh.englishpronuncation.base.BaseViewModel
import com.example.minh.englishpronuncation.network.PostApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostListViewModel : BaseViewModel(){

    @Inject
    lateinit var postApi: PostApi
    private lateinit var subscription: Disposable
    var loadingVisibility : MutableLiveData<Int> = MutableLiveData()




    init {

    }

    private fun loadPosts(){
            subscription = postApi.getPosts().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrievePostListStart() }
            .doOnTerminate {  onRetrievePostListFinish()}
            .subscribe(
                {
                   onRetrievePostListSuccess()
                },
                {
                    onRetrievePostListError()
                }
            )
    }

    private fun onRetrievePostListStart(){
        loadingVisibility.value = View.VISIBLE
    }

    private fun onRetrievePostListFinish(){
        loadingVisibility.value = View.GONE
    }

    private fun onRetrievePostListSuccess(){

    }

    private fun onRetrievePostListError(){

    }


    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }
}