package com.pozdniakov.movieviewer.fragment

import MovieAdapter
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pozdniakov.movieviewer.R
import com.pozdniakov.movieviewer.api.MovieApi
import com.pozdniakov.movieviewer.data.api.Movie
import com.pozdniakov.movieviewer.databinding.FavouriteFragmentBinding
import com.pozdniakov.movieviewer.decorator.MarginItemDecoration
import com.pozdniakov.movieviewer.api.MainRepository
import com.pozdniakov.movieviewer.viewmodel.FavouriteViewModel
import com.pozdniakov.movieviewer.viewmodel.ViewModelFactory

class FavouriteFragment : Fragment() {
    private lateinit var viewModel: FavouriteViewModel
    private lateinit var binding: FavouriteFragmentBinding
    private lateinit var adapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FavouriteFragmentBinding.inflate(layoutInflater)

        val movieApi = MovieApi.getInstance()
        val mainRepository = MainRepository(movieApi)

        viewModel = ViewModelProvider(this,
            ViewModelFactory(mainRepository, activity!!.application))[FavouriteViewModel::class.java]
        adapter = MovieAdapter(viewModel)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(
            MarginItemDecoration(resources.getDimensionPixelSize(R.dimen.margin))
        )

        viewModel.loading.observe(this) {
            if (it) {
                binding.progressDialog.visibility = View.VISIBLE
            } else {
                binding.progressDialog.visibility = View.GONE
            }
        }
        viewModel.allData.observe(this){
            // TODO Нормальный маппер, убрать данные из апи во вьюхах
            var movies = it.map { x -> Movie(x.filmId, x.name, null, null,
                 null, arrayListOf(),
                 arrayListOf(), null,
                 null, x.posterUrl, x.posterUrlPreview, null) }
                .toList()
            adapter.data.addAll(movies)
            viewModel.loading.postValue(false)
        }

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        viewModel.allData
    }
}