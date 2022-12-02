package com.example.sebas_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sebas_app.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    //vincular la vista
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}