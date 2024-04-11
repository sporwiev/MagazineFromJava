package com.kruglov.coffeshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import com.kruglov.coffeshop.adapter.categoryAdapter.CategoryCoffeAdapter;
import com.kruglov.coffeshop.model.CategoryModel.CategoryCoffeModel;
import com.kruglov.coffeshop.model.Order;

import java.util.ArrayList;
import java.util.List;

public class CategoryCoffe extends AppCompatActivity {
    RecyclerView categoryCoffeRecycler;
    CategoryCoffeAdapter categoryCoffeAdapter;
    String[] titleCoffe = {"Соблазнительная крошка\n","Вершина Айсберга\n","Лакомый кусочек\n","Карликовая звезда\n","Бомбический латте\n","Английская прелесть\n","Массовое заблуждение\n","Торговая монархия\n","Альпийский дождь\n","Вечернее настроение\n","Поцелуй вампира\n","Пылающий вулкан\n","Бора-бора\n","Клубничная радость\n"};
    String[] Price = {"150","200 руб","250 руб","300 руб","350 руб","400 руб","450 руб","230 руб","170 руб","180 руб","100 руб","150 руб"};
    String[] sell = {"10%","20%","21%","19%","16%","12%","13%","14%","11%","17%"};
    static List<CategoryCoffeModel> fullCategoryCoffeList = new ArrayList<CategoryCoffeModel>();
    public static int Generated() {
        return (int) (Math.random() * 10);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_coffe);

        List<CategoryCoffeModel> coffes = new ArrayList<>();



        coffes.add(new CategoryCoffeModel(1, "coffe", titleCoffe[Generated()], "#CD5C5C", Price[Generated()], "Латте с мраморным рисунком из шоколада", "Банановое", "300 мл", sell[Generated()]));
        coffes.add(new CategoryCoffeModel(2, "coffe", titleCoffe[Generated()], "#CD5C5C", Price[Generated()], "Латте с мраморным рисунком из шоколада", "Банановое", "300 мл", sell[Generated()]));
        coffes.add(new CategoryCoffeModel(3, "coffe", titleCoffe[Generated()], "#CD5C5C", Price[Generated()], "Латте с мраморным рисунком из шоколада", "Банановое", "300 мл", sell[Generated()]));
        coffes.add(new CategoryCoffeModel(4, "coffe", titleCoffe[Generated()], "#CD5C5C", Price[Generated()], "Латте с мраморным рисунком из шоколада", "Банановое", "300 мл", sell[Generated()]));
        coffes.add(new CategoryCoffeModel(5, "coffe", titleCoffe[Generated()], "#CD5C5C", Price[Generated()], "Латте с мраморным рисунком из шоколада", "Банановое", "300 мл", sell[Generated()]));
        fullCategoryCoffeList.addAll(coffes);
        setCoffeRecycler(coffes);
    }
    private void setCoffeRecycler(List<CategoryCoffeModel> coffes) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        categoryCoffeRecycler = findViewById(R.id.CategoryCoffeRecycler);
        categoryCoffeRecycler.setLayoutManager(layoutManager);

        categoryCoffeAdapter = new CategoryCoffeAdapter(coffes,this);
        categoryCoffeRecycler.setAdapter(categoryCoffeAdapter);
    }
    public void addToCard(View view){

        int item_id = getIntent().getIntExtra("CoffePageId",0);
        String  item_title = getIntent().getStringExtra("CoffePageTitle" + "CoffePagePrice");
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