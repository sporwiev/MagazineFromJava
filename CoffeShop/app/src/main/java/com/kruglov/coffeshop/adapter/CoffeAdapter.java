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

import com.kruglov.coffeshop.CoffePage;
import com.kruglov.coffeshop.PiePage;
import com.kruglov.coffeshop.R;
import com.kruglov.coffeshop.model.Coffe;

import java.util.List;

public class CoffeAdapter extends RecyclerView.Adapter<CoffeAdapter.CoffeViewHolder> {

    public CoffeAdapter(List<Coffe> coffes, Context context) {
        this.coffes = coffes;
        this.context = context;
    }

    List<Coffe> coffes;
    Context context;
    @NonNull
    @Override
    public CoffeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View coffeitem = LayoutInflater.from(context).inflate(R.layout.coffe_item,parent,false);
        return new CoffeAdapter.CoffeViewHolder(coffeitem);
    }

    @Override
    public void onBindViewHolder(@NonNull CoffeViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.coffeBg.setBackgroundColor(Color.parseColor(coffes.get(position).getColor()));
        int ImageId = context.getResources().getIdentifier(coffes.get(position).getImg(),"drawable",context.getPackageName());
        holder.coffeImage.setImageResource(ImageId);
        holder.title.setText(coffes.get(position).getTitle());
        holder.price.setText(coffes.get(position).getPrice());
        holder.sell.setText(coffes.get(position).getSell());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CoffePage.class);
                intent.putExtra("CoffePageBg",Color.parseColor(coffes.get(position).getColor()));
                intent.putExtra("CoffePageImg",ImageId);
                intent.putExtra("CoffePageTitle",coffes.get(position).getTitle());
                intent.putExtra("CoffePagePrice",coffes.get(position).getPrice());
                intent.putExtra("CoffePageOpis",coffes.get(position).getOpis());
                intent.putExtra("CoffePageId",coffes.get(position).getId());
                intent.putExtra("CoffePageMilk",coffes.get(position).getMilk());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return coffes.size();
    }
    public static final class CoffeViewHolder extends RecyclerView.ViewHolder{

        LinearLayout coffeBg;
        ImageView coffeImage;
        TextView title,price,sell,milk;
        public CoffeViewHolder(@NonNull View itemView) {
            super(itemView);
            coffeBg = itemView.findViewById(R.id.coffeBg);
            title = itemView.findViewById(R.id.coffeTitle);
            price = itemView.findViewById(R.id.coffePriceSell);
            sell = itemView.findViewById(R.id.coffeSell);
            coffeImage = itemView.findViewById(R.id.coffeImage);

        }
    }
}
