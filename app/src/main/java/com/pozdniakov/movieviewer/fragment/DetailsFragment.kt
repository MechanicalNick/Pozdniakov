package com.pozdniakov.movieviewer.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pozdniakov.movieviewer.api.MainRepository
import com.pozdniakov.movieviewer.api.MovieApi
import com.pozdniakov.movieviewer.databinding.DetailsFragmentBinding
import com.pozdniakov.movieviewer.viewmodel.DetailsViewModel
import com.pozdniakov.movieviewer.viewmodel.ViewModelFactory
import com.squareup.picasso.Picasso

class DetailsFragment : Fragment() {

    private lateinit var binding: DetailsFragmentBinding
    private lateinit var viewModel: DetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val filmId = arguments?.getInt("filmId")
        binding = DetailsFragmentBinding.inflate(layoutInflater)

        val movieApi = MovieApi.getInstance()
        val mainRepository = MainRepository(movieApi)
        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(mainRepository, activity!!.application)
        )[DetailsViewModel::class.java]

        viewModel.description.observe(this) {
            Picasso.get()
                .load(it.posterUrl)
                .into(binding.detailsImageView)

            binding.detailsNameTextView.text = it.nameRu
            binding.detailsCountryTextView.text = it.countries
                .mapNotNull { x -> x.country }.joinToString(" ,")
            binding.detailsGenreTextView.text = it.genres
                .mapNotNull { x -> x.genre }.joinToString(" ,")
            binding.detailsDescriptionTextView.text = it.description

            binding.backClickListener = View.OnClickListener {
                parentFragmentManager.popBackStack()
            }
        }

        viewModel.errorMessage.observe(this) {
            Toast.makeText(this.context, it, Toast.LENGTH_SHORT).show()
        }

        viewModel.loading.observe(this, {
            if (it) {
                binding.progressDialog.visibility = View.VISIBLE
            } else {
                binding.progressDialog.visibility = View.GONE
            }
        })

        filmId?.let { viewModel.getDescription(it) }

        return binding.root
    }
}