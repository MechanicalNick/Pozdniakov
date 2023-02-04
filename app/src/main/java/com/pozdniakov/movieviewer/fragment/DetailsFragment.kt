package com.pozdniakov.movieviewer.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.pozdniakov.movieviewer.R
import com.pozdniakov.movieviewer.api.MovieApi
import com.pozdniakov.movieviewer.data.Genres
import com.pozdniakov.movieviewer.data.Movie
import com.pozdniakov.movieviewer.databinding.DetailsFragmentBinding
import com.pozdniakov.movieviewer.databinding.PopularFragmentBinding
import com.pozdniakov.movieviewer.repository.MainRepository
import com.pozdniakov.movieviewer.viewmodel.DetailsViewModel
import com.pozdniakov.movieviewer.viewmodel.PopularViewModel
import com.pozdniakov.movieviewer.viewmodel.ViewModelFactory
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

        val movieApi = MovieApi.getInstance()
        val mainRepository = MainRepository(movieApi)
        viewModel = ViewModelProvider(this, ViewModelFactory(mainRepository))[DetailsViewModel::class.java]

        viewModel.description.observe(this) {
            Picasso.get()
                .load(it.posterUrl)
                .into(binding.detailsImageView)
            binding.detailsNameTextView.text = it.nameRu
            binding.detailsCountryTextView.text = it.countries.firstOrNull()?.country
            binding.detailsGenreTextView.text = it.genres.firstOrNull()?.genre
            binding.detailsDescriptionTextView.text = it.description
        }

        viewModel.errorMessage.observe(this) {
            Toast.makeText(this.context, it, Toast.LENGTH_SHORT).show()
        }

        viewModel.loading.observe(this, Observer {
            if (it) {
                binding.progressDialog.visibility = View.VISIBLE
            } else {
                binding.progressDialog.visibility = View.GONE
            }
        })

        movie?.filmId.let { viewModel.getDescription(it!!) }

        return binding.root
    }
}