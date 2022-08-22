package com.messieyawo.gigglemusicpiano.gallery.photoviewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.messieyawo.gigglemusicpiano.gallery.model.PhotoModel
import com.messieyawo.gigglemusicpiano.gallery.repo.PhotoRepository
import com.messieyawo.gigglemusicpiano.videos.model.VideoModel
import com.messieyawo.gigglemusicpiano.videos.repo.VideoRepository


class SharedPhotoViewModel(app: Application) : AndroidViewModel(app) {
    private val dataRepo = PhotoRepository(app)
     //mutableLiveData so that we modify that at run time
    val photosData = dataRepo.photoData
    val isLoading = dataRepo.isLoading

    var selectedPhoto = MutableLiveData<PhotoModel>()

    fun refreshData() {
       // dataRepo.refreshData()
    }

}
