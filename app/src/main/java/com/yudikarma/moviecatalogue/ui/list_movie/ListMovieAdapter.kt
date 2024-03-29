package com.yudikarma.moviecatalogue.ui.list_movie

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yudikarma.moviecatalogue.R
import com.yudikarma.moviecatalogue.model.Movie

class ListMovieAdapter(var context:Context,private val datas:MutableList<Movie>,val listener:ListMovieAdapter.OnItemClickListener):
    RecyclerView.Adapter<ListMovieAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view =LayoutInflater.from(context).inflate(R.layout.item_movie,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = datas.get(position)
        holder.bind(item)
        holder.itemView.setOnClickListener { listener.onItemDetailClick(it,position,item) }
    }

    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var posterMovie: ImageView
        internal var nameMovie: TextView
        internal var rilisMovie: TextView
        internal var sinopsisMovie: TextView
        internal var ratingMovie:RatingBar

        init {
            posterMovie = itemView.findViewById(R.id.poster_movie)
            nameMovie = itemView.findViewById(R.id.name_movie)
            rilisMovie = itemView.findViewById(R.id.rilis_movie)
            sinopsisMovie = itemView.findViewById(R.id.artist_movie)
            ratingMovie = itemView.findViewById(R.id.rating_movie)


        }

        fun bind(item: Movie) {
            nameMovie.text = "${item.name}"
            posterMovie.setImageResource(context.resources.getIdentifier("drawable/"+item.poster,null,context.packageName))
            rilisMovie.text = "${item.rilis}"
            sinopsisMovie.text = "${item.description}"
            ratingMovie.rating = "${item.rating}".toFloat()
        }
    }

    interface OnItemClickListener {
        fun onItemDetailClick(v: View, position: Int,data:Movie)
    }
}