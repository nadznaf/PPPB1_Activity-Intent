package pppb1.pertemuan5.activity_intent

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pppb1.pertemuan5.activity_intent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Navigate to second activity on register button click
        binding.registerButton.setOnClickListener {
            val username = binding.registerUsername.text.toString()
            val password = binding.registerPassword.text.toString()
            val email = binding.registerEmail.text.toString()
            val phone = binding.registerPhone.text.toString()

            // Passing data to second activity
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("USERNAME", username)
                putExtra("PASSWORD", password)
                putExtra("EMAIL", email)
                putExtra("PHONE", phone)
            }
            startActivity(intent)
        }

        // Navigate to second activity on login text click
        binding.txtLogin.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }
}