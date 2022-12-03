package com.example.aplikasipenjualan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.aplikasipenjualan.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    /**
     * _README_
     *  - this code are using view binding
     *  - kode ini menggunakan view binding
     */
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
    }
}