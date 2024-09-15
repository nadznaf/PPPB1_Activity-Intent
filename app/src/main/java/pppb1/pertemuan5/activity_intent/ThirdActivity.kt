package pppb1.pertemuan5.activity_intent

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pppb1.pertemuan5.activity_intent.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve and display user info from SecondActivity
        val username = intent.getStringExtra("USERNAME")

        // Set user data in the text views
        binding.txtUsername.text = username
    }
}