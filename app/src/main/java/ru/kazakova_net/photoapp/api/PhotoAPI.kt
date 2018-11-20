package ru.kazakova_net.photoapp.api

import retrofit2.Call
import retrofit2.http.GET
import ru.kazakova_net.photoapp.models.PhotoList

/**
 * Created by Kazakova_net on 19.11.2018.
 */
interface PhotoAPI {
    @GET("?key=10740478-e1f458cc6cac066bb45e36a21&q=nature&image_type=photo")
    fun getPhotos(): Call<PhotoList>
}