package com.firebase.daggerpractceapp.dagger

import android.app.Application
import android.content.Context
import com.firebase.daggerpractceapp.model.APIURL

class MyRetroApplication : Application() {

/** Initiate DaggerComponent globally to be accessible across application in Application class*/
    companion object {
        var ctx: Context? = null
        lateinit var apiComponent: MyComponent
    }

    override fun onCreate() {
        super.onCreate()
        ctx = applicationContext
        apiComponent = initDaggerComponent()

    }

    fun getMyComponent(): MyComponent {
        return apiComponent
    }

    fun initDaggerComponent(): MyComponent {
        apiComponent = DaggerMyComponent
                .builder()
                .aPIModule(APIModule(APIURL.BASE_URL))
               // .userModule(UserModule("Archana"))
                .build()
        return apiComponent

    }
}