package com.piotrowski.smartparkingapp.ui.notifications;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.piotrowski.smartparkingapp.BuildConfig;
import com.piotrowski.smartparkingapp.R;
import com.piotrowski.smartparkingapp.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;
    private NotificationManager notificationManager;
    private NotificationChannel channel;
    NotificationCompat.Builder builder;
    String openSpaces;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);
        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Switch s = binding.DarkModeSwitch;

        int nightModeFlags =
                getContext().getResources().getConfiguration().uiMode &
                        Configuration.UI_MODE_NIGHT_MASK;

        switch (nightModeFlags) {
            case Configuration.UI_MODE_NIGHT_YES:
                s.setChecked(true);
                break;

            case Configuration.UI_MODE_NIGHT_NO:
                s.setChecked(false);
                break;

            case Configuration.UI_MODE_NIGHT_UNDEFINED:
                s.setChecked(true);
                break;
        }

            s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    } else {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    }
                }
            });

        Switch noti = binding.notiSwitch;

        notificationManager = (NotificationManager) getContext().getSystemService(Context.NOTIFICATION_SERVICE);
            createNotificationChannel();
            createNotification();
            ReadDBForNoti rb = new ReadDBForNoti();
            rb.start(noti, builder, notificationManager, this.getContext());


            final TextView textView = binding.textNotifications;
            notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
            return root;
    }

    public void createNotification() {

        Intent intent = new Intent(this.getActivity(), this.getClass());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pIntent = PendingIntent.getActivity(this.getActivity(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        builder = new NotificationCompat.Builder(this.getContext(), "notifID");
        builder.setSmallIcon((R.drawable.uhart_h));
        builder.setContentIntent(pIntent);
        builder.setContentTitle("Notification from Smart Parking App!");
        builder.setSmallIcon(R.drawable.uhart_h);
        builder.setContentIntent(pIntent);
        builder.setStyle(new NotificationCompat.BigTextStyle());
//        builder.addAction(R.drawable.uhart_h, "See Map", pIntent);

    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("notifID", "My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("Open spots");
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            getContext().getSystemService(this.getClass());
            notificationManager.createNotificationChannel(channel);
        }
    }

    @Override
    public void onDestroyView () {
        super.onDestroyView();
        binding = null;
    }
}