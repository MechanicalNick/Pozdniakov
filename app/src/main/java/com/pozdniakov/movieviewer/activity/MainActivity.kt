package com.pozdniakov.movieviewer.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pozdniakov.movieviewer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}