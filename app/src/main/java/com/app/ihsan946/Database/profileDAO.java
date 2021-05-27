package com.app.ihsan946.Database;

//NIM : 10118037
//Nama : Muhammad Ihsan
//Kelas : IF-1/2018
//Tanggal Pembuatan : 25 Mei 2021
//
//

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface profileDAO {
    @Insert
    void tambahdataProfile(profileEntity profileEntity);

    @Delete
    int hapusdataProfile(profileEntity profileEntity);

    @Query("SELECT * FROM profileEntity")
    List<profileEntity> tampilSeluruhprofile();

}
