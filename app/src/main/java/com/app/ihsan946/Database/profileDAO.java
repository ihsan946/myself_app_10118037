package com.app.ihsan946.Database;

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
