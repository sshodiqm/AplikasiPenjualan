package com.example.aplikasipenjualan;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasipenjualan.ObjectModel.Product;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends ArrayAdapter<Product> {

    public Adapter(Context context, ArrayList<Product> products) {
        super(context, 0, products);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Product product = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.xxx, parent, false);
        }
        TextView title = convertView.findViewById(androidx.fragment.R.id.title),
                 description = convertView.findViewById(R.id.description);

        title.setText(product.title);
        description.setText(product.description);

        return convertView;
    }
}
