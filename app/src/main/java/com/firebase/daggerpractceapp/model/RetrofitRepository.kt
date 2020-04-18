package com.firebase.daggerpractceapp.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.firebase.daggerpractceapp.User
import com.firebase.daggerpractceapp.dagger.MyComponent
import com.firebase.daggerpractceapp.dagger.MyRetroApplication
import retrofit2.*
import javax.inject.Inject

class RetrofitRepository {
    lateinit var myComponent: MyComponent
    @Inject
    lateinit var retrofit: Retrofit
//    @Inject
//    lateinit var user: User

    init {
        MyRetroApplication.apiComponent.inject(this)
    }

    fun fetchPostInfoList(): MutableLiveData<List<Post>> {
        var livedata = MutableLiveData<List<Post>>()
        println("retrofit is getting printed$retrofit")
        Log.d("REPOSITORY", "retorigt $retrofit")
      //  Log.d("REPOSITORY", "user ${user}")
        var call = retrofit.create(APIService::class.java).makeRequest()
        call.enqueue(object : Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.d("RetroRepository", "Failed:::" + t.message)
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                var postInfoList = response.body()
                livedata.value = postInfoList
            }

        })
        return livedata
    }
}