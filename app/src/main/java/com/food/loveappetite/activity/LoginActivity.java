package com.food.loveappetite.activity;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;

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
        if (controller == null)
            controller = new UsersController(this);

        tvSignUp = findViewById(R.id.textView5);
        intentSignUp = new Intent(this, RegisterActivity.class);

        btnLogin = findViewById(R.id.button3);
        intentLogin = new Intent(this, MainActivity.class);

        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);

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
                emailtxt = editTextTextEmailAddress.getText().toString().trim();
                passwordtxt = editTextTextPassword.getText().toString().trim();

                controller.loginWithEmailAndPassword(emailtxt, passwordtxt);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (controller.isLoggedIn()) {
            controller.read(FirebaseAuth.getInstance().getCurrentUser(), new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    if (task.isSuccessful())
                        model = task.getResult().getValue(UsersModel.class);

                    intentLogin.putExtra("UsersModel", model);
                    startActivity(intentLogin);
                    finish();
                }
            });
        }
    }
}