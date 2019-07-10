package com.example.asmaulhusna.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.asmaulhusna.Model.DataModelAsmaulHusna;
import com.example.asmaulhusna.Model.ModelAsmaulHusna;
import com.example.asmaulhusna.R;
import com.example.asmaulhusna.SharedPreference.AsmaulHusnaAdapter;
import com.example.asmaulhusna.SharedPreference.DB_Helper;

import java.util.ArrayList;

public class FavoriteActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<ModelAsmaulHusna> List = new ArrayList<>();
    DB_Helper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        //Variable
        rvCategory = (RecyclerView)findViewById(R.id.recyclerview);
        //Done
        //getArguments
        List.addAll(DataModelAsmaulHusna.getListData());
        rvCategory.setHasFixedSize(true);
        dbHelper = new DB_Helper(this);
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        AsmaulHusnaAdapter asmaulHusnaAdapter = new AsmaulHusnaAdapter(dbHelper.asmaulHusnaList(),this,rvCategory);
        rvCategory.setAdapter(asmaulHusnaAdapter);
    }
}
