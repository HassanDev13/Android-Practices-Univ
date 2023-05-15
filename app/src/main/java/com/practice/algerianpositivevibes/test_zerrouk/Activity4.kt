package com.practice.algerianpositivevibes.test_zerrouk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.practice.algerianpositivevibes.R

class Activity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_4)

        val email : EditText = findViewById(R.id.editTextTextPersonName3)


        val btnSend : Button = findViewById(R.id.button)


        btnSend.setOnClickListener {

            val recipientEmail = "dietecticien@gmail.com"
            val subject = "Prendre rendez vous"
            val message = email.text

            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/html"
                putExtra(Intent.EXTRA_EMAIL, arrayOf(recipientEmail))
                putExtra(Intent.EXTRA_SUBJECT, subject)
                putExtra(Intent.EXTRA_TEXT, message)
            }

            startActivity(Intent.createChooser(intent, "Choose an email client"))


        }
    }
}