package com.example.aplikasipenjualan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class holder extends RecyclerView.ViewHolder{
    ImageView img;
    TextView txtname, txtDesc, txtprice;

    public holder(@NonNull View itemView) {
        super(itemView);

        img = itemView.findViewById(R.id.imgBarang);
        txtname = itemView.findViewById(R.id.txtname);
        txtDesc = itemView.findViewById(R.id.txtdesc);
        txtprice = itemView.findViewById(R.id.txtprice);
    }
}

public class Adapter extends RecyclerView.Adapter<holder> {
    Context context;
    ArrayList<Barang> listBarang;

    public Adapter(Context context, ArrayList<Barang> listBarang) {
        this.context = context;
        this.listBarang = listBarang;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent, false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        Barang barang = listBarang.get(position);
        holder.img.setImageResource(barang.getImage());
        holder.txtname.setText(barang.getNama());
        holder.txtDesc.setText(barang.getDescription());
        holder.txtprice.setText(""+barang.getPrice());
    }

    @Override
    public int getItemCount() {
        return listBarang.size();
    }
}
