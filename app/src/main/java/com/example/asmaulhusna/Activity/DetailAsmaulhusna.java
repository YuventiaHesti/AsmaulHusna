package com.example.asmaulhusna.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.asmaulhusna.Model.ModelAsmaulHusna;
import com.example.asmaulhusna.R;
import com.example.asmaulhusna.SharedPreference.DB_Helper;

public class DetailAsmaulhusna extends AppCompatActivity {
    TextView nomor,nama,arti,penjelasan,kisah,judulkisah;
    ImageView gambar,kisahgambar,play,stop, back;
    Button favorite;
    DB_Helper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_asmaulhusna);
        back=(ImageView)findViewById(R.id.ivBack);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailAsmaulhusna.this,AsmaulHusna.class);
                startActivity(intent);
                finish();
            }
        });
        dbHelper = new DB_Helper(DetailAsmaulhusna.this);
        //Deklarasi Variable
        nomor=(TextView)findViewById(R.id.textnomor);
        nama=(TextView)findViewById(R.id.textnama);
        arti=(TextView)findViewById(R.id.textarti);
        penjelasan=(TextView)findViewById(R.id.textpenjelasan);
        kisah=(TextView)findViewById(R.id.textkisah);
        judulkisah=(TextView)findViewById(R.id.textjudul);
        gambar=(ImageView)findViewById(R.id.gambar);
        kisahgambar=(ImageView)findViewById(R.id.imgkisah);
        play=(ImageView)findViewById(R.id.imgplay);
        stop=(ImageView)findViewById(R.id.imgstop);
        favorite=(Button)findViewById(R.id.btnFav);
        //getString
        Intent data = getIntent();
        final String Nomor = data.getStringExtra("Nomor");
        final String Nama = data.getStringExtra("Nama");
        final String Arti = data.getStringExtra("Arti");
        final String Penjelasan = data.getStringExtra("Penjelasan");
        final String Gambar = data.getStringExtra("Gambar");
        final String Suara = data.getStringExtra("Suara");
        final String Kisah = data.getStringExtra("Kisah");
        final String JudulKisah = data.getStringExtra("JudulKisah");
        final String KisahGambar = data.getStringExtra("KisahGambar");

        nomor.setText(Nomor);
        nama.setText(Nama);
        arti.setText(Arti);
        penjelasan.setText(Penjelasan);
        kisah.setText(Kisah);
        judulkisah.setText(JudulKisah);
        final MediaPlayer suara = MediaPlayer.create(this,Integer.parseInt(Suara));
        gambar.setImageResource(Integer.parseInt(Gambar));
        getImageFromURL(KisahGambar);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                suara.start();
            }
        });
        Cursor cursor = dbHelper.checkAsmaulHusna(Nama);
        String nomor = null;
        if (cursor.getCount()>0){
            while (cursor.moveToNext()){
                nomor = cursor.getString(0);
            }
        }
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                suara.stop();
            }
        });
        if (nomor == null){
            favorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(DetailAsmaulhusna.this,"Asmaul Husna Terfavoritekan",Toast.LENGTH_SHORT).show();
                    ModelAsmaulHusna asmaulHusna = new ModelAsmaulHusna(Nomor,Nama,Arti,Gambar,Suara,Kisah,KisahGambar,Penjelasan,JudulKisah);
                    dbHelper.FavoriteAsmaulHusna(asmaulHusna);
                    Intent intent = new Intent(DetailAsmaulhusna.this,FavoriteActivity.class);
                    startActivity(intent);

                    finish();
                }
            });
        }else{
            favorite.setText("FAVORITED");
            favorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(DetailAsmaulhusna.this,"Asmaul Husna Sudah Terfavoritekan",Toast.LENGTH_SHORT).show();
                    dbHelper.deleteAsmaulHusnaRecord(Nomor,DetailAsmaulhusna.this);
                    Intent intent= new Intent(DetailAsmaulhusna.this, AsmaulHusna.class);
                    startActivity(intent);

                    finish();
                }
            });
        }
    }
    private void getImageFromURL(String Photo){
        Glide.with(DetailAsmaulhusna.this)
                .load(Photo)
                .into(kisahgambar);
    }
    public void onBackPressed() {
    }
}
