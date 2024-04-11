package com.kruglov.coffeshop;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.view.menu.MenuView;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.kruglov.coffeshop.model.Order;

import java.util.ArrayList;
import java.util.List;

public class CoffePage extends AppCompatActivity {
    public static String priceBye;
    public static String TitleBye;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffe_page);
        ConstraintLayout coffePageBg = findViewById(R.id.coffePageBg);
        ImageView coffePageImage = findViewById(R.id.coffePageImage);
        TextView coffePageTitle = findViewById(R.id.coffePageTitle);
        TextView coffePagePrice = findViewById(R.id.coffePagePrice);
        TextView coffePageOpis = findViewById(R.id.coffePageOpis);
        TextView coffePageMilk = findViewById(R.id.coffePageMilk);
        coffePageBg.setBackgroundColor(getIntent().getIntExtra("CoffePageBg",0));
        coffePageImage.setImageResource(getIntent().getIntExtra("CoffePageImg",0));
        coffePageTitle.setText(getIntent().getStringExtra("CoffePageTitle"));
        coffePagePrice.setText(getIntent().getStringExtra("CoffePagePrice"));
        coffePageOpis.setText(getIntent().getStringExtra("CoffePageOpis"));
        coffePageMilk.setText(getIntent().getStringExtra("CoffePageMilk"));
        String Title;
        Order.items_name.add(coffePageTitle.toString());
        Intent intent = new Intent(this,CoffePage.class);
        intent.putExtra("Title",coffePageTitle.getText().toString());
        intent.putExtra("Price",coffePagePrice.getText().toString());
        Toast.makeText(this,coffePageTitle.getText().toString(),Toast.LENGTH_LONG).show();

    }
    public void addToCard(View view){


        int item_id = getIntent().getIntExtra("CoffePageId",0);
        String item_name = getIntent().getStringExtra("Title");
        String item_price = getIntent().getStringExtra("Price");
        Order.items_id.add(item_id);

        Order.items_price.add(item_price);
        Toast.makeText(this,"Добавлено",Toast.LENGTH_LONG).show();
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
}