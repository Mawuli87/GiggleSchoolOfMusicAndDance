package com.messieyawo.gigglemusicpiano.gallery.repo

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.messieyawo.gigglemusicpiano.gallery.api.PhotoApi
import com.messieyawo.gigglemusicpiano.gallery.model.PhotoModel
import com.messieyawo.gigglemusicpiano.utils.WEB_SERVICE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class PhotoRepository(val app:Application) {

    val photoData = MutableLiveData<List<PhotoModel>>()

      private val _isLoading = MutableLiveData(false)
       val isLoading: LiveData<Boolean>
       get() = _isLoading

    init {
       CoroutineScope(Dispatchers.IO).launch {
           callWebService()
       }
    }

    @WorkerThread
    suspend fun callWebService() {
        if (networkAvailable()) {

            withContext(Dispatchers.Main) {
              //  Toast.makeText(app, "Using remote data", Toast.LENGTH_LONG).show()
                _isLoading.value = true
            }

            val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(WEB_SERVICE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
            val service = retrofit.create(PhotoApi::class.java)
            val serviceData = service.getPhotossData().body() ?: emptyList()

            photoData.postValue(serviceData)

            withContext(Dispatchers.Main) {
                //  Toast.makeText(app, "Using remote data", Toast.LENGTH_LONG).show()
                _isLoading.value = false
            }

        }
    }


    @Suppress("DEPRECATION")
    private fun networkAvailable(): Boolean {
        val connectivityManager = app.getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo?.isConnectedOrConnecting ?: false
    }
}