package com.practice.algerianpositivevibes

import android.content.BroadcastReceiver
import android.content.Context
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat
import com.practice.algerianpositivevibes.broadcasts.MyBroadcastReceiver

class Tp3Activity : AppCompatActivity() {
    private lateinit var br: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tp3)

        br = MyBroadcastReceiver()
        val filter = IntentFilter("APP_SPECIFIC_BROADCAST")

        val btn  : Button = findViewById(R.id.btn)
        btn.setOnClickListener {
            this.registerReceiver(br , filter)
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        this.unregisterReceiver(br)
    }
}