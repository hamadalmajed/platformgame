package com.example.platformgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Top_Scores extends AppCompatActivity {

    TextView top1,top2,top3,top4,top5;
    int Score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top__scores);
        top1=(TextView)findViewById(R.id.top1);
        top2=(TextView)findViewById(R.id.top2);
        top3=(TextView)findViewById(R.id.top3);
        top4=(TextView)findViewById(R.id.top4);
        top5=(TextView)findViewById(R.id.top5);
        SharedPreferences settings = getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE);
        Score = settings.getInt("score", 0);

        int score1=settings.getInt("SCORE1", 0);
        int score2=settings.getInt("SCORE2", 0);
        int score3=settings.getInt("SCORE3", 0);
        int score4=settings.getInt("SCORE4", 0);
        int score5=settings.getInt("SCORE5", 0);


        SharedPreferences.Editor editor = settings.edit();

        if(Score>score1){
            top1.setText(String.valueOf(Score));
            editor.putInt("SCORE1", Score);
            editor.putInt("SCORE2", score1);
            editor.putInt("SCORE3", score2);
            editor.putInt("SCORE4", score3);
            editor.putInt("SCORE5", score4);
            editor.commit();
            score1=Score;


        }
        else if(Score>score2){
            top2.setText(String.valueOf(Score));
            editor.putInt("SCORE2", Score);
            editor.putInt("SCORE3", score2);
            editor.putInt("SCORE4", score3);
            editor.putInt("SCORE5", score4);
            editor.commit();
            score2=Score;


        }
        else if(Score>score3){
            top3.setText(String.valueOf(Score));
            editor.putInt("SCORE3", Score);
            editor.putInt("SCORE4", score3);
            editor.putInt("SCORE5", score4);
            editor.commit();
            score3=Score;


        }
        else if(Score>score4){
            top4.setText(String.valueOf(Score));
            editor.putInt("SCORE4", Score);
            editor.putInt("SCORE5", score4);
            editor.commit();
            score4=Score;


        }
        else if(Score>score5){
            top5.setText(String.valueOf(Score));
            score5=Score;
            editor.putInt("SCORE5", Score);
            editor.commit();

        }
        top1.setText(String.valueOf(settings.getInt("SCORE1", 0)));
        top2.setText(String.valueOf(settings.getInt("SCORE2", 0)));
        top3.setText(String.valueOf(settings.getInt("SCORE3", 0)));
        top4.setText(String.valueOf(settings.getInt("SCORE4", 0)));
        top5.setText(String.valueOf(settings.getInt("SCORE5", 0)));
    }

    public void Back(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}

