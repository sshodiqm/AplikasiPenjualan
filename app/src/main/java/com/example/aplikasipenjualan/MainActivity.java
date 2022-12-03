package com.example.aplikasipenjualan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.aplikasipenjualan.Lib.DataBase;
import com.example.aplikasipenjualan.ObjectModel.User;
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

        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = binding.email.getText().toString(),
                        pass = binding.password.getText().toString();
                if( email.length() <= 5 ) {
                    return;
                }
                if( pass.length() <= 5 ) {

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

        setContentView(binding.getRoot());
    }

    private void LoginHandler(String email, String password) {

        DataBase DB = DataBase.getInstance(getApplicationContext());
        User find = DB.userDao().findByEmail(email);

        if(find == null) {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.account_not_found), Toast.LENGTH_SHORT).show();
            return;
        }
        if(find.password.equals(password)) {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.password_not_match), Toast.LENGTH_SHORT).show();
            return;
        }

        // LOGIN SUCCESS
    }
}