package com.kruglov.coffeshop;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;




import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;


// fpoyxfraffybrzlv
public class Register extends AppCompatActivity {
    public static boolean regist = false;
    public static int balls = 100;
    public static int money = 0;
    public  static String Lyga = "Бронза";

    public static String Cod = null;
    EditText mail,login,password,repeatpassword;
    Button register;
    CheckBox sogl, podp;
    DBHelper dbHelper;
    TextView enter;






    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mail = (EditText) findViewById(R.id.Email);
        login = (EditText) findViewById(R.id.Login);
        password = (EditText) findViewById(R.id.Password);
        repeatpassword = (EditText) findViewById(R.id.RepeatPassword);
        register = (Button) findViewById(R.id.register);
        sogl = (CheckBox) findViewById(R.id.sogl);
        podp = (CheckBox) findViewById(R.id.podp);

        dbHelper = new DBHelper(this);




    }
    public void Enter(View view){
        Intent intent = new Intent(this, Enter.class);
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
    public static String generateRandomPassword(int len)
    {
        // ASCII range – alphanumeric (0-9, a-z, A-Z)
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        // each iteration of the loop randomly chooses a character from the given
        // ASCII range and appends it to the `StringBuilder` instance

        for (int i = 0; i < len; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }

        return sb.toString();
    }
    public void onRegister(View view) {

        String Mail = mail.getText().toString();
        String Login = login.getText().toString();
        String Password = password.getText().toString();
        String RepeatPassword = repeatpassword.toString().toString();
        CheckBox Sogl = sogl;
        CheckBox Podp = podp;
        Sogl = (CheckBox) findViewById(R.id.sogl);
        int index = Mail.indexOf('@');
        if(index == - 1 && Login.length() < 5 && Password.length() < 8 && RepeatPassword != Password && !Sogl.isChecked()){
            Toast.makeText(this,"Вы допустили ошибку",Toast.LENGTH_LONG).show();
        }else {
            int reg = 1;

            SQLiteDatabase database = dbHelper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(DBHelper.KEY_LOGIN, Login);
            contentValues.put(DBHelper.KEY_MAIL, Mail);
            contentValues.put(DBHelper.KEY_PASSWORD, Password);
            Cod = generateRandomPassword(Password.length());
            contentValues.put(DBHelper.KEY_UNICUM_KOD,Cod);
            contentValues.put(DBHelper.KEY_BALLS, balls);
            contentValues.put(DBHelper.KEY_MONEY_COUNT, money);
            contentValues.put(DBHelper.KEY_REGISTER,reg);
            contentValues.put(DBHelper.KEY_LYGA,Lyga);
            database.insert(DBHelper.TABLE_USER, null, contentValues);

            Cursor cursor = database.query(DBHelper.TABLE_USER, null, null, null, null, null, null);

            if (cursor.moveToFirst()) {
                int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
                int loginIndex = cursor.getColumnIndex(DBHelper.KEY_LOGIN);
                int emailIndex = cursor.getColumnIndex(DBHelper.KEY_MAIL);
                int passwordIndex = cursor.getColumnIndex(DBHelper.KEY_PASSWORD);
                int CodIndex = cursor.getColumnIndex(DBHelper.KEY_UNICUM_KOD);
                int BallIndex = cursor.getColumnIndex(DBHelper.KEY_BALLS);
                int MoneyIndex = cursor.getColumnIndex(DBHelper.KEY_MONEY_COUNT);
                int RegIndex = cursor.getColumnIndex(DBHelper.KEY_REGISTER);
                int LygaIndex = cursor.getColumnIndex(DBHelper.KEY_LYGA);
                do {
                    Log.d("mLog", "ID = " + cursor.getInt(idIndex) +
                            ", login = " + cursor.getString(loginIndex) +
                            ", mail = " + cursor.getString(emailIndex) +
                            ", password = " + cursor.getString(passwordIndex) +
                            ", code = " + cursor.getString(CodIndex) +
                            ", ball = " + cursor.getString(BallIndex) +
                            ", money = " + cursor.getString(MoneyIndex) +
                            ", regist = " + cursor.getString(RegIndex) +
                            ", lyga = " + cursor.getString(LygaIndex));


                } while (cursor.moveToNext());
                Toast.makeText(this, "Вы зарегистрированы", Toast.LENGTH_LONG).show();
                regist = true;
                Intent intent = new Intent(this,Enter.class);
                startActivity(intent);
                cursor.close();


            } else {
                Toast.makeText(this, "Не удалось", Toast.LENGTH_LONG).show();
            }

        }
    }
}

