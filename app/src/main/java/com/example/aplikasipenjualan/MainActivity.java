package com.example.aplikasipenjualan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.aplikasipenjualan.Lib.AppDatabase;
import com.example.aplikasipenjualan.Lib.UserDataRepository;
import com.example.aplikasipenjualan.ObjectModel.User;
import com.example.aplikasipenjualan.databinding.ActivityMainBinding;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import kotlin.Result;
import kotlin.jvm.Throws;

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

        try {

            binding.login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String email = binding.email.getText().toString(),
                            pass = binding.password.getText().toString();
                    if (email.length() <= 5) {
                        Toast.makeText(getApplicationContext(), "Please enter email address", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (pass.length() <= 5) {
                        Toast.makeText(getApplicationContext(),
                                "Please enter password",
                                Toast.LENGTH_SHORT).show();
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

    private void LoginHandler(String email, String password) {

        try {

            UserDataRepository repository = new UserDataRepository(getApplicationContext());
            User user = repository.getByEmail(email);

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

        } catch (Exception e) {

            e.printStackTrace();
        }

    }
}