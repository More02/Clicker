package com.example.mbaka.klicker;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private String meaning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView resultingPoints = findViewById(R.id.resultingPoints);
        TextView myOpinion = findViewById(R.id.myOpinion);
        Button tryAgain = findViewById(R.id.tryAgain);

        int point = getIntent().getExtras().getInt("points");
        resultingPoints.setText(" "+ point);

        if ((point) >= 90) {meaning = "Ты отлично справляешься:)";}
        if (((point) >= 50) & (point) < 90) {meaning = "Ты можешь лучше, попробуй ещё раз";}
        if ((point)<50) {meaning = "Ты совсем не стараешься:(";}

        myOpinion.setText(meaning);

        tryAgain.setOnClickListener(view -> {
            Intent intent = new Intent(ResultActivity.this, MainActivity.class);
            startActivity(intent);
            finish();

        });
    }
}
