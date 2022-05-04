package com.piotrowski.smartparkingapp.ui.notifications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.os.Bundle;
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

import com.piotrowski.smartparkingapp.R;
import com.piotrowski.smartparkingapp.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;


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
       /* if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("Notifications", "My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        noti.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {


             /*  NotificationCompat.Builder builder = new NotificationCompat.Builder(NotificationsViewModel.class, "My Notifications");
                        .setSmallIcon(R.drawable.uhart_h)
                        .setContentTitle("Spaces Open")
                        .setContentText("Spaces Open Now!")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this, NotificationsViewModel.class);
                managerCompat.notify(1, builder.build());
            }
        });*/




            final TextView textView = binding.textNotifications;
            notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
            return root;
        }

        @Override
        public void onDestroyView () {
            super.onDestroyView();
            binding = null;
        }
}