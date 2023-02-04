package com.pozdniakov.movieviewer.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pozdniakov.movieviewer.data.Movie
import com.pozdniakov.movieviewer.databinding.MovieItemBinding

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    var data: MutableList<Movie> = mutableListOf(Movie("hello", "genre1"),
        Movie("world", "genre2"))
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    class MovieViewHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MovieItemBinding.inflate(inflater, parent, false)

        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = data[position]
        with(holder.binding) {
            nameTextView.text = movie.name
            genreTextView.text = movie.genre
        }
    }
}