package com.kruglov.coffeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Katalog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katalog);
    }
    public void onMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void onKatalog(View view) {
        Intent intent = new Intent(this, Katalog.class);
        startActivity(intent);
    }
    public void onOrder(View view) {
        Intent intent = new Intent(this, Buy.class);
        startActivity(intent);
    }
    public void onCategoryMilk(View view) {
        Intent intent = new Intent(this, CategoryCoffe.class);
        startActivity(intent);
    }
    public void onCategoryHleb(View view) {
        Intent intent = new Intent(this, CategoryHleb.class);
        startActivity(intent);
    }
    public void onCategoryDesert(View view) {
        Intent intent = new Intent(this, CategoryDesert.class);
        startActivity(intent);
    }
    public void onCategoryZern(View view) {
        Intent intent = new Intent(this, CategoryZern.class);
        startActivity(intent);
    }
}