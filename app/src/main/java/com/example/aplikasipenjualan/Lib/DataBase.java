package com.example.aplikasipenjualan.Lib;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.aplikasipenjualan.ObjectModel.Product;
import com.example.aplikasipenjualan.ObjectModel.ProductDao;
import com.example.aplikasipenjualan.ObjectModel.User;
import com.example.aplikasipenjualan.ObjectModel.UserDao;

@Database(entities = {User.class, Product.class}, version = 1)
public abstract class DataBase extends RoomDatabase {

    public abstract UserDao userDao();
    public abstract ProductDao productDao();

    /**
     * METODE SEKALI PANGGIL AUTO BUILD ;)
     */
    public static DataBase getInstance(Context ctx) {
         return Room.databaseBuilder(ctx,
                DataBase.class, "database").build();
    }
}