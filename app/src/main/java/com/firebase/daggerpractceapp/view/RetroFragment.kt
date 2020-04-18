package com.firebase.daggerpractceapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.daggerpractceapp.R
import com.firebase.daggerpractceapp.dagger.MyRetroApplication
import com.firebase.daggerpractceapp.databinding.LayoutRetroFragmentBinding
import com.firebase.daggerpractceapp.model.RetrofitRepository
import com.firebase.daggerpractceapp.viewmodel.ApiViewModel
import com.firebase.daggerpractceapp.viewmodel.RetroViewModelFactory
import kotlinx.android.synthetic.main.layout_retro_fragment.*
import javax.inject.Inject

class RetroFragment:Fragment() {
    lateinit var apiViewModel: ApiViewModel
    lateinit var binding:LayoutRetroFragmentBinding
    lateinit var   listAdapter: RetroAdapter
    lateinit var viewModel: ApiViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewMdoel()
    }

    private fun initViewMdoel() {
         var retroViewModelFactory = RetroViewModelFactory()
        apiViewModel = ViewModelProviders.of(this,retroViewModelFactory).get(ApiViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       // return super.onCreateView(inflater, container, savedInstanceState)
       // var layoutinflater = LayoutInflater.from(context)
        binding = DataBindingUtil.inflate(inflater, R.layout.layout_retro_fragment,container, false)
        initAdapter()
        setAdapter()
        fetchRetroInfo()
        return binding.root
    }

    private fun fetchRetroInfo() {
        var viewModelFactory = RetroViewModelFactory()
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ApiViewModel::class.java)
        viewModel.postInfoLiveData.observe(this, Observer {
            listAdapter.setAdapterList(it)
        })
    }

    private fun setAdapter() {
        recycler_view_retro.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = listAdapter
        }
    }

    private fun initAdapter() {
          listAdapter = RetroAdapter()

    }
}