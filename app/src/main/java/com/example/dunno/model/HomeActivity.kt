package com.example.dunno.model

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dunno.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the binding (replace with your actual layout if necessary)
        val binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Optionally, you can add more logic to initialize the HomeActivity if needed
    }
}