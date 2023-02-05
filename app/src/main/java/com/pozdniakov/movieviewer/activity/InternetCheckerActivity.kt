package com.pozdniakov.movieviewer.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.pozdniakov.movieviewer.R
import com.pozdniakov.movieviewer.utils.NetworkChecker

class InternetCheckerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_internet_checker)
        var loading = findViewById<TextView>(R.id.loading)
        var error = findViewById<TextView>(R.id.error)
        var tryAgainButton = findViewById<AppCompatButton>(R.id.tryAgainButton)
        var image = findViewById<ImageView>(R.id.imageView2)

        if (NetworkChecker.isNetworkConnected(applicationContext)) {
            error.visibility = View.GONE
            tryAgainButton.visibility = View.GONE
            image.visibility = View.GONE
            loading.visibility = View.VISIBLE
            success()
        } else {
            error.visibility = View.VISIBLE
            tryAgainButton.visibility = View.VISIBLE
            image.visibility = View.VISIBLE
            loading.visibility = View.GONE
        }
    }

    fun recreate(view: View?) {
        recreate()
    }

    private fun success() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}