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

public class AdapterFLDaily extends RecyclerView.Adapter<AdapterFLDaily.ViewHolder> {

    private final Context context;
    private final String[] SubjectValues;
    private final int[] foto_profile;

    public AdapterFLDaily(Context context, String[] subjectValues, int[] foto_profile) {
        this.context = context;
        SubjectValues = subjectValues;
        this.foto_profile = foto_profile;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_friendlist, parent, false);

        return new AdapterFLDaily.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(foto_profile[position]);
        holder.textView.setText(SubjectValues[position]);
    }

    @Override
    public int getItemCount() {
        return SubjectValues.length;
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        ViewHolder(View view) {
            super(view);

            imageView = view.findViewById(R.id.item_img_profile);
            textView = view.findViewById(R.id.item_text_friendlist);


        }
    }
}
