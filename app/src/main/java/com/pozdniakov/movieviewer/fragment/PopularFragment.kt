package com.pozdniakov.movieviewer.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pozdniakov.movieviewer.viewmodel.PopularViewModel
import com.pozdniakov.movieviewer.R
import com.pozdniakov.movieviewer.adapter.MovieAdapter
import com.pozdniakov.movieviewer.databinding.PopularFragmentBinding
import com.pozdniakov.movieviewer.decorator.MarginItemDecoration

class PopularFragment : Fragment() {
    private lateinit var binding: PopularFragmentBinding
    private lateinit var adapter: MovieAdapter
    companion object {
        fun newInstance() = PopularFragment()
    }

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
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[PopularViewModel::class.java]
        // TODO: Use the ViewModel
    }

}