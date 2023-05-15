package com.practice.algerianpositivevibes


import android.content.*
import android.os.*
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class Tp5Activity : AppCompatActivity() {

    private var mService: Messenger? = null
    private var isConnected = false
    private lateinit var tvVal: TextView
    private lateinit var stringInitialTVal: String

    private inner class ClientHandler : Handler() {
        override fun handleMessage(msg: Message) {
            val valCouranteChrono = msg.arg1
            tvVal.text = "$stringInitialTVal$valCouranteChrono"
        }
    }

    private val mConnection = object : ServiceConnection {
        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            mService = Messenger(service)
            isConnected = true
        }

        override fun onServiceDisconnected(className: ComponentName) {
            mService = null
            isConnected = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tp5)

        val boutAtt = findViewById<Button>(R.id.button)
        val boutDett = findViewById<Button>(R.id.button2)
        val boutVal = findViewById<Button>(R.id.button3)
        val tvEtat = findViewById<TextView>(R.id.textView)
        tvVal = findViewById<TextView>(R.id.textView2)

        val stringInitialTvEta = tvEtat.text.toString()
        stringInitialTVal = tvVal.text.toString()

        boutAtt.setOnClickListener {
            val monIntent = Intent().apply {
                component = ComponentName("com.example.myapp", "com.example.myapp.MyService")
            }
            bindService(monIntent, mConnection, Context.BIND_AUTO_CREATE)
            Toast.makeText(this, "Liaison établie", Toast.LENGTH_LONG).show()
            tvEtat.text = "$stringInitialTvEta ATTACHEE"
            isConnected = true
        }

        boutDett.setOnClickListener {
            if (isConnected) {
                unbindService(mConnection)
                Toast.makeText(this, "Liaison coupée", Toast.LENGTH_LONG).show()
                tvEtat.text = "$stringInitialTvEta DETACHEE"
                isConnected = false
            }
        }

        boutVal.setOnClickListener {
            if (isConnected) {
                try {
                    val message = Message.obtain(null, 1)
                    mService?.send(message)
                } catch (e: RemoteException) {
                    e.printStackTrace()
                }
            }
        }
    }
}
