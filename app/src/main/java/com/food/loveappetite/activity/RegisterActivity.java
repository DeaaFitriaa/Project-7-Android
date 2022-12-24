package com.food.loveappetite.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.food.loveappetite.R;
import com.food.loveappetite.controller.UsersController;
import com.food.loveappetite.model.UsersModel;

public class RegisterActivity extends AppCompatActivity {

    Button btnRegister;
    TextView tvBackToLogin;
    UsersModel model;
    UsersController controller;
    EditText editTextTextPersonName, editTextTextEmailAddress, editTextPhone, editTextTextPassword, editTextTextPassword2;

    String name, gmail, nPhone, pass, repass;

    Intent intentActivityLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = editTextTextPersonName.getText().toString().trim();
        gmail = editTextTextEmailAddress.getText().toString().trim();
        nPhone = editTextPhone.getText().toString().trim();
        pass = editTextTextPassword.getText().toString().trim();
        repass = editTextTextPassword2.getText().toString().trim();

        btnRegister = findViewById(R.id.button);
        tvBackToLogin = findViewById(R.id.textView2);

        intentActivityLogin = new Intent(this, LoginActivity.class);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean empty = false;

                if(TextUtils.isEmpty(name)){
                    empty = true;
                    editTextTextPersonName.setError("Please Fill This Section.");
                }
                if(TextUtils.isEmpty(gmail)){
                    empty = true;
                    editTextTextEmailAddress.setError("Please Fill This Section.");
                }
                if(TextUtils.isEmpty(pass)){
                    empty = true;
                    editTextTextPassword.setError("Please Fill This Section.");
                }
                if(TextUtils.isEmpty(repass)){
                    empty = true;
                    editTextTextPassword2.setError("Please Fill This Section.");
                }
                if(! empty){
                    model.setName(name);
                    model.setEmail(gmail);
                    model.setPassword(pass);
                    controller.create(model);
                    // logic register
                    // kalo kelar masuk ke halaman login
                    startActivity(intentActivityLogin);
                    finish();
                }
            }
        });
        tvBackToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentActivityLogin);
                finish();
            }
        });
    }
}