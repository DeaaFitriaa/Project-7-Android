package com.food.loveappetite.activity;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.food.loveappetite.R;
import com.food.loveappetite.controller.UsersController;
import com.food.loveappetite.model.UsersModel;

public class LoginActivity extends AppCompatActivity {

    TextView tvSignUp;
    Intent intentSignUp;
    EditText editTextTextEmailAddress, editTextTextPassword;
    Button btnLogin;
    Intent intentLogin;
    UsersModel model;
    UsersController controller;

    private String emailtxt, passwordtxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvSignUp = findViewById(R.id.textView5);
        intentSignUp = new Intent(this, RegisterActivity.class);

        btnLogin = findViewById(R.id.button3);
        intentLogin = new Intent(this, MainActivity.class);

        emailtxt = editTextTextEmailAddress.getText().toString().trim();
        passwordtxt = editTextTextPassword.getText().toString().trim();

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentSignUp);
                finish();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Log.d(TAG, emailtxt);
                controller.loginWithEmailAndPassword(emailtxt, passwordtxt);
                startActivity(intentLogin);
                finish();
            }
        });
    }
}