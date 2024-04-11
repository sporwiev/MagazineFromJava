package com.kruglov.coffeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.LoginFilter;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Enter extends AppCompatActivity {
    EditText Login,Password;
    DBHelper dbHelper;
    String selection = null;
    public static String LoginProf;
    public static String PasswordProf;
    String[] selectionArgs = null;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
        Login = (EditText) findViewById(R.id.LoginEn);
        Password = (EditText) findViewById(R.id.PasswordEn);
        dbHelper = new DBHelper(this);

    }
    @SuppressLint("Range")
    public void Enterer(View view){
        int i = 0;
        String login = Login.getText().toString();
        String password = Password.getText().toString();
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        Cursor cursor;
        String Name = "";
        selection = "login = ? AND password = ?";
        selectionArgs = new String[] { login,password };
        cursor = database.query("user", null, selection, selectionArgs, null, null, null, null);
        if(cursor != null){

           if(cursor.moveToFirst()){
               Toast.makeText(this,"Добро пожаловать",Toast.LENGTH_LONG).show();
               Register.regist = true;
               String str;
                do {

                    str = "";
                    for(String cn : cursor.getColumnNames()) {
                        if (i == 1) {
                            str = cursor.getString(cursor.getColumnIndex(cn));
                            LoginProf = str;
                            Log.d("mLog",LoginProf);
                        }
                        if (i == 3) {
                            str = cursor.getString(cursor.getColumnIndex(cn));
                            PasswordProf = str;
                            Log.d("mLog",PasswordProf);
                        }
                        i++;
                    }
                }while (cursor.moveToNext());
               Intent intent = new Intent(this,MainActivity.class);
               startActivity(intent);
           }else{
               Toast.makeText(this,"Увы но вас нет",Toast.LENGTH_LONG).show();
           }


        }
        else{
            Toast.makeText(this,"Увы но вас нет. Забыли пароль?",Toast.LENGTH_LONG).show();
        }
        cursor.close();
    }
    public void registerer(View view){
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);
    }
    public void forgot(View view){
        Intent intent = new Intent(this,Forgot.class);
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
    public void onMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}