package com.kruglov.coffeshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kruglov.coffeshop.model.Order;

public class PiePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_page);
        ConstraintLayout piePageBg = findViewById(R.id.piePageBg);
        ImageView piePageImage = findViewById(R.id.piePageImage);
        TextView piePageTitle = findViewById(R.id.piePageTitle);
        TextView piePagePrice = findViewById(R.id.piePagePrice);
        TextView piePageOpis = findViewById(R.id.piePageOpis);
        TextView piePageType = findViewById(R.id.piePageType);
        piePageBg.setBackgroundColor(getIntent().getIntExtra("piePageBg",0));
        piePageImage.setImageResource(getIntent().getIntExtra("piePageImg",0));
        piePageTitle.setText(getIntent().getStringExtra("piePageTitle"));
        piePagePrice.setText(getIntent().getStringExtra("piePagePrice"));
        piePageOpis.setText(getIntent().getStringExtra("piePageOpis"));
        piePageType.setText(getIntent().getStringExtra("piePageType"));
    }
    public void addToCard(View view){
        int item_id = getIntent().getIntExtra("piePageId",0);
        String item_title = getIntent().getStringExtra("piePageTitle" + "piePagePrice");
        Order.items_id.add(item_id);
        Order.items_name.add(item_title);
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