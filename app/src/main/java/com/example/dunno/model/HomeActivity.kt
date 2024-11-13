package com.example.dunno.model

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dunno.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // logic
    }
}
