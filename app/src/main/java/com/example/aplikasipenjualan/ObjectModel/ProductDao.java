package com.example.aplikasipenjualan.ObjectModel;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProductDao {
    @Query("SELECT * FROM product")
    List<Product> getAll();

    @Query("UPDATE product SET title=:title, description=:description, path_image=:pathImage, date_stamp=:dateStamp WHERE id=:id")
    void update(String title, String description, String pathImage, String dateStamp, int id);

    @Insert
    void insertAll(Product... products);

    @Delete
    void delete(Product product);
}
