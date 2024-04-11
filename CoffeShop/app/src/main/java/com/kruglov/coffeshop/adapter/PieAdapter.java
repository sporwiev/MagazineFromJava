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
import com.kruglov.coffeshop.PiePage;
import com.kruglov.coffeshop.R;
import com.kruglov.coffeshop.model.Pie;

import java.util.List;

public class PieAdapter extends RecyclerView.Adapter<PieAdapter.PieViewHolder> {

    List<Pie> pies;

    public PieAdapter(List<Pie> pies, Context context) {
        this.pies = pies;
        this.context = context;
    }

    Context context;
    @NonNull
    @Override
    public PieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View pieitem = LayoutInflater.from(context).inflate(R.layout.pie_item,parent,false);
        return new PieAdapter.PieViewHolder(pieitem);
    }

    @Override
    public void onBindViewHolder(@NonNull PieViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.pieBg.setBackgroundColor(Color.parseColor(pies.get(position).getColor()));
        int ImageId = context.getResources().getIdentifier(pies.get(position).getImg(),"drawable",context.getPackageName());
        holder.pieImage.setImageResource(ImageId);
        holder.title.setText(pies.get(position).getTitle());
        holder.price.setText(pies.get(position).getPrice());
        holder.sell.setText(pies.get(position).getSell());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PiePage.class);
                intent.putExtra("piePageBg",Color.parseColor(pies.get(position).getColor()));
                intent.putExtra("piePageImg",ImageId);
                intent.putExtra("piePageTitle",pies.get(position).getTitle());
                intent.putExtra("piePagePrice",pies.get(position).getPrice());
                intent.putExtra("piePageOpis",pies.get(position).getOpis());
                intent.putExtra("piePageId",pies.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pies.size();
    }
    public static final class PieViewHolder extends RecyclerView.ViewHolder{
        LinearLayout pieBg;
        ImageView pieImage;
        TextView title,price,sell;
        public PieViewHolder(@NonNull View itemView) {
            super(itemView);
            pieBg = itemView.findViewById(R.id.pieBg);
            title = itemView.findViewById(R.id.pieTitle);
            price = itemView.findViewById(R.id.piePriceSell);
            sell = itemView.findViewById(R.id.pieSell);
            pieImage = itemView.findViewById(R.id.pieImage);
        }
    }
}
