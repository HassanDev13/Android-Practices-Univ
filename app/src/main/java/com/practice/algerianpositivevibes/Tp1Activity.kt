package com.practice.algerianpositivevibes

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.lang.Error


class Tp1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tp1)
        val enterNumber: EditText = findViewById(R.id.enter_number)
        val run: Button = findViewById(R.id.run)
        val result: TextView = findViewById(R.id.result)

        run.setOnClickListener {
            try {
                val res = fabona(enterNumber.text.toString().toInt())
                result.text = res.toString()
            } catch (err: Error) {
                Toast.makeText(
                    applicationContext,
                    "Error", Toast.LENGTH_LONG
                ).show()
            }

        }

    }

    private fun fabona(number: Int): Int {
        if (number == 1 || number == 2) {
            return 1
        }
        var fibo1: Int = 1
        var fibo2: Int = 1
        var fibonacci: Int = 1
        var i = 3
        while (i <= number) {
            fibonacci = fibo1 + fibo2
            fibo1 = fibo2
            fibo2 = fibonacci

            i++
        }

        return fibonacci
    }


}