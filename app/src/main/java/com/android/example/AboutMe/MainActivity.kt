package com.android.example.AboutMe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showImage(view: View) = if (imageView2.visibility == View.GONE) {
        imageView2.visibility = View.VISIBLE
        showOrHide.setText(" Hide my head 😉 ")
    } else {
        imageView2.visibility = View.GONE
        showOrHide.setText(" Show my head 🙃 ")
    }
}
