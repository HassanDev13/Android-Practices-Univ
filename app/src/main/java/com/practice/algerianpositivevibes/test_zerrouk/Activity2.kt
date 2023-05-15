package com.practice.algerianpositivevibes.test_zerrouk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import com.practice.algerianpositivevibes.R

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val resultIMC : TextView = findViewById(R.id.textView3)

        val imcBtn : Button = findViewById(R.id.button)

        resultIMC.text = intent.getStringExtra("result")
        imcBtn.setOnClickListener {

            val myIntent = Intent(this, Activity1::class.java)
            this.startActivity(myIntent)


        }
    }
}