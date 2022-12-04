package com.example.aplikasipenjualan.Lib;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.aplikasipenjualan.ObjectModel.Product;
import com.example.aplikasipenjualan.ObjectModel.ProductDao;
import com.example.aplikasipenjualan.ObjectModel.User;
import com.example.aplikasipenjualan.ObjectModel.UserDao;

@androidx.room.Database(entities = {User.class, Product.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();
    public abstract ProductDao productDao();

    /**
     * METODE SEKALI PANGGIL AUTO BUILD ;)
     */
    private static AppDatabase INSTANCE;

    public static AppDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class,
                                    "database").build();
                }
            }
        }
        return INSTANCE;
    }
}