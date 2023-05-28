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
    private ImageButton monster;
    private TextView numberPoints;
    int point = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        countTime = (TextView) findViewById(R.id.countTime);

//        long time = 10;
//        for (int i = (int)time; i >= 0; i--) {
//            countTime.setText(Integer.toString(i));
//        }

        CountDownTimer CountDownTimer = new CountDownTimer(20000, 1000) {

            @Override
            public void onTick(long l) {
                countTime.setText(" "+ l / 1000+" секунд");
            }

            @Override
            public void onFinish() {
                Intent newIntent = new Intent(PlayActivity.this, ResultActivity.class);
                newIntent.putExtra ("points", point);
                startActivity(newIntent);
                finish();

            }
        }.start();


        monster = (ImageButton)findViewById(R.id.monster);
        numberPoints = (TextView)findViewById(R.id.numberPoints);

        monster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                point++;
                numberPoints.setText(Integer.toString(point));

            }
        });




    }


}
