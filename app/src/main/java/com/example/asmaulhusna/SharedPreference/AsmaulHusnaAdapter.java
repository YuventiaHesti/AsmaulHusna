package com.example.asmaulhusna.SharedPreference;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.asmaulhusna.Activity.AsmaulHusna;
import com.example.asmaulhusna.R;

import java.util.List;

public class AsmaulHusnaAdapter extends RecyclerView.Adapter<AsmaulHusnaAdapter.ViewHolder> {
    private List<AsmaulHusna> mAsmaulHusnaList;
    private Context mContext;
    private RecyclerView mRecyclerV;

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textnomor;
        public TextView textnama;
        public TextView textarti;
        public ImageView ImgAsmaulHusna;

        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            textnomor= (TextView) v.findViewById(R.id.textnomor);
            textnama= (TextView) v.findViewById(R.id.textnama);
            textarti = (TextView) v.findViewById(R.id.textarti);
            ImgAsmaulHusna = (ImageView) v.findViewById(R.id.imgAsmaulHusna);
            Left = (Button)v.findViewById(R.id.btn_set_favorite);
            Right = (Button)v.findViewById(R.id.btn_set_share);
        }
    }
    public void add(int position, AsmaulHusna asmaulhusna) {
        mAsmaulHusnaList.add(position, asmaulhusna);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        mAsmaulHusnaList.remove(position);
        notifyItemRemoved(position);
    }
    public AsmaulHusnaAdapter(List<AsmaulHusna> myDataset, Context context, RecyclerView recyclerView) {
        mAsmaulHusnaList = myDataset;
        mContext = context;
        mRecyclerV = recyclerView;
    }
    public AsmaulHusnaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout., parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        final AsmaulHusna = mAsmaulHusnaList.get(position);
        holder.textnomor.setText(asmaulhusna.getNomor());
        holder.textnama.setText(asmaulhusna.getNama());
        holder.textarti.setText(asmaulhusna.getArti());
        holder.Left.setText("Detail");

        Glide.with(mContext)
                .load(asmaulhusna.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.pahlawanImage);

        //listen to single view layout click
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setMessage("Apakah Anda Yakin ingin menghapus Asmaul Husna Favorite Anda ?")
                        .setCancelable(false)
                        .setPositiveButton("Iya", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                DB_Helper dbHelper = new DB_Helper(mContext);
                                dbHelper.deletePahlawanRecord(pahlawan.getNama(),mContext);
                                Intent goInput = new Intent(mContext, DashboardActivity.class);
                                goInput.putExtra("LIST","123");
                                goInput.putExtra("DATA","All");
                                mContext.startActivities(new Intent[]{goInput});
                            }
                        })
                        .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })
                        //Set your icon here
                        .setTitle("Perhatian !!!")
                        .setIcon(R.drawable.ic_close_black_24dp);
                AlertDialog alert = builder.create();
                alert.show();
            }
        });


    }
    public int getItemCount() {
        return mAsmaulHusnaList.size();
    }

}
