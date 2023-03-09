package com.practice.algerianpositivevibes.broadcasts

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyBroadcastReceiver : BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent!!.action.equals("APP_SPECIFIC_BROADCAST")){
            Toast.makeText(
                context,
                "Hello man",
                Toast.LENGTH_LONG
            ).show();
        }

    }
}