package com.app.ihsan946.adapter;

//NIM : 10118037
//Nama : Muhammad Ihsan
//Kelas : IF-1/2018
//Tanggal Pembuatan : 24 Mei 2021
//
//

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.ihsan946.akb_uts.R;

public class AdapterVideo extends RecyclerView.Adapter<AdapterVideo.ViewHolder> {
    private final Context context;
    private final String[] uri;
    private final String[] judul_video;


    public AdapterVideo(Context context, String[] uri, String[] judul_video) {
        this.context = context;
        this.uri = uri;
        this.judul_video = judul_video;
    }

    @NonNull
    @Override
    public AdapterVideo.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_video, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterVideo.ViewHolder holder, int position) {
        holder.videoView.setVideoURI(Uri.parse(uri[position]));

        MediaController mc = new MediaController(context);
        mc.setAnchorView(holder.videoView);
        mc.setMediaPlayer(holder.videoView);
        holder.videoView.setMediaController(mc);
        holder.textView.setText(judul_video[position]);
    }

    @Override
    public int getItemCount() {
        return uri.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        VideoView videoView;
        TextView textView;

        ViewHolder(View view) {
            super(view);
            videoView = view.findViewById(R.id.videoview1);
            textView = view.findViewById(R.id.judul_video);


        }

    }
}
