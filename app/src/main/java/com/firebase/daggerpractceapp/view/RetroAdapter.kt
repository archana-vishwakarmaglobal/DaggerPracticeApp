package com.firebase.daggerpractceapp.view

import android.database.DatabaseUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.firebase.daggerpractceapp.BR
import com.firebase.daggerpractceapp.R
import com.firebase.daggerpractceapp.databinding.PostListItemBinding
import com.firebase.daggerpractceapp.model.Post
import kotlinx.android.synthetic.main.post_list_item.view.*

class RetroAdapter : RecyclerView.Adapter<RetroAdapter.RetroViewHolder>() {
    lateinit var binding :PostListItemBinding
    lateinit var list: List<Post>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetroViewHolder {
        var inflater = LayoutInflater.from(parent.context)
       binding = DataBindingUtil.inflate(inflater, R.layout.post_list_item, parent,false)
        return RetroViewHolder(binding)
    }

    override fun getItemCount(): Int {
      return  list.size
    }

    override fun onBindViewHolder(holder: RetroViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun setAdapterList(list: List<Post>) {
        this.list = list
        notifyDataSetChanged()
    }

    class RetroViewHolder(val  binding: PostListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Post) {
            binding.setVariable(BR.post, post)
            binding.executePendingBindings()
        }

    }
}