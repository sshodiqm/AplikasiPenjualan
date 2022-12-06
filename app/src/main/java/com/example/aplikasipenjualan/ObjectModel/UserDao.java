package com.example.aplikasipenjualan.ObjectModel;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE email = :email")
    User findByEmail(String email);

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);
}
