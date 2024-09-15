package pppb1.pertemuan5.activity_intent

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pppb1.pertemuan5.activity_intent.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve data from the main activity if available
        val usernameFromMain = intent.getStringExtra("USERNAME")
        val passwordFromMain = intent.getStringExtra("PASSWORD")
        val emailFromMain = intent.getStringExtra("EMAIL")
        val phoneFromMain = intent.getStringExtra("PHONE")

        // Set login button logic
        binding.loginButton.setOnClickListener {
            val enteredUsername = binding.loginUsername.text.toString()
            val enteredPassword = binding.loginPassword.text.toString()

            // Check if entered credentials match the ones passed from MainActivity
            if (enteredUsername == usernameFromMain && enteredPassword == passwordFromMain) {
                // Credentials are correct, navigate to home (third) activity
                val intent = Intent(this, ThirdActivity::class.java).apply {
                    putExtra("USERNAME", usernameFromMain)
                    putExtra("EMAIL", emailFromMain)
                    putExtra("PHONE", phoneFromMain)
                }
                startActivity(intent)
            } else {
                // Show error message (optional, could add a Toast here)
                binding.loginUsername.error = "Invalid credentials"
            }
        }

        // Navigate back to the main activity on register text click
        binding.txtRegister.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}