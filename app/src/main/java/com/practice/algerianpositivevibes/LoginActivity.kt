package com.practice.algerianpositivevibes

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var emailText: String = ""
        var passwordText: String = ""
        val login: Button = findViewById(R.id.login)
        val email: EditText = findViewById(R.id.email)
        val password: EditText = findViewById(R.id.password)
        val loadImage : Button = findViewById(R.id.loadImage)
        val image : ImageView = findViewById(R.id.imageView)
        val share : Button = findViewById(R.id.share)
        login.setOnClickListener {
            emailText = email.text.toString()
            passwordText = password.text.toString()

            val emailExpected = "test@gmail.com"
            val passwordExpected = "123456"

            if (emailText.isEmpty() || passwordText.isEmpty()) {
                Toast.makeText(
                    applicationContext,
                    "Email or Password empty",
                    Toast.LENGTH_LONG
                ).show();
            } else {
               if(emailExpected == emailText && passwordText == passwordExpected){
                   val myIntent = Intent(this, CodeActivity::class.java)
                   myIntent.putExtra("email", emailText)
                   myIntent.putExtra("password", passwordText)
                   this.startActivity(myIntent)
               }else{
                   Toast.makeText(
                       applicationContext,
                       "Email oe Password not good",
                       Toast.LENGTH_LONG
                   ).show();
               }
            }
        }

        loadImage.setOnClickListener {

            image.setImageResource(R.drawable.universite)
        }

        share.setOnClickListener {

            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.type = "image/*"
            val uri: Uri =
                Uri.parse("android.resource://com.practice.algerianpositivevibes/" + R.drawable.universite)
            shareIntent.putExtra(Intent.EXTRA_STREAM, uri)
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, This is test Sharing")
            startActivity(Intent.createChooser(shareIntent, "Send your image"))
        }
    }
}