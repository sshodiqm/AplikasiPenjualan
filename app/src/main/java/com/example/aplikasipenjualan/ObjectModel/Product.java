package com.example.aplikasipenjualan.ObjectModel;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "product")
public class Product {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name="title")
    public String title;

    @ColumnInfo(name="description")
    public String description;

    @ColumnInfo(name="path_image")
    public String pathImage;

    @ColumnInfo(name="date_stamp")
    public String dateStamp;
}
