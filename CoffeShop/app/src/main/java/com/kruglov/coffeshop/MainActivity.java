package com.kruglov.coffeshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.kruglov.coffeshop.R;
import com.kruglov.coffeshop.adapter.CoffeAdapter;
import com.kruglov.coffeshop.adapter.DesertAdapter;
import com.kruglov.coffeshop.adapter.PieAdapter;
import com.kruglov.coffeshop.model.Coffe;
import com.kruglov.coffeshop.model.Desert;
import com.kruglov.coffeshop.model.Pie;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Dialog dialog;
    RecyclerView desertRecycler,pieRecycler,coffeRecycler;
    DesertAdapter desertAdapter;
    PieAdapter pieAdapter;
    DBHelper dbHelper;
    String selection;
    String[] selectionargs = null;
    String[] titleCofee = {"Соблазнительная крошка\n","Вершина Айсберга\n","Лакомый кусочек\n","Карликовая звезда\n","Бомбический латте\n","Английская прелесть\n","Массовое заблуждение\n","Торговая монархия\n","Альпийский дождь\n","Вечернее настроение\n","Поцелуй вампира\n","Пылающий вулкан\n","Бора-бора\n","Клубничная радость\n"};

    String[] titlePie = {"Золотая корочка\n","Ппирожек с любовью\n","Альпийская нежность\n","Бриллиант с корицей\n","Алгоритм программиста\n","Мамены причуды\n","Ленинградский\n","Гармония индейца\n","Черная пантера\n","Лауреат гения\n","Подснежник\n","Дикий карнавал\n"};
    String[] Nachinka = {"Клюква","Яблоко с корицей","Курица с белыми грибами","Творог","Апельсин","Лимон","Картошка","Капуста","Капуста с яйцом","Груша","Вишня с корицей","Черная смородина","Красная смородина","Сыр","Ветчина и сыр","Говядина","Свинина","Курица","Изюм","Красная рыба"};
   String[] Price = {"150","200 руб","250 руб","300 руб","350 руб","400 руб","450 руб","230 руб","170 руб","180 руб","100 руб","150 руб"};

   String[] milk = {"Парное","Миндально","Банановое","Соевое","Кокосовое","Рисовое","Овсяное","Маковое","Парное","Миндально","Банановое","Соевое","Кокосовое","Рисовое","Овсяное","Маковое"};
    String[] sell = {"10%","20%","21%","19%","16%","12%","13%","14%","11%","17%"};
    static List<Desert> fullDesertList = new ArrayList<>();
    static List<Coffe> fullCoffesList = new ArrayList<>();
    static List<Pie> fullPieList = new ArrayList<>();
    CoffeAdapter coffeAdapter;
    ImageView image;
    public static int Generated() {
       return (int) (Math.random() * 10);
    }



    @SuppressLint("MissingInflatedId")
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);

        List<Desert> deserts = new ArrayList<>();

        deserts.add(new Desert(1,"ice_cream",Price[Generated()],titleCofee[Generated()],"Ванильное мороженное в пряном\n шоколаде с корицей.\n Состав: молоко обезжиренное, сливки натуальные, корица молотая, ваниль, шоколад","#DEB887","Мороженное",sell[Generated()]));
        deserts.add(new Desert(2,"ice_cream",Price[Generated()],titleCofee[Generated()],"Клубничное мороженное в золотистом\n шоколаде с ванилью Состав: молоко обезжиренное, сливки натуальные, корица молотая, ваниль, шоколад","#DEB887","Мороженное",sell[Generated()]));
        deserts.add(new Desert(3,"ice_cream",Price[Generated()],titleCofee[Generated()],"Сливочное мороженное с бананами в\n облитом шоколаде Состав: молоко обезжиренное, сливки натуальные, корица молотая, ваниль, шоколад","#DEB887","Мороженное",sell[Generated()]));
        deserts.add(new Desert(4,"ice_cream",Price[Generated()],titleCofee[Generated()],"Ванильное мороженное в космическом\n шоколаде со звездочками Состав: молоко обезжиренное, сливки натуальные, корица молотая, ваниль, шоколад","#DEB887","Мороженное",sell[Generated()]));
        fullDesertList.addAll(deserts);
        setDesertRecycler(deserts);

        List<Pie> pies = new ArrayList<>();
        pies.add(new Pie(1,"buton","#FFA07A",Nachinka[Generated()],"золотистая булочка с бананом",titlePie[Generated()], Price[Generated()],sell[Generated()]));
        pies.add(new Pie(2,"buton","#FFA07A",Nachinka[Generated()],"Лакомая булочка с кубникой",titlePie[Generated()],Price[Generated()],sell[Generated()]));
        pies.add(new Pie(3,"buton","#FFA07A",Nachinka[Generated()],"золотистая булочка с бананом",titlePie[Generated()],Price[Generated()],sell[Generated()]));
        pies.add(new Pie(4,"buton","#FFA07A",Nachinka[Generated()],"золотистая булочка с бананом",titlePie[Generated()],Price[Generated()],sell[Generated()]));
        pies.add(new Pie(5,"buton","#FFA07A",Nachinka[Generated()],"золотистая булочка с бананом",titlePie[Generated()],Price[Generated()],sell[Generated()]));
        pies.add(new Pie(6,"buton","#FFA07A",Nachinka[Generated()],"золотистая булочка с бананом",titlePie[Generated()],Price[Generated()],sell[Generated()]));
        fullPieList.addAll(pies);
        setPieRecycler(pies);

        List<Coffe> coffes = new ArrayList<>();
        coffes.add(new Coffe(1,"coffe",titleCofee[Generated()],"#CD5C5C",Price[Generated()],"Латте с мраморным рисунком из шоколада",milk[Generated()],"300 мл",sell[Generated()]));
        coffes.add(new Coffe(2,"coffe",titleCofee[Generated()],"#CD5C5C",Price[Generated()],"Латте с мраморным рисунком из шоколада",milk[Generated()],"300 мл",sell[Generated()]));
        coffes.add(new Coffe(3,"coffe",titleCofee[Generated()],"#CD5C5C",Price[Generated()],"Латте с мраморным рисунком из шоколада",milk[Generated()],"300 мл",sell[Generated()]));
        coffes.add(new Coffe(4,"coffe",titleCofee[Generated()],"#CD5C5C",Price[Generated()],"Латте с мраморным рисунком из шоколада",milk[Generated()],"300 мл",sell[Generated()]));
        coffes.add(new Coffe(5,"coffe",titleCofee[Generated()],"#CD5C5C",Price[Generated()],"Латте с мраморным рисунком из шоколада",milk[Generated()],"300 мл",sell[Generated()]));
        fullCoffesList.addAll(coffes);
        setCoffeRecycler(coffes);
    }

    private void setPieRecycler(List<Pie> pies) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        pieRecycler = findViewById(R.id.PieRecycler);
        pieRecycler.setLayoutManager(layoutManager);

        pieAdapter = new PieAdapter(pies,this);
        pieRecycler.setAdapter(pieAdapter);
    }

    private void setDesertRecycler(List<Desert> deserts) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        desertRecycler = findViewById(R.id.DesertRecycler);
        desertRecycler.setLayoutManager(layoutManager);

       desertAdapter = new DesertAdapter(this, deserts);
       desertRecycler.setAdapter(desertAdapter);
    }
    private void setCoffeRecycler(List<Coffe> coffes) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        coffeRecycler = findViewById(R.id.CoffeRecycler);
       coffeRecycler.setLayoutManager(layoutManager);

        coffeAdapter = new CoffeAdapter(coffes,this);
        coffeRecycler.setAdapter(coffeAdapter);
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
    public void onRegister(View view){
//        dbHelper = new DBHelper(this);
//  //      SQLiteDatabase database = dbHelper.getWritableDatabase();
//        Cursor cursor;
//        selection = "login = ?";
//    //    selectionargs = new String[]{LoginProf.getText().toString()};
//     //   Log.d("Enter", LoginProf.getText().toString());
//      //  cursor = database.query("user", null, selection, selectionargs, null, null, null, null);
//        if (cursor != null) {
//            if (cursor.moveToFirst()) {
//                String str;
//                do {
//                    str = "";
//                    for (String cn : cursor.getColumnNames()) {
//                        if (i == 5) {
//                            Code.setText(cursor.getString(cursor.getColumnIndex(cn)));
//                            continue;
//                        }
//                        i++;
//                    }
//                    Log.d("Enter", str);
//                } while (cursor.moveToNext());
//                Log.d("Enter", str);
//            }
//
//
//        }
//        cursor.close();
        if(Register.regist == true){
            Intent intent = new Intent(this,Profile.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(this,Register.class);
            startActivity(intent);
        }
    }
}