package com.example.aplikasipenjualan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.aplikasipenjualan.Lib.AppDatabase;
import com.example.aplikasipenjualan.ObjectModel.User;
import com.example.aplikasipenjualan.databinding.ActivityMainBinding;
import java.io.IOException;
import java.util.ArrayList;

import kotlin.jvm.Throws;

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
        setContentView(binding.getRoot());

        try {

            binding.login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String email = binding.email.getText().toString(),
                            pass = binding.password.getText().toString();
                    if (email.length() <= 5) {
                        return;
                    }
                    if (pass.length() <= 5) {

                        return;
                    }

                    LoginHandler(email, pass);
                }
            });

            binding.createAcc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent i = new Intent(getApplicationContext(), Register.class);
                    startActivity(i);
                }
            });

            binding.lossPwd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(),
                            "Nothing!!", Toast.LENGTH_SHORT).show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    User user;
    private void LoginHandler(String email, String password) {
        Thread t = new Thread() {
            public void run() {

                AppDatabase db = AppDatabase.getInstance(getApplicationContext());
                user = db.userDao().findByEmail(email);
            }
        };
        t.start();

        if(user == null) {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.account_not_found), Toast.LENGTH_SHORT).show();
            return;
        }
        if(! user.password.equals(password)) {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.password_not_match), Toast.LENGTH_SHORT).show();
            return;
        }

        startActivity(new Intent(getApplicationContext(), Dashboard.class));
        MainActivity.this.finish();
    }
}