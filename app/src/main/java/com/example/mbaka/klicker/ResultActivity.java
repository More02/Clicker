package com.example.mbaka.klicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView resultingPoints;
    private TextView myOpinion;
    private Button tryAgain;
    private String meaning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultingPoints = (TextView) findViewById(R.id.resultingPoints);
        myOpinion = (TextView) findViewById(R.id.myOpinion);
        tryAgain = (Button) findViewById(R.id.tryAgain);

        int point = getIntent().getExtras().getInt("points");
        resultingPoints.setText(Integer.toString(point));



        if ((point) >= 90) {meaning = "Ты отлично справляешься:)";}
        if (((point) >= 50) & (point) < 90) {meaning = "Ты можешь лучше, попробуй ещё раз";}
        if ((point)<50) {meaning = "Ты совсем не стараешься:(";}

        myOpinion.setText(meaning);

        tryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }
}
