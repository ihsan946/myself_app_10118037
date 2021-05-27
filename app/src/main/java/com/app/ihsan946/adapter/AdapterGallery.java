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

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.ihsan946.akb_uts.R;

public class AdapterGallery extends RecyclerView.Adapter<AdapterGallery.ViewHolder> {

    private final Context context;
    private final int[] gambar_gallery;


    public AdapterGallery(Context context, int[] gambar_gallery) {
        this.context = context;
        this.gambar_gallery = gambar_gallery;
    }

    //
    @NonNull
    @Override
    public AdapterGallery.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_gallery, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterGallery.ViewHolder holder, int position) {

        holder.imageView.setImageResource(gambar_gallery[position]);
    }

    @Override
    public int getItemCount() {
        return gambar_gallery.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        ViewHolder(View view) {
            super(view);

            imageView = view.findViewById(R.id.img_gallery);


        }
    }
}
