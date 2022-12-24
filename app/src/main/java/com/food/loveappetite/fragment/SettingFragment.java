package com.food.loveappetite.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.food.loveappetite.R;
import com.food.loveappetite.activity.LauncherActivity;
import com.food.loveappetite.activity.MainActivity;
import com.food.loveappetite.activity.UpdateUserActivity;
import com.food.loveappetite.controller.UsersController;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingFragment extends Fragment {

    private Intent intentLogout;
    private Intent intentProfile;

    private Button btnLogout;
    private Button btnProfile;

    public SettingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnLogout = view.findViewById(R.id.btn_logout);
        btnProfile = view.findViewById(R.id.btn_profile);

        intentLogout = new Intent(getActivity(), LauncherActivity.class);
        intentProfile = new Intent(getActivity(), UpdateUserActivity.class);

        btnLogout.setOnClickListener(rootView -> {
            MainActivity.getUsersController().logout();
            startActivity(intentLogout);
            getActivity().finish();
        });
        btnProfile.setOnClickListener(rootView -> {
            startActivity(intentProfile);
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting, container, false);
    }
}