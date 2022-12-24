package com.food.loveappetite.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        if (controller == null)
            controller = new UsersController(this);

        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        editTextTextPassword2 = findViewById(R.id.editTextTextPassword2);

        btnRegister = findViewById(R.id.button);
        tvBackToLogin = findViewById(R.id.textView2);

        intentActivityLogin = new Intent(this, LoginActivity.class);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = editTextTextPersonName.getText().toString().trim();
                gmail = editTextTextEmailAddress.getText().toString().trim();
                nPhone = editTextPhone.getText().toString().trim();
                pass = editTextTextPassword.getText().toString().trim();
                repass = editTextTextPassword2.getText().toString().trim();

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
                if(TextUtils.isEmpty(nPhone)){
                    empty = true;
                    editTextPhone.setError("Please Fill This Section.");
                }
                if (!pass.equals(repass))
                    Toast.makeText(
                            getApplicationContext(),
                            "Passwords Didn't Match",
                            Toast.LENGTH_LONG
                    ).show();
                else {
                    if (!empty) {
                        model = new UsersModel();

                        model.setName(name);
                        model.setEmail(gmail);
                        model.setPassword(pass);
                        model.setPhoneNumber(nPhone);
                        controller.create(model);
                        // logic register
                        // kalo kelar masuk ke halaman login
                    }
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

    @Override
    public void onBackPressed() {
        finish();
    }
}