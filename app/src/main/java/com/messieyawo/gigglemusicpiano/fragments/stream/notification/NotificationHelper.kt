package com.messieyawo.gigglemusicpiano.fragments.stream.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.messieyawo.gigglemusicpiano.R
import com.messieyawo.gigglemusicpiano.activities.HomeActivity


class NotificationHelper(var c:Context) {
    private val CHANNEL_ID = "back Id"
    private val NOTIFICATION_ID = 111
    /**set createNotification*/
    fun createNotification(title: String, descript: String) {
        createNotificationChannel()
        val openInt = Intent(c,HomeActivity::class.java)
            .apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_MULTIPLE_TASK

            }
        val pendingInt = PendingIntent.getActivities(c,0, arrayOf(openInt),PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT)
        val icon = BitmapFactory.decodeResource(c.resources, R.mipmap.ic_launcher_foreground)
        /**set Notification dialog*/
        val notifiyM = NotificationCompat.Builder(c,CHANNEL_ID)
            .setSmallIcon(R.mipmap.ic_launcher_round)
            .setLargeIcon(icon)
            .setContentTitle(title)
            .setContentText(descript)
        /**set Large Icon in Notification*/
            .setStyle(
                NotificationCompat.BigPictureStyle()
                        /** ok we set icon*/
                    .bigLargeIcon(icon)
                    .bigPicture(icon)
            /**ok run it*/
            )
            .setContentIntent(pendingInt)
            .setPriority(
                NotificationCompat.PRIORITY_DEFAULT
            )
            .build()
        NotificationManagerCompat.from(c).notify(NOTIFICATION_ID,notifiyM)
    }
    /** set CreateNotificationChannel*/
    private fun createNotificationChannel(){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val name = CHANNEL_ID
            val importance = NotificationManager.IMPORTANCE_HIGH
            val derscrip = "Channel dersription"
            val impo = NotificationManager.IMPORTANCE_DEFAULT

            //val channel = NotificationChannel(CHANNEL_ID, name, importance)
            val channel = NotificationChannel(CHANNEL_ID,name,importance).apply {
                description = derscrip
            }

            channel.enableLights(true)
            channel.lightColor = Color.RED
            channel.enableVibration(true)
            channel.vibrationPattern = longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)


            val notifiyM = c.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notifiyM.createNotificationChannel(channel)
        }
    }
}