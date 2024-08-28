package com.example.trabajopractico1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSingUp=findViewById<Button>(R.id.btnRegister)
        btnSingUp.setOnClickListener {
            val intent= Intent(this,SingUp::class.java)
            startActivity(intent)
        }

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val editTextUser = findViewById<EditText>(R.id.etUser)
        val editTextPassword = findViewById<EditText>(R.id.etPassword)
        val errorTextView = findViewById<TextView>(R.id.errorTextView) // Agrega un TextView en tu XML para mostrar errores

        btnLogin.setOnClickListener {
            val username = editTextUser.text.toString()
            val password = editTextPassword.text.toString()

            // Datos hardcodeados para la verificación
            val validUsername = "Juan Torres"
            val validPassword = "1234utn"

            if (username == validUsername && password == validPassword) {
                // Si coinciden, procede con la acción (por ejemplo, navegar a otra actividad)
                val intent = Intent(this, Login::class.java)
                intent.putExtra("nombreUsuario", username)
                startActivity(intent)
            } else {
                // Si no coinciden, muestra un mensaje de error
                errorTextView.text = "Usuario y/o contraseña incorrectos"
                errorTextView.visibility = TextView.VISIBLE
            }
        }
    }
}