package com.example.dunno.model

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dunno.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth

class SecondActSignUp : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize FirebaseAuth
        auth = FirebaseAuth.getInstance()

        // Inflate the binding
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up button click listeners
        setupButtonListeners()
    }

    private fun setupButtonListeners() {
        // Button to go back to MainActivity
        binding.button3.setOnClickListener {
            finish() // This will close SecondActivity and go back to MainActivity
        }

        // Button for Sign Up action
        binding.button4.setOnClickListener {
            val username = binding.UserName.text.toString()
            val password = binding.Password.text.toString()

            // Ensure that both fields are filled
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill in both fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Call Firebase Sign Up method
            signUpUser(username, password)
        }
    }

    private fun signUpUser(username: String, password: String) {
        auth.createUserWithEmailAndPassword(username, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign up successful
                    Toast.makeText(this, "Sign Up Successful", Toast.LENGTH_SHORT).show()

                    // Redirect to MainActivity
                    val intent = Intent(this, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    finish()  // Close the current activity

                } else {
                    // If sign-up fails
                    Toast.makeText(this, "Sign Up Failed: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                }
            }
    }
}
