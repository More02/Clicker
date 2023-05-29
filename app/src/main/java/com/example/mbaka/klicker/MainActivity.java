package com.example.mbaka.klicker;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonStart = findViewById(R.id.buttonStart);
        buttonStart.setOnClickListener(view -> {
            Intent myIntent = new Intent(MainActivity.this, PlayActivity.class);
            startActivity(myIntent);
            finish();
        });
    }
}
