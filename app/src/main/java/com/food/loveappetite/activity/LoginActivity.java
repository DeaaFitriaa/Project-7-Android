package com.food.loveappetite.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.food.loveappetite.R;

public class LoginActivity extends AppCompatActivity {

    TextView tvSignUp;
    Intent intentSignUp;

    Button btnLogin;
    Intent intentLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvSignUp = findViewById(R.id.textView5);
        intentSignUp = new Intent(this, RegisterActivity.class);

        btnLogin = findViewById(R.id.button3);
        intentLogin = new Intent(this, MainActivity.class);

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
                startActivity(intentLogin);
                finish();
            }
        });
    }
}