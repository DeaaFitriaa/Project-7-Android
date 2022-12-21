package com.food.loveappetite.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.food.loveappetite.R;

public class UpdateUserActivity extends AppCompatActivity {

    // Deklarasi model user dan text view/button
    private Button btnUpdate;
    private TextView tvBack;
    private EditText etUsername;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etPhoneNumber;

    // deklarasi model

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);

        // inisialisasi TextView, Button, EditText
        btnUpdate = findViewById(R.id.btn_update);
        tvBack = findViewById(R.id.tv_back);
        etUsername = findViewById(R.id.et_user_name);
        etEmail = findViewById(R.id.et_user_email);
        etPassword = findViewById(R.id.et_password);
        etPhoneNumber = findViewById(R.id.et_phone_number);

        // inisialisasi model

        // onClick btnUpdate, tvBack
        btnUpdate.setOnClickListener(view -> {
            // AuthController.update(model);
        });
        tvBack.setOnClickListener(view -> {
            finish();
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}