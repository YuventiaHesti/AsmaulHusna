package com.example.asmaulhusna.SharedPreference;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.asmaulhusna.Activity.AsmaulHusna;
import com.example.asmaulhusna.Model.ModelAsmaulHusna;

import java.util.LinkedList;
import java.util.List;

public class DB_Helper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "session.db";
    private static final int DATABASE_VERSION = 3;
    //Table
    public static final String TABLE_NAME_ASMAULHUSNA = "asmaulhusna";
    public static final String TABLE_NAME_BEST_SCORE = "bestscore";
    //Column
    //public static final String COLUMN_ID = "id";
    public static final String COLUMN_SCORE = "score";
    public static final String COLUMN_NOMOR = "nomor";
    public static final String COLUMN_NAMA = "nama";
    public static final String COLUMN_ARTI = "arti";
    public static final String COLUMN_GAMBAR = "gambar";
    public static final String COLUMN_SUARA = "suara";
    public static final String COLUMN_KISAH = "kisah";
    public static final String COLUMN_KISAHGAMBAR = "kisahgambar";
    public static final String COLUMN_PENJELASAN = "penjelasan";
    public static final String COLUMN_JUDULKISAH = "judulkisah";

    public DB_Helper(Context context){super(
            context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME_BEST_SCORE+" (" +
                COLUMN_SCORE+" TEXT NOT NULL);"
        );
        db.execSQL("CREATE TABLE "+TABLE_NAME_ASMAULHUSNA+" (" +
                COLUMN_NOMOR+" TEXT NOT NULL, "+
                COLUMN_NAMA+" TEXT NOT NULL,"+
                COLUMN_ARTI+" TEXT NOT NULL,"+
                COLUMN_GAMBAR+" TEXT NOT NULL,"+
                COLUMN_SUARA+" TEXT NOT NULL,"+
                COLUMN_KISAH+" TEXT NOT NULL,"+
                COLUMN_KISAHGAMBAR+" TEXT NOT NULL, "+
                COLUMN_PENJELASAN+" TEXT NOT NULL,"+
                COLUMN_JUDULKISAH+" TEXT NOT NULL);"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_ASMAULHUSNA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_BEST_SCORE);
        this.onCreate(db);
    }
    public List<ModelAsmaulHusna> asmaulHusnaList() {
        String query = "SELECT  * FROM " + TABLE_NAME_ASMAULHUSNA;

        List<ModelAsmaulHusna> asmaulHusnaLinkedList = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        ModelAsmaulHusna asmaulhusna;

        if (cursor.moveToFirst()) {
            do {
                asmaulhusna = new ModelAsmaulHusna();
                asmaulhusna.setNomor(cursor.getString(cursor.getColumnIndex(COLUMN_NOMOR)));
                asmaulhusna.setNama(cursor.getString(cursor.getColumnIndex(COLUMN_NAMA)));
                asmaulhusna.setArti(cursor.getString(cursor.getColumnIndex(COLUMN_ARTI)));
                asmaulhusna.setGambar(cursor.getString(cursor.getColumnIndex(COLUMN_GAMBAR)));
                asmaulhusna.setSuara(cursor.getString(cursor.getColumnIndex(COLUMN_SUARA)));
                asmaulhusna.setKisah(cursor.getString(cursor.getColumnIndex(COLUMN_KISAH)));
                asmaulhusna.setKisahGambar(cursor.getString(cursor.getColumnIndex(COLUMN_KISAHGAMBAR)));
                asmaulhusna.setPenjelasan(cursor.getString(cursor.getColumnIndex(COLUMN_PENJELASAN)));
                asmaulhusna.setJudulkisah(cursor.getString(cursor.getColumnIndex(COLUMN_JUDULKISAH)));
                asmaulHusnaLinkedList.add(asmaulhusna);
            } while (cursor.moveToNext());
    }
        return asmaulHusnaLinkedList;
    }
    public List<ModelAsmaulHusna> highScoreList() {
        String query = "SELECT  * FROM " + TABLE_NAME_BEST_SCORE +" ORDER BY " +COLUMN_SCORE+ " DESC LIMIT 1";

        List<ModelAsmaulHusna> asmaulHusnaLinkedList = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        ModelAsmaulHusna asmaulhusna;

        if (cursor.moveToFirst()) {
            do {
                asmaulhusna = new ModelAsmaulHusna();
                asmaulhusna.setScore(cursor.getString(cursor.getColumnIndex(COLUMN_SCORE)));
                asmaulHusnaLinkedList.add(asmaulhusna);
            } while (cursor.moveToNext());
        }
        return asmaulHusnaLinkedList;
    }
    public void highScore(String score) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SCORE, score);

        // insert
        db.insert(TABLE_NAME_BEST_SCORE,null, values);
        db.close();
    }
    public void FavoriteAsmaulHusna(ModelAsmaulHusna asmaulhusna) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOMOR, asmaulhusna.getNomor());
        values.put(COLUMN_NAMA, asmaulhusna.getNama());
        values.put(COLUMN_ARTI, asmaulhusna.getArti());
        values.put(COLUMN_GAMBAR, asmaulhusna.getGambar());
        values.put(COLUMN_SUARA, asmaulhusna.getSuara());
        values.put(COLUMN_KISAH, asmaulhusna.getKisah());
        values.put(COLUMN_KISAHGAMBAR, asmaulhusna.getKisahGambar());
        values.put(COLUMN_PENJELASAN, asmaulhusna.getPenjelasan());
        values.put(COLUMN_JUDULKISAH, asmaulhusna.getJudulkisah());


        // insert
        db.insert(TABLE_NAME_ASMAULHUSNA,null, values);
        db.close();
    }
    public void deleteAsmaulHusnaRecord(String nomor, Context context) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM "+TABLE_NAME_ASMAULHUSNA+" WHERE nomor='"+nomor+"'");
        Toast.makeText(context, "Deleted successfully", Toast.LENGTH_SHORT).show();
    }

    public Cursor getBestScore(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT  * FROM " + TABLE_NAME_BEST_SCORE + " ORDER BY "+COLUMN_SCORE+" DESC LIMIT 1";
        Cursor cursor = db.rawQuery(query,null);
        return cursor;
    }
    public Cursor checkAsmaulHusna(String nama){
        SQLiteDatabase db = this.getWritableDatabase();
        String query ="SELECT * FROM "+TABLE_NAME_ASMAULHUSNA+" WHERE nama = '"+nama+"'";
        Cursor cursor = db.rawQuery(query,null);
        return cursor;
    }

}
