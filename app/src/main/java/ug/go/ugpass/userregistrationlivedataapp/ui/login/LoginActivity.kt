package ug.go.ugpass.userregistrationlivedataapp.ui.login

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ug.go.ugpass.userregistrationlivedataapp.R
import ug.go.ugpass.userregistrationlivedataapp.databinding.ActivityLoginBinding
import ug.go.ugpass.userregistrationlivedataapp.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val vm: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Observe login result
        vm.loginResult.observe(this) { success ->
            if (success) {
                AlertDialog.Builder(this)
                    .setTitle("Login Success")
                    .setMessage("Welcome!")
                    .setPositiveButton("OK", null)
                    .show()
            } else {
                AlertDialog.Builder(this)
                    .setTitle("Login Failed")
                    .setMessage("Invalid credentials")
                    .setPositiveButton("OK", null)
                    .show()
            }
        }

        binding.btnLogin.setOnClickListener {
            val input = binding.etEmailOrMobile.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (input.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            vm.login(input, password)
        }
    }
}