package com.example.aplikasipenjualan;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aplikasipenjualan.Lib.AppDatabase;
import com.example.aplikasipenjualan.ObjectModel.User;
import com.example.aplikasipenjualan.databinding.ActivityRegisterBinding;

public class Register extends AppCompatActivity {

    ActivityRegisterBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {


            binding = ActivityRegisterBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());

            binding.password.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {

                    binding.confirmPassword.setText("");

                    binding.confirmHelp.setText(getResources().getString(R.string.password_not_match));
                    binding.confirmHelp.setTextColor(getResources().getColor(R.color.red));
                }
            });

            binding.confirmPassword.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {

                    binding.confirmHelp.setText(getResources().getString(R.string.password_not_match));
                    binding.confirmHelp.setTextColor(getResources().getColor(R.color.red));

                    if (binding.password.getText().toString().length() <= 5) {

                        Toast.makeText(getApplicationContext(), "Enter password first", Toast.LENGTH_SHORT);
                        binding.password.requestFocus();

                    } else {

                        if (binding.password.getText().toString().equals(binding.confirmPassword.getText().toString())) {
                            binding.confirmHelp.setText(getResources().getString(R.string.password_match));
                            binding.confirmHelp.setTextColor(getResources().getColor(R.color.teal_700));
                        }

                    }
                }
            });

            binding.register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (binding.email.getText().toString().length() <= 5) {
                        Toast.makeText(getApplicationContext(),
                                "Email address must contain > 5 character",
                                Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (binding.password.getText().toString().length() <= 5) {
                        Toast.makeText(getApplicationContext(),
                                "Password min contain > 5 random character",
                                Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (!binding.password.getText().toString().equals(binding.confirmPassword.getText().toString())) {
                        Toast.makeText(getApplicationContext(),
                                "Please confirm you password",
                                Toast.LENGTH_SHORT).show();
                        return;
                    }

                    try {
                        createAccount(binding.email.getText().toString(), binding.password.getText().toString());
                    } catch (InterruptedException e) {

                        e.printStackTrace();

                    }

                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createAccount(String email, String password) throws InterruptedException {

        User newUser = new User();
        newUser.email = email;
        newUser.password = password;

        final Thread t = new Thread() {

            @Override
            public void run() {

                AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
                appDatabase.userDao().insertAll(newUser);
            }
        };
        t.start();

        Toast.makeText(getApplicationContext(),
                "Account successful create !!",
                Toast.LENGTH_LONG).show();

        Register.this.finish();

    }
}
