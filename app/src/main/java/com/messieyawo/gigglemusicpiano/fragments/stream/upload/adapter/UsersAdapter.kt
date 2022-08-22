package com.messieyawo.gigglemusicpiano.fragments.stream.upload.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.messieyawo.gigglemusicpiano.databinding.UsersItemBinding
import com.messieyawo.gigglemusicpiano.fragments.stream.upload.model.Users

class UsersAdapter(var context : Context,
                   var userList : ArrayList<Users>) : RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {

    inner class UsersViewHolder(val adapterBinding : UsersItemBinding)
        : RecyclerView.ViewHolder(adapterBinding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {

        val binding = UsersItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return UsersViewHolder(binding)

    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {

        holder.adapterBinding.titlePost.text = userList[position].title
        holder.adapterBinding.descriptionTextPost.text = userList[position].post



        holder.adapterBinding.linearLayout.setOnClickListener {

//            val intent = Intent(context, UpdateUserActivity::class.java)
//            intent.putExtra("id",userList[position].postId)
//            intent.putExtra("title",userList[position].title)
//            intent.putExtra("post",userList[position].post)
//
//            context.startActivity(intent)

        }

    }

    override fun getItemCount(): Int {

        return userList.size

    }

    fun getUserId(position: Int) : String{

        return userList[position].postId

    }

//    fun getImageName(position: Int) : String{
//
//        return userList[position].imageName
//
//    }

}