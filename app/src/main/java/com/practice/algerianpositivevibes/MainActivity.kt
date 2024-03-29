package com.practice.algerianpositivevibes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnTp1 : Button = findViewById(R.id.tp1)
        val btnTp2 : Button = findViewById(R.id.tp2)
        val btnTp3 : Button = findViewById(R.id.tp3)
        val btnTp4 : Button = findViewById(R.id.tp4)
        val btnTp6 : Button = findViewById(R.id.tp6)
        val btnTp7 : Button = findViewById(R.id.tp7)

        btnTp1.setOnClickListener {
            val myIntent = Intent(this, Tp1Activity::class.java)
            this.startActivity(myIntent)
        }
        btnTp2.setOnClickListener {
            val myIntent = Intent(this, LoginActivity::class.java)
            this.startActivity(myIntent)
        }

        btnTp3.setOnClickListener {
            val myIntent = Intent(this, Tp3Activity::class.java)
            this.startActivity(myIntent)
        }
        btnTp4.setOnClickListener {
            val myIntent = Intent(this, Tp5Activity::class.java)
            this.startActivity(myIntent)
        }
        btnTp6.setOnClickListener {
            val myIntent = Intent(this, Tp6Activity::class.java)
            this.startActivity(myIntent)
        }
        btnTp7.setOnClickListener {
            val myIntent = Intent(this, Tp6Part2Activity::class.java)
            this.startActivity(myIntent)
        }
    }
}