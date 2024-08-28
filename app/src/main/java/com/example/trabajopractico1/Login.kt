package com.example.trabajopractico1

import android.os.Bundle
import android.widget.TextView
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        val bienvenidoTxt = findViewById<TextView>(R.id.txtWelcome)
        bienvenidoTxt.text = "Bienvenido ${intent.getStringExtra("nombreUsuario")}"
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // referencias a las vistas
        val imageView1: ImageView = findViewById(R.id.imageView)
        val imageView2: ImageView = findViewById(R.id.imageView2)
        val buttonAndroid: Button = findViewById(R.id.android)
        val buttonApple: Button = findViewById(R.id.apple)
        val editText: EditText = findViewById(R.id.txt)
        val radioButton4: RadioButton = findViewById(R.id.radioButton4)

        // Listener para el boton "Android"
        buttonAndroid.setOnClickListener {
            imageView1.visibility = View.VISIBLE
            imageView2.visibility = View.INVISIBLE
        }

        // Listener para el boton "IOs"
        buttonApple.setOnClickListener {
            imageView1.visibility = View.INVISIBLE
            imageView2.visibility = View.VISIBLE
        }

        // Listener para el cambio de estado del RadioButton
        radioButton4.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                editText.visibility = View.VISIBLE
            } else {
                editText.visibility = View.GONE
            }
        }
    }
}