package com.example

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.home.HomeActivity
import com.example.mojek.MainActivity
import com.example.mojek.R
import com.example.mojek.RegisterActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editTextUsername: EditText = findViewById<EditText>(R.id.editTextUsername)
        val editTextPass: EditText = findViewById<EditText>(R.id.editTextPassword)
        val btnLogin = findViewById<Button>(R.id.buttonMasuk)
        val textViewRegister = findViewById<TextView>(R.id.textViewLinkDaftar)

        btnLogin.setOnClickListener {
            val username:String = editTextUsername.text.toString()
            val intentLogin = Intent(this, HomeActivity::class.java)
            intentLogin.putExtra("username", username)
            startActivity(intentLogin)
        }

        textViewRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}