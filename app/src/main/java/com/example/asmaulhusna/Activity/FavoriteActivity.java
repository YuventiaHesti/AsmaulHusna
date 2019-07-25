package com.example.asmaulhusna.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

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
    ImageView back;

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

        back=(ImageView)findViewById(R.id.ivBack);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FavoriteActivity.this,AsmaulHusna.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void onBackPressed() {
    }
}
