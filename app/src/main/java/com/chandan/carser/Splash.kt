package com.chandan.carser

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Build.VERSION_CODES
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.getSystemService


class Splash : AppCompatActivity() {
    private var Channel_ID = "Your Channel ID"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()

        createNotificationChannel()
        val notificationlayout = RemoteViews(packageName,R.layout.custom_notify)
        var builder = NotificationCompat.Builder(this,Channel_ID)
            .setContentTitle("Car Care Service")
            .setSmallIcon(R.drawable.notification)
            .setStyle(NotificationCompat.DecoratedCustomViewStyle())
            .setCustomBigContentView(notificationlayout)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        with(NotificationManagerCompat.from(this)){
           val intent = notify(0,builder.build())
        }

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            val intent = Intent(this,Phone::class.java)
            startActivity(intent)
            finish()
        },2000)



    }
    private fun  createNotificationChannel (){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR_0_1)
        {
            val name = "App Notification"
            val descriptionText = "This is Your Notification"
            val importane = NotificationManager.IMPORTANCE_DEFAULT
            val chanel = NotificationChannel(Channel_ID,name,importane).apply {
                    description = descriptionText
            }
            val notificationManager : NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(chanel)
        }
    }
}