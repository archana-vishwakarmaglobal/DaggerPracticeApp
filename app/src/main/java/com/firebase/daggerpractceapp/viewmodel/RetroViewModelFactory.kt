package com.firebase.daggerpractceapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.firebase.daggerpractceapp.dagger.MyRetroApplication
import com.firebase.daggerpractceapp.model.RetrofitRepository
import javax.inject.Inject

class RetroViewModelFactory: ViewModelProvider.Factory {
    lateinit var application: MyRetroApplication
    @Inject
    lateinit var retrofitRepository: RetrofitRepository
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
          application = MyRetroApplication()
          var myComponent = application.getMyComponent()
          myComponent.inject(this)
        if (modelClass.isAssignableFrom(ApiViewModel::class.java)) {
            return ApiViewModel(retrofitRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}