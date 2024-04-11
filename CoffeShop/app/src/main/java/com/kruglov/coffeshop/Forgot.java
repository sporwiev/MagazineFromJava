package com.kruglov.coffeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.annotation.SuppressLint;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Forgot extends AppCompatActivity {
    EditText login,password,newpassword;
    DBHelper dbHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
        login = (EditText) findViewById(R.id.LoginFor);
        password = (EditText) findViewById(R.id.PasswordFor);
        newpassword = (EditText) findViewById(R.id.NewPasswordFor);
        dbHelper = new DBHelper(this);
    }
    public void ForgotPass(View view){

        String Login = login.getText().toString();
        String Password = password.getText().toString();
        String NewPassword = newpassword.getText().toString();
        Password = NewPassword;
        SQLiteDatabase database = new DBHelper(this).getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.KEY_PASSWORD,Password);
        contentValues.put(DBHelper.KEY_LOGIN,Login);
        String upd = String.valueOf(database.update(DBHelper.TABLE_USER,contentValues,DBHelper.KEY_LOGIN + "= ?", new String[] {Login}));
        Log.d("mLog","Изменено " + upd);

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