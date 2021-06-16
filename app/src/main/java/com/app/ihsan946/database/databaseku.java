package com.app.ihsan946.database;

//NIM : 10118037
//Nama : Muhammad Ihsan
//Kelas : IF-1/2018
//Tanggal Pembuatan : 25 Mei 2021
//
//

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {profileEntity.class}, version = 1)
public abstract class databaseku extends RoomDatabase {
    public abstract profileDAO profileDao();
}
