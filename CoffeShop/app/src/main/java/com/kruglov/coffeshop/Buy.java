package com.kruglov.coffeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.kruglov.coffeshop.model.Coffe;
import com.kruglov.coffeshop.model.Desert;
import com.kruglov.coffeshop.model.Order;
import com.kruglov.coffeshop.model.Pie;

import java.util.ArrayList;
import java.util.List;

public class Buy extends AppCompatActivity {

    public static int Balls = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        ListView Orders_list = findViewById(R.id.OrderList);
        List<String> id = new ArrayList<>();
        String Title = getIntent().getStringExtra("Title");
        String Price = getIntent().getStringExtra("Price");





//        for(int c : Order.items_id)
//            for(String v : Order.items_name)
//                for(String b : Order.items_price)
//                    title.add(c + "\n Название: " + v + "\n Цена: " + b + " руб");
        //for(Desert c : MainActivity.fullDesertList){
         //   if(Order.items_id.contains(c.getId()))
         //       title.add(c.getTitle() + " " + c.getPrice());
       // }
//        for(Pie c : MainActivity.fullPieList){
//            if(Order.items_id.contains(c.getId()))
//                title.add(c.getTitle() + " " + c.getPrice());
//        }

        Orders_list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,Order.items_name.toArray()));

    }
    public void onKatalog(View view) {
        Intent intent = new Intent(this, Katalog.class);
        startActivity(intent);
    }
    public void onOrder(View view) {
        Intent intent = new Intent(this, Buy.class);
        startActivity(intent);
    }
    public void onMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void Clear(View view){
        ListView listView = findViewById(R.id.OrderList);

        listView.setAdapter(null);
    }
}