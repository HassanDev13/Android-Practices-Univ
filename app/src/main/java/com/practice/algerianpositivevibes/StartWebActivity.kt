package com.practice.algerianpositivevibes

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class StartWebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_web)

        var urlText = ""
        val url : EditText = findViewById(R.id.url)
        val openUrl : Button = findViewById(R.id.open_url)
        val out  : Button = findViewById(R.id.out)
        openUrl.setOnClickListener {
            urlText = url.text.toString()
            if(urlText.isEmpty()){
                Toast.makeText(
                    applicationContext,
                    "Code is empty, please enter your code",
                    Toast.LENGTH_LONG
                ).show();
            }else{
               try {

                   val intent = Intent(Intent.ACTION_VIEW, Uri.parse(urlText))
                   this.startActivity(intent)
               }catch (err: Error){
                   Toast.makeText(
                       applicationContext,
                       "Error : Url Not Valid",
                       Toast.LENGTH_LONG
                   ).show()
               }
            }
        }
        out.setOnClickListener {
            val myIntent = Intent(this, LoginActivity::class.java)
            this.startActivity(myIntent)
        }

    }
}