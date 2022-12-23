package com.food.loveappetite.activity;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.food.loveappetite.R;
import com.food.loveappetite.controller.UsersController;

public class LoginActivity extends AppCompatActivity {

    TextView tvSignUp;
    Intent intentSignUp;

    Button btnLogin;
    Intent intentLogin;

    private String emailtxt, passwordtxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvSignUp = findViewById(R.id.textView5);
        intentSignUp = new Intent(this, RegisterActivity.class);

        btnLogin = findViewById(R.id.button3);
        intentLogin = new Intent(this, MainActivity.class);

        emailtxt = findViewById(R.id.editTextTextEmailAddress).toString().trim();
        passwordtxt = findViewById(R.id.editTextTextPassword).toString().trim();

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
//                UsersController controller = new UsersController();
//                controller.loginWithEmailAndPassword(emailtxt, passwordtxt);
                startActivity(intentLogin);
                finish();
            }
        });
    }
}