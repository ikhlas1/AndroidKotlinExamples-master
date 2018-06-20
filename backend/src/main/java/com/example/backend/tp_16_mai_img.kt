package com.example.backend

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_tp_16_mai_img.*

class tp_16_mai_img : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tp_16_mai_img)
        Glide.with(this).load("192.168.0.153:8082/etoile.JPG").into(imageView)
    }
}
