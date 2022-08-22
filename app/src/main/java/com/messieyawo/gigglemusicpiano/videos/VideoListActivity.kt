package com.messieyawo.gigglemusicpiano.videos

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import com.messieyawo.gigglemusicpiano.databinding.ActivityVideoListBinding
import com.messieyawo.gigglemusicpiano.utils.setProgressDialog
import com.messieyawo.gigglemusicpiano.videos.adapter.VideoAdapter
import com.messieyawo.gigglemusicpiano.videos.model.VideoModel
import com.messieyawo.gigglemusicpiano.videos.videoviewmodel.SharedVideoViewModel


class VideoListActivity : AppCompatActivity() {

    private lateinit var viewModel: SharedVideoViewModel
    private lateinit var binding: ActivityVideoListBinding
    private lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
          binding = ActivityVideoListBinding.inflate(layoutInflater)
          setContentView(binding.root)
            toolbar = binding.toolbarVideoList
            setSupportActionBar(toolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
         val dialog = setProgressDialog(this, "Loading videos..")


        viewModel = ViewModelProvider(this).get(SharedVideoViewModel::class.java)

        viewModel.isLoading.observe(this) {
            if (it) {
                dialog.show()
            }
        }
        viewModel.videosData.observe(this) {

            val adapter = VideoAdapter(this, it, object : VideoAdapter.HandledMonsterItem {

                override fun monsterClicked(position: Int) {
                    val video: VideoModel = it[position]

                    val intent = Intent(this@VideoListActivity, VideoDetailsActivity::class.java)
                    intent.putExtra("title", video.video_title)
                    intent.putExtra("description", video.video_description)
                    intent.putExtra("year", video.video_year)
                    intent.putExtra("thumb_nail", video.video_thumb_nail)
                    intent.putExtra("video_link", video.video_link)
                    startActivity(intent)

                }

            })
            binding.recyclerView.adapter = adapter
            dialog.dismiss()
        }

    }


}