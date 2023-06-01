package com.example.cube.ui.fragments._notifycation.brodcast

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import java.util.*

@SuppressLint("UnspecifiedImmutableFlag")
fun setAlarmBroadcast(context: Context) {

    val currentTime = Calendar.getInstance().time
    val targetTime = Calendar.getInstance().apply {
        set(Calendar.HOUR_OF_DAY, AlarmReceiver.HOUR_OF_DAY_1)
        set(Calendar.MINUTE, AlarmReceiver.MINUTE_1)
        set(Calendar.SECOND, 0)
    }.time

    if (currentTime.before(targetTime)) {

        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, AlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val calendar = Calendar.getInstance()

        calendar.set(Calendar.HOUR_OF_DAY, AlarmReceiver.HOUR_OF_DAY_1)
        calendar.set(Calendar.MINUTE, AlarmReceiver.MINUTE_1)
        calendar.set(Calendar.SECOND, 0)
        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            AlarmManager.INTERVAL_DAY, // Повторяется каждый день
            pendingIntent
        )
    }
}