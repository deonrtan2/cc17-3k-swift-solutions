package com.example.dunno.model

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dunno.databinding.ActivityMain2Binding

class SecondActLogIn : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the binding
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up button click listeners
        setupButtonListeners()
    }

    private fun setupButtonListeners() {
        // Button to go back to MainActivity
        binding.button3.setOnClickListener {
            finish() // This will close SecondActivity and go back to MainActivity
        }

        // Button for Log In action
        binding.button4.setOnClickListener {
            // You can handle the log in action here or navigate to another activity
            // For example, you could start another activity like this:
            val intent = Intent(this, SecondActSignUp::class.java)
            startActivity(intent)
        }
    }
}
