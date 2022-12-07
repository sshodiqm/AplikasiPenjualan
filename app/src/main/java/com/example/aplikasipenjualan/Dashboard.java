package com.example.aplikasipenjualan;

import android.os.Bundle;
import android.widget.ListAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aplikasipenjualan.ObjectModel.Product;
import com.example.aplikasipenjualan.databinding.ActivityDashboardBinding;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity {

    ActivityDashboardBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        ArrayList<Product> listData = new ArrayList<>();

        listData.add(new Product("SPIDOL", "SPIDOL PERMANENT MANTAP", null, null, 2500));
        listData.add(new Product("SPIDOL", "SPIDOL PERMANENT MANTAP", null, null, 2500));
        listData.add(new Product("SPIDOL", "SPIDOL PERMANENT MANTAP", null, null, 2500));
        listData.add(new Product("SPIDOL", "SPIDOL PERMANENT MANTAP", null, null, 2500));
        listData.add(new Product("SPIDOL", "SPIDOL PERMANENT MANTAP", null, null, 2500));


        ListAdapter adapter = new Adapter(getApplicationContext(), listData);
        binding.MyList.setAdapter(adapter);
    }
}
