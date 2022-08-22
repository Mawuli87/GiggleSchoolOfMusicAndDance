package com.messieyawo.gigglemusicpiano.gallery.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.messieyawo.gigglemusicpiano.R
import com.messieyawo.gigglemusicpiano.gallery.model.PhotoModel


class PhotoAdapter(
    private val context: Context,
    private val photoList:List<PhotoModel>,
    private val handledPhotoItem: HandledPhotoItem
) :RecyclerView.Adapter<PhotoAdapter.ViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.photo_grid_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val photo =photoList[position]

        Glide.with(context)
            .load(photo.image_thumb_nail)
            .into(holder.photoImage)

        holder.itemView.setOnClickListener {
            handledPhotoItem.photoClicked(position)
        }
    }

    override fun getItemCount(): Int {
       return photoList.size
    }

    inner class ViewHolder(ItemView:View):RecyclerView.ViewHolder(ItemView) {

       val photoImage:ImageView = ItemView.findViewById(R.id.galleryImage)

    }

    interface HandledPhotoItem{
        fun photoClicked(position: Int)
    }
}
