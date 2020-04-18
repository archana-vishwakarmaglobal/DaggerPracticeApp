package com.firebase.daggerpractceapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.firebase.daggerpractceapp.model.Post
import com.firebase.daggerpractceapp.model.RetrofitRepository

class ApiViewModel( retrofitRepository: RetrofitRepository) : ViewModel() {
      var retrofitRepository: RetrofitRepository
    var postInfoLiveData: LiveData<List<Post>> = MutableLiveData()

    init {
         this.retrofitRepository = retrofitRepository
    }

    private fun fetchPostInfoFromRepository() {
        postInfoLiveData = retrofitRepository.fetchPostInfoList()
    }
}