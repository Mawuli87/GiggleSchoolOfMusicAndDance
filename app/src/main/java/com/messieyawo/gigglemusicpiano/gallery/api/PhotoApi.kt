package com.messieyawo.gigglemusicpiano.gallery.api

import com.messieyawo.gigglemusicpiano.gallery.model.PhotoModel
import retrofit2.Response
import retrofit2.http.GET

interface PhotoApi {
    @GET("/API/appimg/giggle_images.json")
    suspend fun getPhotossData(): Response<List<PhotoModel>>
}