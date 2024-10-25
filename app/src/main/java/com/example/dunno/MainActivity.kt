package com.example.dunno

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Set the content view

        val buttonLogin = findViewById<Button>(R.id.button) // Log In button
        val buttonSignUp = findViewById<Button>(R.id.button2) // Sign Up button

        // Set OnClickListener for the Log In button
        buttonLogin.setOnClickListener {
            val intent = Intent(this, SecondActLogIn::class.java)
            startActivity(intent)
        }

        // Set OnClickListener for the Sign Up button
        buttonSignUp.setOnClickListener {
            val intent = Intent(this, SecondActSignUp::class.java)
            startActivity(intent)
        }
    }
}
