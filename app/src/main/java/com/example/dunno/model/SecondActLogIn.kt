package com.example.dunno.model

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dunno.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class SecondActLogIn : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize FirebaseAuth
        auth = FirebaseAuth.getInstance()

        // Inflate the binding
        binding = ActivityLoginBinding.inflate(layoutInflater)
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
            val username = binding.UserName.text.toString()
            val password = binding.Password.text.toString()

            // Ensure that both fields are filled
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill in both fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Call Firebase Log In method
            logInUser(username, password)
        }
    }

    private fun logInUser(username: String, password: String) {
        auth.signInWithEmailAndPassword(username, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Log in successful
                    Toast.makeText(this, "Log In Successful", Toast.LENGTH_SHORT).show()

                    // Redirect to HomeActivity
                    val intent = Intent(this, HomeActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    finish()  // Close the login activity

                } else {
                    // If log-in fails
                    Toast.makeText(this, "Log In Failed: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                }
            }
    }
}
