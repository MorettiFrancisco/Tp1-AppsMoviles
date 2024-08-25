package com.example.trabajopractico1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.isVisible

class SingUp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.sing_up)
        val acept=findViewById<Button>(R.id.acept)
        val cancel=findViewById<Button>(R.id.btnCancel)
        val outPass=findViewById<TextView>(R.id.outPass)
        val outMail=findViewById<TextView>(R.id.outMail)
        val outUser=findViewById<TextView>(R.id.outUsr)

        cancel.setOnClickListener(){
            startActivity(Intent(this,MainActivity::class.java))
        }
        acept.setOnClickListener(){
            outUser.isVisible=!validateUsername()
            outMail.isVisible=!validateMail()
            outPass.isVisible=!verificationPass()
            if (verificationPass()&&validateUsername()&&validateMail()){
                startActivity(Intent(this,MainActivity::class.java))
            }

        }
    }
    private fun verificationPass():Boolean{
        val pass=findViewById<EditText>(R.id.txt)
        val veriPass=findViewById<EditText>(R.id.veri)
        if (pass.text.toString()==veriPass.text.toString()&&validatePass(pass.text.toString())){
            return true
        }
        return false
    }
    private fun validatePass(pass:String):Boolean{
        if (pass.length>=6){ //lo hago funcion porque posteriormente puedo validadr con expresiones regulares (el enunciado pide min 6 caracteres, pero puedo avanzar)
            return true
        }
        return false
    }
    private fun validateUsername():Boolean{
        val user=findViewById<EditText>(R.id.user)
        if (user.text.toString().isNotBlank()){
            Log.i("user","ok")
            return true
        }
        Log.i("user","no")
        return false
    }
    private fun validateMail():Boolean{
        val mail=findViewById<EditText>(R.id.mail)
        if (mail.text.toString().isNotBlank()){
            Log.i("mail","ok")
            return true
        }
        Log.i("mail","no")
        return false
    }
}

