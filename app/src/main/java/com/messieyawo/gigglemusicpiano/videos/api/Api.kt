package com.messieyawo.gigglemusicpiano.videos.api

import com.messieyawo.gigglemusicpiano.videos.model.VideoModel
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("/API/appimg/giggle_videos.json")
    suspend fun getVideosData(): Response<List<VideoModel>>
}