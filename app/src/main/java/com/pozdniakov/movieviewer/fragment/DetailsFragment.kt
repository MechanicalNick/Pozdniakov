package com.pozdniakov.movieviewer.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pozdniakov.movieviewer.R
import com.pozdniakov.movieviewer.data.Genres
import com.pozdniakov.movieviewer.data.Movie
import com.pozdniakov.movieviewer.databinding.DetailsFragmentBinding
import com.pozdniakov.movieviewer.databinding.PopularFragmentBinding
import com.pozdniakov.movieviewer.viewmodel.DetailsViewModel
import com.squareup.picasso.Picasso

class DetailsFragment : Fragment() {

    private lateinit var binding: DetailsFragmentBinding
    private lateinit var viewModel: DetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var movie = arguments?.getParcelable("movie") as Movie?
        binding = DetailsFragmentBinding.inflate(layoutInflater)
        movie?.let {
            Picasso.get()
                .load(movie.posterUrl)
                .into(binding.detailsImageView)
            binding.detailsNameTextView.text = movie.nameRu
            binding.detailsCountryTextView.text = movie.countries.firstOrNull()?.country
            binding.detailsGenreTextView.text = movie.genres.firstOrNull()?.genre
            binding.detailsDescriptionTextView.text = movie.ratingVoteCount?.toString()
        }


        return binding.root
    }
}