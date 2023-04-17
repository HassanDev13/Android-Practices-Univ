package com.practice.algerianpositivevibes

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.practice.algerianpositivevibes.broadcasts.MyBroadcastReceiver


class Tp3Activity : AppCompatActivity() {
    private lateinit var br: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tp3)

        br = MyBroadcastReceiver()


        this.registerReceiver(br , IntentFilter("SOS"))
        this.registerReceiver(br , IntentFilter("LIST_NUM"))
        this.registerReceiver(br , IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED))


        val btnSos  : Button = findViewById(R.id.sos)

        val listNum  : Button = findViewById(R.id.listNum)


        btnSos.setOnClickListener {
            val intent = Intent("SOS")
            sendBroadcast(intent)
        }
        listNum.setOnClickListener {
            val intent = Intent("LIST_NUM")
            sendBroadcast(intent)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        this.unregisterReceiver(br)
    }
}