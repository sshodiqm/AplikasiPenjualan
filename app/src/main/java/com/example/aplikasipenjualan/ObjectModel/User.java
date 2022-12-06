package com.example.aplikasipenjualan.ObjectModel;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "user_name")
    public String userName;

    @ColumnInfo(name="email")
    public String email;

    @ColumnInfo(name="password")
    public String password;

    @ColumnInfo(name="full_name")
    public String fullName;

    @ColumnInfo(name="type")
    public int type;
}
