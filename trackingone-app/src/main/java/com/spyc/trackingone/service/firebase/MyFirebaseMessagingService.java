package com.spyc.trackingone.service.firebase;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;

import com.google.firebase.messaging.FirebaseMessagingService;

import com.google.firebase.messaging.RemoteMessage;
import com.spyc.trackingone.R;
import com.spyc.trackingone.ui.home.HomeActivity;

public class MyFirebaseMessagingService extends FirebaseMessagingService{


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        if (remoteMessage.getData().size() > 0) {

            String messageString = remoteMessage.getData().get("message");

            Intent it = new Intent(this, HomeActivity.class);
            PendingIntent contentIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), it, 0);
            Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            int ico_notification = R.drawable.ic_exit;
            int color = ContextCompat.getColor(this, R.color.colorPrimary);


            NotificationManager mNotificationManager = (NotificationManager)
                    this.getSystemService(Context.NOTIFICATION_SERVICE);


            String CHANNEL_ID = "FCM_channel_01";
            CharSequence name = "Channel fCM";
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                int importance = NotificationManager.IMPORTANCE_DEFAULT;
                NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, importance);

                mNotificationManager.createNotificationChannel(mChannel);
            }

            Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_exit);
            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(this,CHANNEL_ID)
                            .setSmallIcon(R.drawable.ic_exit)
                            .setContentTitle(getString(R.string.app_name))
                            .setLargeIcon(largeIcon)
                            .setStyle(new NotificationCompat.BigTextStyle()
                                    .bigText(messageString))
                            .setPriority(NotificationCompat.PRIORITY_HIGH)
                            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                            .setSound(soundUri)
                            .setColor(Color.BLUE)
                            .setAutoCancel(true)
                            .setOnlyAlertOnce(true)
                            .setVibrate(new long[]{1000, 1000})
                            .setContentText(messageString);

            mBuilder.setContentIntent(contentIntent);
            Notification notification = mBuilder.build();

            mNotificationManager.notify(0, notification);


        }
    }
}
