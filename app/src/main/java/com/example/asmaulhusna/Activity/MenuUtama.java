package com.example.asmaulhusna.Activity;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.asmaulhusna.Fragment.utama;
import com.example.asmaulhusna.R;

import java.util.ArrayList;

public class MenuUtama extends AppCompatActivity {
    private long mBackPressed;
    private static final int TIME_INTERVAL = 2000;
    private static ArrayList<Activity> activities=new ArrayList<Activity>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuutama);
        Fragment fragment=new utama();
        ChangeFragment(fragment);
    }
    private void ChangeFragment (Fragment fragment){
        if(fragment != null){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.container,fragment);
            ft.commit();
        }
    }

    @Override
    public void onBackPressed()
    {
        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis())
        {
            finish();
            System.exit(0);
            return;
        }
        else { Toast.makeText(getBaseContext(), "ketuk 2 kali bila ingin keluar", Toast.LENGTH_SHORT).show(); }

        mBackPressed = System.currentTimeMillis();

    }
}
