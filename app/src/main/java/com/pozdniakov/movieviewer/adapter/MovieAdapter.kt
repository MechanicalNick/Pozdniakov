package com.pozdniakov.movieviewer.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.pozdniakov.movieviewer.data.Movie
import com.pozdniakov.movieviewer.R
import com.pozdniakov.movieviewer.databinding.MovieItemBinding
import com.squareup.picasso.Picasso

private const val maxCharInString = 31

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    var data: MutableList<Movie> = mutableListOf()

    class MovieViewHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MovieItemBinding.inflate(inflater, parent, false)

        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = data[position]

        with(holder.binding) {
            holder.binding.movie = movie

            nameTextView.text =  getName(movie)
            genreTextView.text = getDescription(movie)

            val bundle = bundleOf("movie" to movie)
            holder.binding.toDetailsClickListener = Navigation
                .createNavigateOnClickListener(R.id.detailsFragment, bundle)
            holder.binding.favouriteLongClickListener = View.OnLongClickListener { true }
            Picasso.get()
                .load(movie.posterUrlPreview)
                .into(imageView)
        }
    }

    private fun getName(movie: Movie) : String{
        val name = movie.nameRu.orEmpty()
        return if(name.length > maxCharInString) "${name.take(maxCharInString)}..." else name
    }

    private fun getDescription(movie: Movie) : String{
        val descriptionBuilder = StringBuilder()
        val genre = movie.genres.firstOrNull { x -> !x.genre.isNullOrEmpty()}
        if(genre != null)
            descriptionBuilder.append(genre.genre)
        if(movie.year != null)
            descriptionBuilder.append(if(descriptionBuilder.isNotEmpty()) " (${movie.year})" else movie.year)
        return descriptionBuilder.toString()
    }
}