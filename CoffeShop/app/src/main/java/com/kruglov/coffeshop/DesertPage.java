package com.kruglov.coffeshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.kruglov.coffeshop.model.Order;

public class DesertPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desert_page);
        ConstraintLayout desertPageBg = findViewById(R.id.desertPageBg);
        ImageView desertPageImage = findViewById(R.id.desertPageImage);
        TextView desertPageTitle = findViewById(R.id.desertPageTitle);
        TextView desertPagePrice = findViewById(R.id.desertPagePrice);
        TextView desertPageOpis = findViewById(R.id.desertPageOpis);
        TextView desertPageType = findViewById(R.id.desertPageType);
        desertPageBg.setBackgroundColor(getIntent().getIntExtra("desertPageBg",0));
        desertPageImage.setImageResource(getIntent().getIntExtra("desertPageImg",0));
        desertPageTitle.setText(getIntent().getStringExtra("desertPageTitle"));
        desertPagePrice.setText(getIntent().getStringExtra("desertPagePrice"));
        desertPageOpis.setText(getIntent().getStringExtra("desertPageOpis"));
        desertPageType.setText(getIntent().getStringExtra("desertPageType"));

    }
    public void addToCard(View view){
        int item_id = getIntent().getIntExtra("desertPageId",0);
        String item_title = getIntent().getStringExtra("desertPageTitle" + "desertPagePrice");
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