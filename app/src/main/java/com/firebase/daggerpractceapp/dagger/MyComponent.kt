package com.firebase.daggerpractceapp.dagger

import com.firebase.daggerpractceapp.model.RetrofitRepository
import com.firebase.daggerpractceapp.view.RetroFragment
import com.firebase.daggerpractceapp.viewmodel.RetroViewModelFactory
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules =  [APIModule::class])
interface MyComponent {
  fun inject(retrofitRepository: RetrofitRepository)
  fun inject(retroViewModelFactory: RetroViewModelFactory)
  fun inject(retroFragment: RetroFragment)

}