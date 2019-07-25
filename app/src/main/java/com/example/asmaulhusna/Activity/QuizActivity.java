package com.example.asmaulhusna.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asmaulhusna.Model.DataModelQuiz;
import com.example.asmaulhusna.Model.ModelAsmaulHusna;
import com.example.asmaulhusna.R;
import com.example.asmaulhusna.SharedPreference.DB_Helper;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {
    Button A,B,C,D;
    TextView Soal,Tittle,SCORE;
    ImageView back;
    private long mBackPressed;
    private static final int TIME_INTERVAL = 2000;

    private ArrayList<ModelAsmaulHusna> pList = new ArrayList<>();
    DB_Helper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        back=(ImageView)findViewById(R.id.ivBack);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizActivity.this,MenuUtama.class);
                startActivity(intent);
                finish();
            }
        });

        Intent data = getIntent();
        String No = data.getStringExtra("NO");
        final String Score = data.getStringExtra("SCORE");
        final int no = Integer.parseInt(No);
        A = (Button)findViewById(R.id.btnA);
        B = (Button)findViewById(R.id.btnB);
        C = (Button)findViewById(R.id.btnC);
        D = (Button)findViewById(R.id.btnD);
        Soal = (TextView)findViewById(R.id.tvSoal);
        Tittle = (TextView)findViewById(R.id.tvTittle);
        SCORE = (TextView)findViewById(R.id.tvScore);
        pList.addAll(DataModelQuiz.getListData());
        A.setText(pList.get(no).getJawabana());
        B.setText(pList.get(no).getJawabanb());
        C.setText(pList.get(no).getJawabanc());
        D.setText(pList.get(no).getJawaband());
        Soal.setText(pList.get(no).getSoal());
        SCORE.setText("SCORE : "+Score);
        Tittle.setText("Soal "+(no+1));
        dbHelper = new DB_Helper(QuizActivity.this);
        A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pList.get(no).getJawaban().equals("A")){
                    if (no >= pList.size()-1){
                        Intent goInput = new Intent(QuizActivity.this,HighScoreActivity.class);
                        goInput.putExtra("SCORE",String.valueOf(Integer.parseInt(Score)+10));
                        dbHelper.highScore(String.valueOf(Integer.parseInt(Score)+10));
                        QuizActivity.this.startActivities(new Intent[]{goInput});
                        startActivity(goInput);
                    }else{
                        Intent goInput = new Intent(QuizActivity.this, QuizActivity.class);
                        goInput.putExtra("NO",String.valueOf(no+1));
                        goInput.putExtra("SCORE",String.valueOf(Integer.parseInt(Score)+10));
                        QuizActivity.this.startActivities(new Intent[]{goInput});
                    }
                }else{
                    if (no >= pList.size()-1){
                        Intent goInput = new Intent(QuizActivity.this, HighScoreActivity.class);
                        goInput.putExtra("SCORE",String.valueOf(Score));
                        dbHelper.highScore(String.valueOf(Integer.parseInt(Score)));
                        QuizActivity.this.startActivities(new Intent[]{goInput});
                        startActivity(goInput);
                    }else{
                        Intent goInput = new Intent(QuizActivity.this, QuizActivity.class);
                        goInput.putExtra("NO",String.valueOf(no+1));
                        goInput.putExtra("SCORE",String.valueOf(Score));
                        QuizActivity.this.startActivities(new Intent[]{goInput});
                    }
                }
            }
        });
        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pList.get(no).getJawaban().equals("B")){
                    if (no >= pList.size()-1){
                        Intent goInput = new Intent(QuizActivity.this,HighScoreActivity.class);
                        goInput.putExtra("SCORE",String.valueOf(Integer.parseInt(Score)+10));
                        dbHelper.highScore(String.valueOf(Integer.parseInt(Score)+10));
                        QuizActivity.this.startActivities(new Intent[]{goInput});
                        startActivity(goInput);
                    }else{
                        Intent goInput = new Intent(QuizActivity.this, QuizActivity.class);
                        goInput.putExtra("NO",String.valueOf(no+1));
                        goInput.putExtra("SCORE",String.valueOf(Integer.parseInt(Score)+10));
                        QuizActivity.this.startActivities(new Intent[]{goInput});
                    }
                }else{
                    if (no >= pList.size()-1){
                        Intent goInput = new Intent(QuizActivity.this, HighScoreActivity.class);
                        goInput.putExtra("SCORE",String.valueOf(Score));
                        dbHelper.highScore(String.valueOf(Integer.parseInt(Score)));
                        QuizActivity.this.startActivities(new Intent[]{goInput});
                        startActivity(goInput);
                    }else{
                        Intent goInput = new Intent(QuizActivity.this, QuizActivity.class);
                        goInput.putExtra("NO",String.valueOf(no+1));
                        goInput.putExtra("SCORE",String.valueOf(Score));
                        QuizActivity.this.startActivities(new Intent[]{goInput});
                    }
                }
            }
        });
        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pList.get(no).getJawaban().equals("C")){
                    if (no >= pList.size()-1){
                        Intent goInput = new Intent(QuizActivity.this, HighScoreActivity.class);
                        goInput.putExtra("SCORE",String.valueOf(Integer.parseInt(Score)+10));
                        dbHelper.highScore(String.valueOf(Integer.parseInt(Score)+10));
                        QuizActivity.this.startActivities(new Intent[]{goInput});
                        startActivity(goInput);
                    }else{
                        Intent goInput = new Intent(QuizActivity.this, QuizActivity.class);
                        goInput.putExtra("NO",String.valueOf(no+1));
                        goInput.putExtra("SCORE",String.valueOf(Integer.parseInt(Score)+10));
                        QuizActivity.this.startActivities(new Intent[]{goInput});
                    }
                }else{
                    if (no >= pList.size()-1){
                        Intent goInput = new Intent(QuizActivity.this, HighScoreActivity.class);
                        goInput.putExtra("SCORE",String.valueOf(Score));
                        dbHelper.highScore(String.valueOf(Integer.parseInt(Score)));
                        QuizActivity.this.startActivities(new Intent[]{goInput});
                        startActivity(goInput);
                    }else{
                        Intent goInput = new Intent(QuizActivity.this, QuizActivity.class);
                        goInput.putExtra("NO",String.valueOf(no+1));
                        goInput.putExtra("SCORE",String.valueOf(Score));
                        QuizActivity.this.startActivities(new Intent[]{goInput});
                    }
                }
            }
        });
        D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pList.get(no).getJawaban().equals("D")){
                    if (no >= pList.size()-1){
                        Intent goInput = new Intent(QuizActivity.this, HighScoreActivity.class);
                        goInput.putExtra("SCORE",String.valueOf(Integer.parseInt(Score)+10));
                        dbHelper.highScore(String.valueOf(Integer.parseInt(Score)+10));
                        QuizActivity.this.startActivities(new Intent[]{goInput});
                        startActivity(goInput);
                    }else{
                        Intent goInput = new Intent(QuizActivity.this, QuizActivity.class);
                        goInput.putExtra("NO",String.valueOf(no+1));
                        goInput.putExtra("SCORE",String.valueOf(Integer.parseInt(Score)+10));
                        QuizActivity.this.startActivities(new Intent[]{goInput});
                    }
                }else{
                    if (no >= pList.size()-1){
                        Intent goInput = new Intent(QuizActivity.this, HighScoreActivity.class);
                        goInput.putExtra("SCORE",String.valueOf(Score));
                        dbHelper.highScore(String.valueOf(Integer.parseInt(Score)));
                        QuizActivity.this.startActivities(new Intent[]{goInput});
                        startActivity(goInput);
                    }else{
                        Intent goInput = new Intent(QuizActivity.this, QuizActivity.class);
                        goInput.putExtra("NO",String.valueOf(no+1));
                        goInput.putExtra("SCORE",String.valueOf(Score));
                        QuizActivity.this.startActivities(new Intent[]{goInput});
                    }
                }
            }
        });
    }
    @Override
    public void onBackPressed()
    {

    }
}
