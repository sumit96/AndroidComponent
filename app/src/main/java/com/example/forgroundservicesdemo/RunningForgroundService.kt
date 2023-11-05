package com.example.forgroundservicesdemo

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat

class RunningForgroundService : Service() {
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        when(intent?.action)
        {
            Action.ONSTART.toString() -> start()
            Action.ONSTOP.toString() -> stopSelf()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun start()
    {
        val notificationManger= NotificationCompat.Builder(this,"running_forground_id")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Application is running")
            .setContentText("Keep Running Text")
            .build()
        startForeground(1,notificationManger)
    }

    enum class Action{
        ONSTART, ONSTOP
    }
}