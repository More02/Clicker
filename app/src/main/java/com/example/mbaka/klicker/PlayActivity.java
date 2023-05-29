package com.example.mbaka.klicker;

import android.content.Intent;
import android.os.CountDownTimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class PlayActivity extends AppCompatActivity {

    private TextView countTime;
    private TextView numberPoints;
    int point = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        countTime = findViewById(R.id.countTime);
        new CountDownTimer(20000, 1000) {

            @Override
            public void onTick(long l) {
                countTime.setText(" " + l / 1000 + " секунд");
            }

            @Override
            public void onFinish() {
                Intent newIntent = new Intent(PlayActivity.this, ResultActivity.class);
                newIntent.putExtra("points", point);
                startActivity(newIntent);
                finish();

            }
        }.start();

        ImageButton monster = findViewById(R.id.monster);
        numberPoints = findViewById(R.id.numberPoints);

        monster.setOnClickListener(view -> {
            point++;
            numberPoints.setText(Integer.toString(point));

        });
    }
}
