package com.piotrowski.smartparkingapp.ui.dashboard;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.piotrowski.smartparkingapp.R;
import com.piotrowski.smartparkingapp.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);


        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ImageView map = binding.imageView;
        int nightModeFlags =
                getContext().getResources().getConfiguration().uiMode &
                        Configuration.UI_MODE_NIGHT_MASK;
        switch (nightModeFlags) {
            case Configuration.UI_MODE_NIGHT_YES:
                map.setColorFilter(getResources().getColor(R.color.white));
                break;

            case Configuration.UI_MODE_NIGHT_NO:
                map.setColorFilter(getResources().getColor(R.color.black));
                break;

            case Configuration.UI_MODE_NIGHT_UNDEFINED:
                map.setColorFilter(getResources().getColor(R.color.black));
                break;
        }

//
//        TextView spaceState = binding.textView0;
//        TextView spaceState1 = binding.textView1;
//        TextView spaceState2 = binding.textView2;
//        TextView spaceState3 = binding.textView3;
//        TextView spaceState4 = binding.textView4;
//        TextView spaceState5 = binding.textView5;
//        TextView spaceState6 = binding.textView6;

        ImageView spot1Open = binding.spot1Opened;
        ImageView spot2Open = binding.spot2Opened;
        ImageView spot3Open = binding.spot3Opened;
        ImageView spot4Open = binding.spot4Opened;
        ImageView spot5Open = binding.spot5Opened;
        ImageView spot6Open = binding.spot6Opened;
        ImageView spot7Open = binding.spot7Opened;

        ReadDB rb = new ReadDB();
        rb.start(
                spot1Open, spot2Open, spot3Open, spot4Open, spot5Open, spot6Open, spot7Open
        );

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}