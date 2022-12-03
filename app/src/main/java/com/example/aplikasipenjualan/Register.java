package com.example.aplikasipenjualan;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aplikasipenjualan.databinding.ActivityRegisterBinding;
import com.google.android.material.textfield.TextInputLayout;

public class Register extends AppCompatActivity {

    ActivityRegisterBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRegisterBinding.inflate(getLayoutInflater());


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

                if(binding.password.getText().toString().length() <= 5 ) {

                    Toast.makeText(getApplicationContext(), "Enter password first", Toast.LENGTH_SHORT);
                    binding.password.requestFocus();

                } else {

                    if(binding.password.getText().toString().equals(binding.confirmPassword.getText().toString())) {
                        binding.confirmHelp.setText(getResources().getString(R.string.password_match));
                        binding.confirmHelp.setTextColor(getResources().getColor(R.color.teal_700));
                    }

                }
            }
        });

        setContentView(binding.getRoot());

    }
}
