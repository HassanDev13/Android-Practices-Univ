package com.practice.algerianpositivevibes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class CodeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code)
        var codeText = ""
        val code : EditText = findViewById(R.id.url)
        val send : Button = findViewById(R.id.send)
        val codeExpected = "1234"

        send.setOnClickListener {
            codeText = code.text.toString()
            if(codeText.isEmpty()){
                Toast.makeText(
                    applicationContext,
                    "Code is empty, please enter your code",
                    Toast.LENGTH_LONG
                ).show();
            }else{
                if(codeText == codeExpected){
                    val myIntent = Intent(this, StartWebActivity::class.java)
                    this.startActivity(myIntent)
                }else{
                    Toast.makeText(
                        applicationContext,
                        "Code not good, try again",
                        Toast.LENGTH_LONG
                    ).show();
                }
            }
        }
    }
}