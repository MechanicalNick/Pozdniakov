package com.pozdniakov.movieviewer.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pozdniakov.movieviewer.R
import com.pozdniakov.movieviewer.viewmodel.FavouriteViewModel

class FavouriteFragment : Fragment() {
    private lateinit var viewModel: FavouriteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.favourite_fragment, container, false)
    }
}