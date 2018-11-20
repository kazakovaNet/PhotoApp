package ru.kazakova_net.photoapp.models

import java.io.Serializable

/**
 * Created by Kazakova_net on 19.11.2018.
 */
data class Photo(val id: String,
                 val likes: Int,
                 val favorites: Int,
                 val tags: String,
                 val previewURL: String,
                 val webformatURL: String) : Serializable {
}