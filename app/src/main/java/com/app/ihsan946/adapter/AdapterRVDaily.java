package com.app.ihsan946.adapter;

//NIM : 10118037
//Nama : Muhammad Ihsan
//Kelas : IF-1/2018
//Tanggal Pembuatan : 24 Mei 2021
//
//

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.ihsan946.akb_uts.R;

public class AdapterRVDaily extends RecyclerView.Adapter<AdapterRVDaily.ViewHolder> {

    private final Context context;
    private final String[] SubjectValues;
    private final int[] gambar_act;
    private final String[] SubjectValues3;

    public AdapterRVDaily(Context context, String[] subjectValues, int[] gambar_act, String[] subjectValues3) {
        this.context = context;
        SubjectValues = subjectValues;
        this.gambar_act = gambar_act;
        SubjectValues3 = subjectValues3;
    }
    //


    //
    @NonNull
    @Override
    public AdapterRVDaily.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_daily_act, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRVDaily.ViewHolder holder, int position) {

        holder.imageView.setImageResource(gambar_act[position]);
        holder.textView.setText(SubjectValues[position]);
        holder.textView2.setText(SubjectValues3[position]);
    }

    @Override
    public int getItemCount() {
        return SubjectValues.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        TextView textView2;

        ViewHolder(View view) {
            super(view);

            imageView = view.findViewById(R.id.item_img_daily);
            textView = view.findViewById(R.id.item_text_daily);
            textView2 = view.findViewById(R.id.item_text2_daily);


        }

    }
}
