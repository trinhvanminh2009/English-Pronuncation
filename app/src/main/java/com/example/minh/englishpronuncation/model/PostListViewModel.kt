package com.example.minh.englishpronuncation.model

import android.arch.lifecycle.MutableLiveData
import android.view.View
import com.example.minh.englishpronuncation.R
import com.example.minh.englishpronuncation.adapter.PostListAdapter
import com.example.minh.englishpronuncation.base.BaseViewModel
import com.example.minh.englishpronuncation.network.PostApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostListViewModel : BaseViewModel() {

    val postListAdapter: PostListAdapter = PostListAdapter()

    @Inject
    lateinit var postApi: PostApi

    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadPosts() }

    private lateinit var subscription: Disposable
    var loadingVisibility: MutableLiveData<Int> = MutableLiveData()


    init {

    }

    private fun loadPosts() {
        subscription = postApi.getPosts().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrievePostListStart() }
            .doOnTerminate { onRetrievePostListFinish() }
            .subscribe(
                {
                    result -> onRetrievePostListSuccess(result)
                },
                {
                    onRetrievePostListError()
                }
            )
    }

    private fun onRetrievePostListStart() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrievePostListFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrievePostListSuccess(postList : List<Post>) {
        postListAdapter
    }

    private fun onRetrievePostListError() {
        errorMessage.value = R.string.post_error
    }


    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }
}