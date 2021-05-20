package com.app.ihsan946.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.ihsan946.akb_uts.R;

public class AdapterMusikFav extends RecyclerView.Adapter<AdapterMusikFav.ViewHolder> {

    private final Context context;
    private final String[] judul_lagu;

    public AdapterMusikFav(Context context, String[] judul_lagu) {
        this.context = context;
        this.judul_lagu = judul_lagu;
    }

    @NonNull
    @Override
    public AdapterMusikFav.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_fav_music, parent, false);
        return new AdapterMusikFav.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMusikFav.ViewHolder holder, int position) {
        holder.textView.setText(judul_lagu[position]);
    }

    @Override
    public int getItemCount() {
        return judul_lagu.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        ViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.judul_musik_fav);

        }

    }
}
