package com.app.ihsan946.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {profileEntity.class}, version = 1)
public abstract class databaseku extends RoomDatabase {

    public abstract profileDAO profileDao();
}
