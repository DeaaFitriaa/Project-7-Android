package com.food.loveappetite.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.food.loveappetite.R;
import com.food.loveappetite.controller.UsersController;
import com.food.loveappetite.model.UsersModel;
import com.google.firebase.auth.FirebaseAuth;

public class UpdateUserActivity extends AppCompatActivity {

    // Deklarasi model user dan text view/button
    private Button btnUpdate;
    private TextView tvBack;
    private EditText etUsername;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etPhoneNumber;
    private String name, email, password, phoneNumber;

    //deklarasi intent
    private Intent intent;

    // deklarasi model
    private static UsersModel model;

    // deklasrasi controller
    private static UsersController controller;

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
        model = MainActivity.getUsersModel();

        // inisialisasi controller
        controller = MainActivity.getUsersController();

        if(model != null){
            etUsername.setText(MainActivity.getUsersModel().getName());
            etEmail.setText(MainActivity.getUsersModel().getEmail());
            etPassword.setText(MainActivity.getUsersModel().getPassword());
            etPhoneNumber.setText(MainActivity.getUsersModel().getPhoneNumber());
        } else{
            etUsername.setText(FirebaseAuth.getInstance().getCurrentUser().getDisplayName());
            etEmail.setText(FirebaseAuth.getInstance().getCurrentUser().getEmail());
            etPassword.setText("Harap isi Password");
            etPhoneNumber.setText("Harap Isi No. Telfon");
        }

        // onClick btnUpdate, tvBack
        btnUpdate.setOnClickListener(view -> {
            name = etUsername.getText().toString().trim();
            email = etEmail.getText().toString().trim();
            password = etPassword.getText().toString().trim();
            phoneNumber = etPhoneNumber.getText().toString().trim();

            model.setName(name);
            model.setEmail(email);
            model.setPassword(password);
            model.setPhoneNumber(phoneNumber);

            controller.update(model);
            intent = new Intent(UpdateUserActivity.this, MainActivity.class);
            intent.putExtra("UsersModel", model);
            startActivity(intent);
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