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
import android.widget.TextView;

import com.food.loveappetite.R;
import com.food.loveappetite.activity.LauncherActivity;
import com.food.loveappetite.activity.MainActivity;
import com.food.loveappetite.activity.UpdateUserActivity;
import com.food.loveappetite.controller.UsersController;
import com.food.loveappetite.model.UsersModel;
import com.google.firebase.auth.FirebaseAuth;

public class SettingFragment extends Fragment {

    private Intent intentLogout;
    private Intent intentProfile;
    private TextView name, email, phoneNumber;
    private Button btnLogout;
    private Button btnProfile;
    private static UsersModel model;

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

        name = view.findViewById(R.id.tv_user_name);
        email = view.findViewById(R.id.tv_user_email);
        phoneNumber = view.findViewById(R.id.tv_user_phone_number);

        model = MainActivity.getUsersModel();

        if (model != null) {
            name.setText(MainActivity.getUsersModel().getName());
            email.setText(MainActivity.getUsersModel().getEmail());
            phoneNumber.setText(MainActivity.getUsersModel().getPhoneNumber());
        } else {
            FirebaseAuth.getInstance().getCurrentUser().getDisplayName();
            FirebaseAuth.getInstance().getCurrentUser().getEmail();
            phoneNumber.setText("Harap Isi No. Telfon");
        }

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