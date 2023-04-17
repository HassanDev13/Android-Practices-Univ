package com.practice.algerianpositivevibes.broadcasts

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.widget.Toast

class MyBroadcastReceiver : BroadcastReceiver(){
    var cont = 1
    override fun onReceive(context: Context?, intent: Intent?) {


         if(intent!!.action.equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)){
             val isAirplaneModeOn = intent.getBooleanExtra("state", false)
             if (isAirplaneModeOn) {
                 Toast.makeText(
                     context,
                     "Mode Avion ON",
                     Toast.LENGTH_LONG
                 ).show()
             } else {
                 Toast.makeText(
                     context,
                     "Mode Avion OFF",
                     Toast.LENGTH_LONG
                 ).show()
             }


        }

         else if(intent!!.action.equals("SOS")){
             val airplaneModeOn = Settings.Global.getInt(
                 context?.contentResolver,
                 Settings.Global.AIRPLANE_MODE_ON,
                 0
             ) != 0

             if (airplaneModeOn) {
                 Toast.makeText(
                     context,
                     "désactiver le mode avion pour pouvoir passer\n" +
                             "un appel d’urgence",
                     Toast.LENGTH_LONG
                 ).show()

             } else {
                 Toast.makeText(
                     context,
                     "J’ai reçu une demande d’appel SOS",
                     Toast.LENGTH_LONG
                 ).show()
             }

         }

        else if(intent!!.action.equals("LIST_NUM")){
            if(cont == 1){
                cont ++
                Toast.makeText(
                    context,
                    "exp : Pompier 112,\n" +
                            "Police 15, etc",
                    Toast.LENGTH_LONG
                ).show()
            }else{
                cont = 1
                Toast.makeText(
                    context,
                    "Mr x 020504078, Mme y 04141748",
                    Toast.LENGTH_LONG
                ).show()
            }

        }
    }
}