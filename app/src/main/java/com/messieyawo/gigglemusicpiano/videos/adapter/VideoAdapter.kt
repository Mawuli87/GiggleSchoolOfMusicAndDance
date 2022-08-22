package com.messieyawo.gigglemusicpiano.videos.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.messieyawo.gigglemusicpiano.R
import com.messieyawo.gigglemusicpiano.videos.model.VideoModel


class VideoAdapter(
    private val context: Context,
    private val videoList:List<VideoModel>,
    private val handledMonsterItem: HandledMonsterItem
) :RecyclerView.Adapter<VideoAdapter.ViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.monster_grid_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val video =videoList[position]
        holder.videoName.text = video.video_title
       // holder.ratingBar.rating = video.scariness.toFloat()

        Glide.with(context)
            .load(video.video_thumb_nail)
            .into(holder.videoImage)

        Glide.with(context)
            .load(video.video_play_btn)
            .into(holder.videobtnImage)

        holder.itemView.setOnClickListener {
              handledMonsterItem.monsterClicked(position)
        }
    }

    override fun getItemCount(): Int {
       return videoList.size
    }

    inner class ViewHolder(ItemView:View):RecyclerView.ViewHolder(ItemView) {

        val videoName:TextView = ItemView.findViewById(R.id.nameText)
       val videoImage:ImageView = ItemView.findViewById(R.id.monsterImage)
        val videobtnImage:ImageView = ItemView.findViewById(R.id.plaBtn)
       // val ratingBar :RatingBar = ItemView.findViewById(R.id.ratingBar)
    }

    interface HandledMonsterItem{
        fun monsterClicked(position: Int)
    }
}
