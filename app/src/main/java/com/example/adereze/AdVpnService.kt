package com.example.adereze

import android.net.VpnService
import android.content.Intent

class AdVpnService : VpnService() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // This tells Android: "Start the VPN engine!"
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}