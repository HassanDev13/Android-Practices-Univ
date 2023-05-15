package com.practice.algerianpositivevibes.test_zerrouk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.practice.algerianpositivevibes.R

class Activity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)

        val poit : EditText = findViewById(R.id.editTextTextPersonName)
        val taille : EditText = findViewById(R.id.editTextTextPersonName2)

        val btn : Button = findViewById(R.id.button)

        btn.setOnClickListener {


            val IMC : Int =  poit.text.toString().toInt() / (taille.text.toString().toInt() * taille.text.toString().toInt())

            Toast.makeText(
                applicationContext,
                "result IMC : $IMC ${poit.text.toString().toInt()}",
                Toast.LENGTH_LONG
            ).show();
            if(IMC >= 18.5 && IMC <= 24.9){


                val myIntent = Intent(this, Activity2::class.java)
                myIntent.putExtra("result", IMC.toString())

                this.startActivity(myIntent)
            }else {
                val myIntent = Intent(this, Activity3::class.java)
                myIntent.putExtra("result", IMC.toString())
                this.startActivity(myIntent)
            }

        }
    }
}