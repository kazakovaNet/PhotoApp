package ru.kazakova_net.photoapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import ru.kazakova_net.photoapp.models.Photo

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val imageView = findViewById<ImageView>(R.id.imageView)
        val photo = intent.getSerializableExtra(PHOTO) as Photo?

        photo?.webformatURL.let {
            Glide.with(this).load(photo?.webformatURL).into(imageView)
        }

        imageView.setOnClickListener{
            finish()
        }
    }

    companion object {
        val PHOTO = "PHOTO"
    }
}
