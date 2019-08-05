package com.yudikarma.moviecatalogue.ui.list_movie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.yudikarma.moviecatalogue.R
import com.yudikarma.moviecatalogue.model.Movie
import com.yudikarma.moviecatalogue.ui.detail_movie.DetailMovieActivity
import kotlinx.android.synthetic.main.activity_main.*

class ListMovieActivity : AppCompatActivity(),ListMovieAdapter.OnItemClickListener {


    private lateinit var adapter: ListMovieAdapter
    private  var datas:ArrayList<Movie> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       setupRecycleView()

        setupDataDummy()
    }

    /*please change this data array to source String.xml*/
    private fun setupDataDummy() {
        datas.clear()
        datas.add(Movie("10","poster_glass","Glass","October 3, 2018","Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even…","6.9"))
        datas.add(Movie("11","poster_hunterkiller","Hunter Killer ","October 3, 2018","Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even…","4.9"))
        datas.add(Movie("12","poster_marrypopins","Marry Popins ","October 3, 2018","Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even…","2.9"))
        datas.add(Movie("13","poster_mortalengine","Mortalengine ","October 3, 2018","Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even…","6.9"))
        datas.add(Movie("14","poster_preman","Preman ","October 3, 2018","Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even…","0.9"))
        datas.add(Movie("15","poster_robinhood","Robin Hood ","October 3, 2018","Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even…","6.9"))
        datas.add(Movie("16","poster_spiderman","Spiderman","October 3, 2018","Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even…","2.9"))
        datas.add(Movie("17","poster_thegirl","The Girl","October 3, 2018","Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even…","6.9"))
        datas.add(Movie("18","poster_themule","The Mule ","October 3, 2018","Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even…","1.9"))
        datas.add(Movie("19","poster_venom","Venom ","October 3, 2018","Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even…","6.9"))

        adapter.notifyDataSetChanged()
    }

    private fun setupRecycleView() {
        adapter = ListMovieAdapter(this,datas,this)
        feed_home.layoutManager = LinearLayoutManager(this)
        feed_home.adapter = adapter
    }

    override fun onItemDetailClick(v: View, position: Int, data: Movie) {
        var movie = Movie(data.id,data.poster,data.name,data.rilis,data.description,data.rating)
        val intent  = Intent(this,DetailMovieActivity::class.java)
        intent.putExtra(DetailMovieActivity.MOVIE,movie)
        startActivity(intent)
    }


}
