package ru.kazakova_net.photoapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import ru.kazakova_net.photoapp.models.Photo

/**
 * Created by Kazakova_net on 19.11.2018.
 */
class MainAdapter(var photos: List<Photo>,
                  var clickListener: View.OnClickListener) :
        RecyclerView.Adapter<MainAdapter.PhotoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): PhotoViewHolder {
        return PhotoViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.photo_item, parent, false))
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    fun getPhoto(adapterPosition: Int): Photo {
        return photos[adapterPosition]
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo = photos[position]
        holder?.tags?.text = photo.tags
        holder?.likes?.text = photo.likes.toString()
        holder?.favorites?.text = photo.favorites.toString()
        if (photo.previewURL.isNotEmpty()) {
            Glide.with(holder?.tags?.context)
                    .load(photo.previewURL)
                    .into(holder?.photo_item)
        }
    }

    inner class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tags: TextView
        val likes: TextView
        val favorites: TextView
        val photo_item: ImageView

        init {
            if (clickListener != null) {
                itemView.setOnClickListener(clickListener)
            }
            itemView.tag = this
            tags = itemView.findViewById(R.id.tags) as TextView
            likes = itemView.findViewById(R.id.likes) as TextView
            favorites = itemView.findViewById(R.id.favorites) as TextView
            photo_item = itemView.findViewById(R.id.photo_item) as ImageView
        }
    }
}