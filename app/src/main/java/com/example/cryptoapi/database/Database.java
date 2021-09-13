package com.example.cryptoapi.database;
import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = Entity.class, exportSchema = false, version = 1)
public abstract class Database extends RoomDatabase {
    private static Database instance;
    public static synchronized Database getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), Database.class, "cry_db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public abstract Dao dao();

}
