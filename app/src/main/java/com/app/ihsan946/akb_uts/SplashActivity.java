package com.app.ihsan946.akb_uts;

//NIM : 10118037
//Nama : Muhammad Ihsan
//Kelas : IF-1/2018
//Tanggal Pembuatan : 24 Mei 2021
//
//

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


public class SplashActivity extends AppCompatActivity {

//    public static databaseku db;
@RequiresApi(api = Build.VERSION_CODES.P)
@SuppressLint("ResourceAsColor")


//    //database
//    private profileEntity profileEntitas;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);

//        //implementasi database
//        List<profileEntity> profileEntity = new ArrayList<>();
//
//        db = Room.databaseBuilder(this, databaseku.class, "profile").allowMainThreadQueries().build();
//

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

//        profileEntity profileEntitas;
//
//
//        //database
//        //TAMPIL SELURUH DATA
//        Log.d("TAMPIL", "Tampil seluruh data profile");
//        Log.d("TAMPIL", "===========================");
//
//        profileEntity = db.profileDao().tampilSeluruhprofile();
//
//        for (int i = 0; i < profileEntity.size(); i++) {
//
//            Log.d("TAMPIL", "Data Ke-" + (i + 1));
//            Log.d("TAMPIL", "Nama : " + profileEntity.get(i).getNama());
//            Log.d("TAMPIL", "Tempat Lahir : " + profileEntity.get(i).getTempatLahir());
//            Log.d("TAMPIL", "Umur : " + profileEntity.get(i).getUmur());
//            Log.d("TAMPIL", "========================");
//        }
//
//        modelDaily model = new modelDaily();
//        model.setNama_profile(profileEntity.get(0).getNama());


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