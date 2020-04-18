package com.firebase.daggerpractceapp.dagger

import com.firebase.daggerpractceapp.User
import dagger.Module
import dagger.Provides

@Module
class UserModule( name:String) {
    private var name:String? = null
    init {
        this.name = name
    }
    @Provides
    fun provideUser(): User {
        return User(name)
    }

}