package com.food.loveappetite.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.food.loveappetite.R;

public class LauncherActivity extends AppCompatActivity {

    Button apa;
    Intent mau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        mau = new Intent(this, LoginActivity.class);
        apa = findViewById(R.id.button);
        apa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(mau);
                finish();
            }
        });

    }
}