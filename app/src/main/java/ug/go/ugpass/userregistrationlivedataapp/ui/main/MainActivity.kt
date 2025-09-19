package ug.go.ugpass.userregistrationlivedataapp.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ug.go.ugpass.userregistrationlivedataapp.R
import ug.go.ugpass.userregistrationlivedataapp.databinding.ActivityMainBinding
import ug.go.ugpass.userregistrationlivedataapp.ui.login.LoginActivity
import ug.go.ugpass.userregistrationlivedataapp.ui.register.RegisterActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnRegisterOption.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
        binding.btnLoginOption.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}