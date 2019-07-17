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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.asmaulhusna.Activity.AsmaulHusna;
import com.example.asmaulhusna.Activity.DetailAsmaulhusna;
import com.example.asmaulhusna.Model.ModelAsmaulHusna;
import com.example.asmaulhusna.R;

import java.util.List;

public class AsmaulHusnaAdapter extends RecyclerView.Adapter<AsmaulHusnaAdapter.ViewHolder> {
    private List<ModelAsmaulHusna> mAsmaulHusnaList;
    private Context mContext;
    private RecyclerView mRecyclerV;

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView Nomor, Nama, Arti;
        ImageView Gambar;
        RelativeLayout list;

        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            Nomor=(TextView)itemView.findViewById(R.id.textnomor);
            Nama=(TextView)itemView.findViewById(R.id.textnama);
            Arti=(TextView)itemView.findViewById(R.id.textarti);
            Gambar=(ImageView)itemView.findViewById(R.id.ImgAsmaulHusna);
            list=(RelativeLayout)itemView.findViewById(R.id.listAsmaulHusna);

        }
    }
    public void add(int position, ModelAsmaulHusna asmaulhusna) {
        mAsmaulHusnaList.add(position,asmaulhusna);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        mAsmaulHusnaList.remove(position);
        notifyItemRemoved(position);
    }
    public AsmaulHusnaAdapter(List<ModelAsmaulHusna> myDataset, Context context, RecyclerView recyclerView) {
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
                inflater.inflate(R.layout.listasmaulhusna, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        final ModelAsmaulHusna asmaulHusna = mAsmaulHusnaList.get(position);
        holder.Nomor.setText(asmaulHusna.getNomor());
        holder.Nama.setText(asmaulHusna.getNama());
        holder.Arti.setText(asmaulHusna.getArti());
        holder.Gambar.setImageResource(Integer.parseInt(asmaulHusna.getGambar()));
        holder.list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goInput = new Intent(mContext, DetailAsmaulhusna.class);
                goInput.putExtra("DetailExtra","AsmaulHusna");
                goInput.putExtra("Nomor",asmaulHusna.getNomor());
                goInput.putExtra("Nama",asmaulHusna.getNama());
                goInput.putExtra("Arti",asmaulHusna.getArti());
                goInput.putExtra("Gambar",asmaulHusna.getGambar());
                goInput.putExtra("Kisah",asmaulHusna.getKisah());
                goInput.putExtra("JudulKisah",asmaulHusna.getJudulkisah());
                goInput.putExtra("Penjelasan",asmaulHusna.getPenjelasan());
                goInput.putExtra("Suara",asmaulHusna.getSuara());
                goInput.putExtra("KisahGambar",asmaulHusna.getKisahGambar());
                mContext.startActivities(new Intent[]{goInput});
            }
        });
    }
    public int getItemCount() {
        return mAsmaulHusnaList.size();
    }

}
