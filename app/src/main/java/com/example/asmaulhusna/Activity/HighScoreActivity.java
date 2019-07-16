package com.example.asmaulhusna.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asmaulhusna.R;
import com.example.asmaulhusna.SharedPreference.DB_Helper;

public class HighScoreActivity extends AppCompatActivity {
    TextView highScore,newScore;
    Button Quiz,Home;
    DB_Helper dbHelper;
    private long mBackPressed;
    private static final int TIME_INTERVAL = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);
        Intent data = getIntent();
        final String Score = data.getStringExtra("SCORE");
        highScore=(TextView)findViewById(R.id.tvBestScore);
        newScore=(TextView)findViewById(R.id.tvNewScore);
        Quiz=(Button)findViewById(R.id.btnQuiz);
        Home=(Button)findViewById(R.id.btnHome);
        dbHelper = new DB_Helper(HighScoreActivity.this);
        Cursor cursor = dbHelper.getBestScore();
        String score = null;
        if (cursor.getCount()>0){
            while (cursor.moveToNext()){
                score = cursor.getString(0);
            }
        }
        if (score != null){
            highScore.setText(score);
        }else if(score == null){
            highScore.setText("Belum Ada Best Score");
        }
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HighScoreActivity.this,MenuUtama.class);
                startActivity(intent);
            }
        });
        Quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goInput = new Intent(HighScoreActivity.this, QuizActivity.class);
                goInput.putExtra("NO",String.valueOf(0));
                goInput.putExtra("SCORE",String.valueOf(Integer.parseInt("0")));
                HighScoreActivity.this.startActivities(new Intent[]{goInput});
            }
        });
        if (Score == null){
            newScore.setText("0");
        }else{
            newScore.setText(Score);
        }

    }
    @Override
    public void onBackPressed()
    {

    }
}
