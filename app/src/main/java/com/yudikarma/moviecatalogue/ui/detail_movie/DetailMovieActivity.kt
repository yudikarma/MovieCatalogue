package com.yudikarma.moviecatalogue.ui.detail_movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yudikarma.moviecatalogue.R
import com.yudikarma.moviecatalogue.model.Movie
import kotlinx.android.synthetic.main.activity_detail_movie.*

class DetailMovieActivity : AppCompatActivity() {

    companion object{
        var MOVIE = "MOVIE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        val movie:Movie = intent.getParcelableExtra(MOVIE)
        setupViewDetail(movie)
    }

    private fun setupViewDetail(movie: Movie) {
        imageView.setImageResource(this.resources.getIdentifier("drawable/"+movie.poster,null,this.packageName))
        textView.text = ""+movie.name
        textView2.text = ""+movie.rilis
        description.text = ""+movie.description
        ratingBar.rating = movie.rating.toFloat()
    }
}
