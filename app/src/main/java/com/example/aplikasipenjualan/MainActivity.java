package com.example.aplikasipenjualan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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