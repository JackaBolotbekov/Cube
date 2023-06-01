package com.example.cube.ui.fragments._notifycation.service

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*

@RequiresApi(Build.VERSION_CODES.M)
fun setAlarmService(context: Context) {

    val currentTime = Calendar.getInstance().time
    val targetTime = Calendar.getInstance().apply {
        set(Calendar.HOUR_OF_DAY, AlarmService.HOUR_OF_DAY)
        set(Calendar.MINUTE, AlarmService.MINUTE)
        set(Calendar.SECOND, 0)
    }.time

    if (currentTime.before(targetTime)) {

        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, AlarmService::class.java)
        val pendingIntent = PendingIntent.getService(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, AlarmService.HOUR_OF_DAY)
        calendar.set(Calendar.MINUTE, AlarmService.MINUTE)
        calendar.set(Calendar.SECOND, 0)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                calendar.timeInMillis,
                pendingIntent
            )
        } else {
            alarmManager.setExact(
                AlarmManager.RTC_WAKEUP,
                calendar.timeInMillis,
                pendingIntent
            )
        }
    }
}