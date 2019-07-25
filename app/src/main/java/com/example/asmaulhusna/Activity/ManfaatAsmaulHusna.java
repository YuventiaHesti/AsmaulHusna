package com.example.asmaulhusna.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.asmaulhusna.R;

public class ManfaatAsmaulHusna extends AppCompatActivity {
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manfaat_asmaul_husna);
        back=(ImageView)findViewById(R.id.ivBack);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManfaatAsmaulHusna.this,MenuUtama.class);
                startActivity(intent);
                finish();
            }
        });

    }
    public void onBackPressed() {

    }
}
