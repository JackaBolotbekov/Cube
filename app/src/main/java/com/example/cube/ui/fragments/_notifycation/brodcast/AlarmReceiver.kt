package com.example.cube.ui.fragments._notifycation.brodcast

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.cube.R

class AlarmReceiver : BroadcastReceiver() {

    companion object {
        var HOUR_OF_DAY_1 = 0
        var MINUTE_1 = 0
    }

    override fun onReceive(context: Context, intent: Intent) {
        showNotification(context, "1")
    }

    @SuppressLint("MissingPermission")
    fun showNotification(context: Context, message: String) {
        val channelId = "AlarmChannel"
        val notificationId = 1

        val builder = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.drawable.app_icon)
            .setContentTitle("Напоминание")
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)

        val notificationManager = NotificationManagerCompat.from(context)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "Alarm Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }

        notificationManager.notify(notificationId, builder.build())
    }
}
