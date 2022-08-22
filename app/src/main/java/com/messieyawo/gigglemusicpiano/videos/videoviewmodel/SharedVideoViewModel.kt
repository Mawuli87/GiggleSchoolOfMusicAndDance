package com.messieyawo.gigglemusicpiano.videos.videoviewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.messieyawo.gigglemusicpiano.videos.model.VideoModel
import com.messieyawo.gigglemusicpiano.videos.repo.VideoRepository


class SharedVideoViewModel(app: Application) : AndroidViewModel(app) {
    private val dataRepo = VideoRepository(app)
     //mutableLiveData so that we modify that at run time
    val videosData = dataRepo.videoData
    val isLoading = dataRepo.isLoading

    var selectedVideo = MutableLiveData<VideoModel>()

    fun refreshData() {
       // dataRepo.refreshData()
    }

}
