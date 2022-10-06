package com.example.broadcastreceiver_10

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private lateinit var receiver: AirplaneModeChangedReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        receiver = AirplaneModeChangedReceiver()

        val intentFilter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        registerReceiver(AirplaneModeChangedReceiver(), intentFilter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }
}