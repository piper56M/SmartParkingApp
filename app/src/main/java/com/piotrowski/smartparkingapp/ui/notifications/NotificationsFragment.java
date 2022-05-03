package com.piotrowski.smartparkingapp.ui.notifications;

import android.content.res.Configuration;
import android.content.res.XmlResourceParser;
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