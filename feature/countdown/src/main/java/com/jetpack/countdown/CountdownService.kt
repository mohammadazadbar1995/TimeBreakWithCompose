package com.jetpack.countdown

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.jetpack.countdown.model.Action

class CountdownService : Service() {
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val data = intent?.getStringExtra(DATA)
        when (intent?.action) {
            Action.SHOW_NOTIFICATION.toString() -> {
                showInNotification(message = data)
            }

            Action.STOP.toString() -> {
                stopSelf()
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun showInNotification(message: String?) {
        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(com.jetpack.designsystem.R.drawable.ic_launcher_foreground)
            .setContentTitle(NOTIFICATION_CONTENT_TITLE)
            .setContentText(message)
            .build()
        startForeground(NOTIFICATION_ID, notification)
    }

}