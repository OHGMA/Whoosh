package com.example.mojek

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editTextUsername = findViewById<EditText>(R.id.editTextUsername)
        val editTextPass: EditText = findViewById<EditText>(R.id.editTextPassword)
        val editTextConfirmPass: EditText = findViewById<EditText>(R.id.editTextConfirmationPassword)
        val btnRegister = findViewById<Button>(R.id.buttonDaftar)
        val textViewLogin = findViewById<TextView>(R.id.textViewLinkMasuk)

        btnRegister.setOnClickListener {
            val intentRegister = Intent(this, MainActivity::class.java)
            if (editTextPass.text.toString()==editTextConfirmPass.text.toString()) {
                startActivity(intentRegister)
            } else {
                Toast.makeText(this, "Password tidak sesuai", Toast.LENGTH_LONG).show()
            }
        }

        textViewLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}