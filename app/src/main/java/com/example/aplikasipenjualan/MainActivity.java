package com.example.aplikasipenjualan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.aplikasipenjualan.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rBarang;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Barang> listBarang;

    void dataDummy() {
        listBarang = new ArrayList<>();
        listBarang.add(new Barang("Spidol", "Non-permanent Marker", "6000", R.drawable.spidol));
        listBarang.add(new Barang("Penggaris", "Penggaris Besi 30cm", "5000", R.drawable.penggaris));
        listBarang.add(new Barang("Tipe-X", "Correction Pen Kenko", "3500", R.drawable.tipex));
    }
    void data(){
        rBarang = findViewById(R.id.reMenu);
        adapter = new Adapter (this,listBarang);
        layoutManager = new LinearLayoutManager(this);
        rBarang.setLayoutManager(layoutManager);
        rBarang.setAdapter(adapter);
    }


    /**
     * _README_
     *  - this code are using view binding
     *  - kode ini menggunakan view binding
     */
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataDummy();data();


        binding = ActivityMainBinding.inflate(getLayoutInflater());

        binding.createAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), Register.class);
                startActivity(i);
            }
        });

        setContentView(binding.getRoot());
    }
}