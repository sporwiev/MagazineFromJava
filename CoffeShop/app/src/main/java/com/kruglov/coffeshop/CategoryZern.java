package com.kruglov.coffeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.kruglov.coffeshop.model.Order;

public class CategoryZern extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_zern);
    }
    public void addToCard(View view){
        int item_id = getIntent().getIntExtra("coffePageId",0);
        Order.items_id.add(item_id);
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