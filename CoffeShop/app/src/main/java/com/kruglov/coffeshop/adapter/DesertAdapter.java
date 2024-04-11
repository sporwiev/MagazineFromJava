package com.kruglov.coffeshop.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kruglov.coffeshop.DesertPage;
import com.kruglov.coffeshop.R;
import com.kruglov.coffeshop.model.Desert;

import java.util.List;

public class DesertAdapter extends RecyclerView.Adapter<DesertAdapter.DesertViewHolder> {

    List<Desert> deserts;

    public DesertAdapter(Context context, List<Desert> deserts) {
        this.deserts = deserts;
        this.context = context;
    }

    Context context;
    @NonNull
    @Override
    public DesertViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View desertitem = LayoutInflater.from(context).inflate(R.layout.desert_item,parent,false);
        return new DesertViewHolder(desertitem);
    }

    @Override
    public void onBindViewHolder(@NonNull DesertViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.desertBg.setBackgroundColor(Color.parseColor(deserts.get(position).getColor()));
        int ImageId =context.getResources().getIdentifier(deserts.get(position).getImg(),"drawable",context.getPackageName());
        holder.desertImage.setImageResource(ImageId);
        holder.title.setText(deserts.get(position).getTitle());
        holder.price.setText(deserts.get(position).getPrice());
        holder.sell.setText(deserts.get(position).getSell());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DesertPage.class);
                intent.putExtra("desertPageBg",Color.parseColor(deserts.get(position).getColor()));
                intent.putExtra("desertPageImg",ImageId);
                intent.putExtra("desertPageTitle",deserts.get(position).getTitle());
                intent.putExtra("desertPagePrice",deserts.get(position).getPrice());
                intent.putExtra("desertPageOpis",deserts.get(position).getOpis());
                intent.putExtra("desertPageType",deserts.get(position).getType());
                intent.putExtra("desertPageId",deserts.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return deserts.size();
    }
    public static final class DesertViewHolder extends RecyclerView.ViewHolder{

        LinearLayout desertBg;
        ImageView desertImage;
        TextView title,price,sell;
        public DesertViewHolder(@NonNull View itemView) {
            super(itemView);
desertBg = itemView.findViewById(R.id.desertBg);
desertImage = itemView.findViewById(R.id.desertImage);
title = itemView.findViewById(R.id.desertTitle);
price = itemView.findViewById(R.id.desertSell);
sell = itemView.findViewById(R.id.desertPriceSell);

        }
    }
}
