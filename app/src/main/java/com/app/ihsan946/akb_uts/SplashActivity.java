package com.app.ihsan946.akb_uts;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.app.ihsan946.Database.databaseku;
import com.app.ihsan946.Database.profileEntity;
import com.app.ihsan946.model.modelDaily;

import java.util.ArrayList;
import java.util.List;


public class SplashActivity extends AppCompatActivity {

    public static databaseku db;
    @RequiresApi(api = Build.VERSION_CODES.P)
    @SuppressLint("ResourceAsColor")


    //database
    private profileEntity profileEntitas;

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //implementasi database
        List<profileEntity> profileEntity = new ArrayList<>();

        db = Room.databaseBuilder(this, databaseku.class, "profile").allowMainThreadQueries().build();


//        tambah data
//        profileEntitas = new profileEntity();
//        profileEntitas.setNama("Muhammad Ihsan");
//        profileEntitas.setTempatLahir("Bandung");
//        profileEntitas.setUmur("21");
//
//        Log.d("TAMBAH","Tambah Data profile");
//        Log.d("TAMBAH","===================");
//        Log.d("TAMBAH","Nama : "+profileEntitas.getNama());
//        Log.d("TAMBAH","Tempat Lahir : "+profileEntitas.getTempatLahir());
//        Log.d("TAMBAH","Zona : "+profileEntitas.getUmur());
//
//        db.profileDao().tambahdataProfile(profileEntitas);

        profileEntity profileEntitas;


        //database
        //TAMPIL SELURUH DATA
        Log.d("TAMPIL", "Tampil seluruh data profile");
        Log.d("TAMPIL", "===========================");

        profileEntity = db.profileDao().tampilSeluruhprofile();

        for (int i = 0; i < profileEntity.size(); i++) {

            Log.d("TAMPIL", "Data Ke-" + (i + 1));
            Log.d("TAMPIL", "Nama : " + profileEntity.get(i).getNama());
            Log.d("TAMPIL", "Tempat Lahir : " + profileEntity.get(i).getTempatLahir());
            Log.d("TAMPIL", "Umur : " + profileEntity.get(i).getUmur());
            Log.d("TAMPIL", "========================");
        }

        modelDaily model = new modelDaily();
        model.setNama_profile(profileEntity.get(0).getNama());


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, ViewPageActivity.class);
                startActivity(intent);
                finish();
            }

        }, 4000);

    }


}