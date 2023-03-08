package com.example.countscore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int scoreA=0;
    int scoreB=0;
    public void display_scoreA(int score){
        TextView scoreview=(TextView) findViewById(R.id.txt2A);
        scoreview.setText(String.valueOf(score));
    }
    public void display_scoreB(int score){
        TextView scoreview=(TextView) findViewById(R.id.txt2B);
        scoreview.setText(String.valueOf(score));
    }
    public void button3A(View view){
        scoreA+=3;
        display_scoreA(scoreA);
    }
    public void button2A(View view){
        scoreA+=2;
        display_scoreA(scoreA);
    }
    public void buttonthA(View view){
        scoreA+=1;
        display_scoreA(scoreA);
    }
    public void button3B(View view){
        scoreB+=3;
        display_scoreB(scoreB);
    }
    public void button2B(View view){
        scoreB+=2;
        display_scoreB(scoreB);
    }
    public void buttonthB(View view){
        scoreB+=1;
        display_scoreB(scoreB);
    }
    public void reset(View view){
        scoreA=scoreB=0;
        display_scoreA(scoreA);
        display_scoreB(scoreB);
    }
}