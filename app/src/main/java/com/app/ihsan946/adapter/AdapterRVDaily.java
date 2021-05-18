package com.app.ihsan946.adapter;

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
    private String[] SubjectValues;
    private int[] gambar_act;


    public AdapterRVDaily(String[] subjectValues, int[] gambar_act, Context context) {
        SubjectValues = subjectValues;
        this.gambar_act = gambar_act;
        this.context = context;
    }


    //


    //

    public String[] getSubjectValues() {
        return SubjectValues;
    }
    //

    public void setSubjectValues(String[] subjectValues) {
        SubjectValues = subjectValues;
    }

    public int[] getGambar_act() {
        return gambar_act;
    }

    public void setGambar_act(int[] gambar_act) {
        this.gambar_act = gambar_act;
    }

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
    }

    @Override
    public int getItemCount() {
        return SubjectValues.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        ViewHolder(View view) {
            super(view);

            imageView = view.findViewById(R.id.item_img_daily);
            textView = view.findViewById(R.id.item_text_daily);

        }

    }
}
