package com.messieyawo.gigglemusicpiano.videos

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.messieyawo.gigglemusicpiano.R
import com.messieyawo.gigglemusicpiano.databinding.ActivityVideoDetailsBinding
import com.messieyawo.gigglemusicpiano.utils.setProgressDialog
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView


class VideoDetailsActivity : AppCompatActivity() {
   private lateinit var dialog:AlertDialog
   private lateinit var binding: ActivityVideoDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        val video_link = intent.getStringExtra("video_link").toString()
        val video_title = intent.getStringExtra("title").toString()
        val video_description = intent.getStringExtra("description").toString()
        val video_year = intent.getStringExtra("year").toString()

        dialog = setProgressDialog(this, "Preparing $video_title video..")

         playVideo(video_link,video_title,video_year,video_description)

    }

    private fun playVideo(video_link:String,video_title:String,video_year: String,video_description:String) {
        dialog.show()
        val youTubePlayerView = findViewById<YouTubePlayerView>(R.id.youtube_player_view)
        lifecycle.addObserver(youTubePlayerView)

        youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                dialog.dismiss()
                val videoId = video_link
                youTubePlayer.loadVideo(videoId, 0f)
                binding.videoTitle.text = video_title
                binding.videoYear.text = video_year
                binding.videoDescription.text = video_description
                binding.viewsRoot.visibility = View.VISIBLE
            }
        })

    }



}