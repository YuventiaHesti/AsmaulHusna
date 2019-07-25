package com.example.asmaulhusna.Fragment;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.asmaulhusna.Activity.AsmaulHusna;
import com.example.asmaulhusna.Activity.ContactActivity;
import com.example.asmaulhusna.Activity.HighScoreActivity;
import com.example.asmaulhusna.Activity.KaidahAsmaulHusna;
import com.example.asmaulhusna.Activity.ManfaatAsmaulHusna;
import com.example.asmaulhusna.Activity.TentangActivity;
import com.example.asmaulhusna.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class utama extends Fragment {

    ImageView asmaulhusna, kaidah, manfaat,quiz,contact,about;


    public utama() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_utama, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        asmaulhusna=(ImageView)view.findViewById(R.id.img_asmaulhusna);
        kaidah=(ImageView)view.findViewById(R.id.kaidah);
        manfaat=(ImageView)view.findViewById(R.id.manfaat);
        quiz=(ImageView)view.findViewById(R.id.quiz);
        contact=(ImageView)view.findViewById(R.id.contact);
        about=(ImageView)view.findViewById(R.id.about);

        //ON CLICK
        asmaulhusna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(), AsmaulHusna.class);
                startActivity(intent);

            }
        });
        kaidah.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), KaidahAsmaulHusna.class);
            startActivity(intent);
        }
        });
        manfaat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ManfaatAsmaulHusna.class);
                startActivity(intent);
            }
        });
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HighScoreActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ContactActivity.class);
                startActivity(intent);
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TentangActivity.class);
                startActivity(intent);
            }
        });
        //DONE
    }

    public void onBackPressed()
    {
        getActivity().finish();
    }

    }
