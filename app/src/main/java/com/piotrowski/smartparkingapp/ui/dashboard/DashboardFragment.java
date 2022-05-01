package com.piotrowski.smartparkingapp.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.piotrowski.smartparkingapp.R;
import com.piotrowski.smartparkingapp.ReadDB;
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

        TextView spaceState = binding.textView0;
        TextView spaceState1 = binding.textView1;
        TextView spaceState2 = binding.textView2;
        TextView spaceState3 = binding.textView3;
        TextView spaceState4 = binding.textView4;
        TextView spaceState5 = binding.textView5;
        TextView spaceState6 = binding.textView6;


        ReadDB rb = new ReadDB();
        rb.start(spaceState, spaceState1, spaceState2,spaceState3,spaceState4,spaceState5,spaceState6);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}