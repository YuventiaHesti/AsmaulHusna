package com.example.asmaulhusna.Activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.asmaulhusna.R;

public class MainActivity extends AppCompatActivity {
    TextView tvSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //menghilangkan ActionBar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        final MediaPlayer SuaraLagu = MediaPlayer.create(MainActivity.this,R.raw.welcome);
        SuaraLagu.start();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                changeActivity();
                finish();
            }
        }, 5000); //5000 L = 5 detik
    }

    private void changeActivity(){
        Intent intent = new Intent(this,MenuUtama.class);
        startActivity(intent);
    }
}
