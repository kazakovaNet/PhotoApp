package ru.kazakova_net.photoapp.api

import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.kazakova_net.photoapp.models.PhotoList

/**
 * Created by Kazakova_net on 19.11.2018.
 */
class PhotoRetriever {
    private val service: PhotoAPI

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://pixabay.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        service = retrofit.create(PhotoAPI::class.java)
    }

    fun getPhotos(callback: Callback<PhotoList>) {
        val call = service.getPhotos()
        call.enqueue(callback)
    }
}