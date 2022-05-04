package com.piotrowski.smartparkingapp.ui.notifications;


import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.piotrowski.smartparkingapp.R;

public class PushNotifications extends Activity {

    Switch notiSwitch;

    public PushNotifications(Switch notiSwitch) {
        this.notiSwitch = notiSwitch;
        createNotification();
    }

    public void createNotification() {
        // Prepare intent which is triggered if the
        // notification is selected
        Intent intent = new Intent(this, PushNotifications.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        // Build notification
        // Actions are just fake
        Notification builder = new Notification.Builder(this)
                .setContentTitle("notification from smart parking app!")
                .setContentText("Parking Spots Available!").setSmallIcon(R.drawable.uhart_h)
                .setContentIntent(pIntent)
                .addAction(R.drawable.uhart_h, "See Map", pIntent).build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // hide the notification after its selected

        notiSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if (isChecked) {
                    notificationManager.notify(0, builder);

                } else {
                    builder.flags |= Notification.FLAG_AUTO_CANCEL;
                }



            }
        });
    }




}









