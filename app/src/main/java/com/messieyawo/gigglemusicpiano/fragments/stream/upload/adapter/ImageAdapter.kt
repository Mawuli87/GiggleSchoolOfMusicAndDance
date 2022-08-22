package com.messieyawo.gigglemusicpiano.fragments.stream.upload.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.messieyawo.gigglemusicpiano.fragments.stream.upload.model.ImgModel
import com.messieyawo.gigglemusicpiano.databinding.ImagesItemBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class ImageAdapter(var context : Context,
                   var userList : ArrayList<ImgModel>) : RecyclerView.Adapter<ImageAdapter.imgModelViewHolder>() {

    inner class imgModelViewHolder(val adapterBinding : ImagesItemBinding)
        : RecyclerView.ViewHolder(adapterBinding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): imgModelViewHolder {

        val binding = ImagesItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return imgModelViewHolder(binding)

    }

    override fun onBindViewHolder(holder: imgModelViewHolder, position: Int) {

        holder.adapterBinding.textViewTitle .text = userList[position].title


        val imageUrl = userList[position].url

        Picasso.get().load(imageUrl).into(holder.adapterBinding.PostImageView, object : Callback{
            override fun onSuccess() {
                holder.adapterBinding.progressBarImg.visibility = View.INVISIBLE
            }

            override fun onError(e: Exception?) {
                Toast.makeText(context,e?.localizedMessage,Toast.LENGTH_SHORT).show()
            }
        })

        holder.adapterBinding.linearLayout.setOnClickListener {
//
//            val intent = Intent(context, UpdateUserActivity::class.java)
//            intent.putExtra("id",userList[position].userId)
//            intent.putExtra("name",userList[position].userName)
//            intent.putExtra("age",userList[position].userAge)
//            intent.putExtra("email",userList[position].userEmail)
//            intent.putExtra("imageUrl",imageUrl)
//            intent.putExtra("imageName",userList[position].imageName)
//            context.startActivity(intent)

        }

    }

    override fun getItemCount(): Int {

        return userList.size

    }

    fun getUserId(position: Int) : String{

        return userList[position].imgId

    }

    fun getImageName(position: Int) : String{

        return userList[position].imageName

    }

}