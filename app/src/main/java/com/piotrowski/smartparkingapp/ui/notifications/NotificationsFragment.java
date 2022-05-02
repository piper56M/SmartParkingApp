package com.piotrowski.smartparkingapp.ui.notifications;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
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

//        Switch s = binding.DarkModeSwitch;
//        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    int nightModeFlags =
//                            getContext().getResources().getConfiguration().uiMode &
//                                    Configuration.UI_MODE_NIGHT_MASK;
//                    RelativeLayout dash = (RelativeLayout) (R.layout.fragment_dashboard);
//                    RelativeLayout home = (RelativeLayout) getResources().getLayout(R.layout.fragment_home);
//                    RelativeLayout noti = (RelativeLayout) getResources().getLayout(R.layout.fragment_notifications);
//                    switch (nightModeFlags) {
//                        case Configuration.UI_MODE_NIGHT_YES:
//                            dash.setBackgroundColor(getResources().getColor(R.color.white));
//                            home.setBackgroundColor(getResources().getColor(R.color.white));
//                            noti.setBackgroundColor(getResources().getColor(R.color.white));
//                            break;
//
//                        case Configuration.UI_MODE_NIGHT_NO:
//                            dash.setBackgroundColor(getResources().getColor(R.color.black));
//                            home.setBackgroundColor(getResources().getColor(R.color.black));
//                            noti.setBackgroundColor(getResources().getColor(R.color.black));
//                            break;
//
//                        case Configuration.UI_MODE_NIGHT_UNDEFINED:
//                            break;
//                    }
//                } else {
//
//                }
//            }
//        });

        final TextView textView = binding.textNotifications;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}