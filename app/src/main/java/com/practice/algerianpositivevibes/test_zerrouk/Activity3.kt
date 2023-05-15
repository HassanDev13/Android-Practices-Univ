package com.practice.algerianpositivevibes.test_zerrouk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.practice.algerianpositivevibes.R

class Activity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)


        val resultIMC : TextView = findViewById(R.id.textView3)

        resultIMC.text = intent.getStringExtra("result")

        val btnOui : Button = findViewById(R.id.buttonOui)
        val btnNon : Button = findViewById(R.id.buttonNon)

        btnOui.setOnClickListener {

            val myIntent = Intent(this, Activity4::class.java)

            this.startActivity(myIntent)
        }
        btnNon.setOnClickListener {

            val myIntent = Intent(this, Activity1::class.java)

            this.startActivity(myIntent)
        }
    }
}