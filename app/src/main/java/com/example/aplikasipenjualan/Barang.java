package com.example.aplikasipenjualan;

public class Barang {
    private String nama, description;
    private Integer price, image;

    public Barang(String nama, String description, Integer price, Integer image) {
        this.nama = nama;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }
}
