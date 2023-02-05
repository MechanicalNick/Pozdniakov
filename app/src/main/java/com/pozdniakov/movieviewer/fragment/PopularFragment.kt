package com.pozdniakov.movieviewer.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pozdniakov.movieviewer.R
import com.pozdniakov.movieviewer.adapter.MovieAdapter
import com.pozdniakov.movieviewer.api.MovieApi
import com.pozdniakov.movieviewer.databinding.PopularFragmentBinding
import com.pozdniakov.movieviewer.decorator.MarginItemDecoration
import com.pozdniakov.movieviewer.repository.MainRepository
import com.pozdniakov.movieviewer.viewmodel.PopularViewModel
import com.pozdniakov.movieviewer.viewmodel.ViewModelFactory

class PopularFragment : Fragment() {
    private lateinit var binding: PopularFragmentBinding
    private lateinit var adapter: MovieAdapter
    private lateinit var viewModel: PopularViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PopularFragmentBinding.inflate(layoutInflater)
        adapter = MovieAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(
            MarginItemDecoration(resources.getDimensionPixelSize(R.dimen.margin))
        )

        val movieApi = MovieApi.getInstance()
        val mainRepository = MainRepository(movieApi)
        viewModel = ViewModelProvider(this, ViewModelFactory(mainRepository))[PopularViewModel::class.java]
        viewModel.popular.observe(this) {
            adapter.data = it.films
            adapter.notifyDataSetChanged()
        }

        viewModel.errorMessage.observe(this) {
            Toast.makeText(this.context, it, Toast.LENGTH_SHORT).show()
        }

        viewModel.loading.observe(this) {
            if (it) {
                binding.progressDialog.visibility = View.VISIBLE
            } else {
                binding.progressDialog.visibility = View.GONE
            }
        }

        viewModel.getPopular()

        return binding.root
    }

}