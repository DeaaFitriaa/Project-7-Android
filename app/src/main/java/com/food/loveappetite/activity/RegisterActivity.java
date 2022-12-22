package com.food.loveappetite.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.food.loveappetite.R;

public class RegisterActivity extends AppCompatActivity {

    Button btnRegister;
    TextView tvBackToLogin;

    Intent intentActivityLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister = findViewById(R.id.button);
        tvBackToLogin = findViewById(R.id.textView2);

        intentActivityLogin = new Intent(this, LoginActivity.class);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // logic register
                // kalo kelar masuk ke halaman login
                startActivity(intentActivityLogin);
                finish();
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