package com.kruglov.coffeshop;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "users";
    public static final String TABLE_USER = "user";

    public static final String KEY_ID = "_id";
    public static final String KEY_LOGIN = "Login";
    public static final String KEY_MAIL = "Email";
    public static final String KEY_PASSWORD = "Password";

    public static final String KEY_BALLS = "Balls";
    public static final String KEY_MONEY_COUNT = "Money";
    public static final String KEY_UNICUM_KOD = "KOD";
    public static final String KEY_REGISTER = "IsRegister";
    public static final String KEY_LYGA = "Lyga";

    public static final String KEY_PHOTO = "Photo";



    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME ,null, DATABASE_VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_USER + "(" + KEY_ID
                + " integer primary key," + KEY_LOGIN
                + " text," + KEY_MAIL
                + " text," + KEY_PASSWORD
                + " text," + KEY_BALLS
                + " integer," + KEY_UNICUM_KOD
                + " text," + KEY_MONEY_COUNT
                + " integer," + KEY_REGISTER
                + " integer," + KEY_LYGA
                + " text," + KEY_PHOTO
                + " text" + ")");
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_USER);
        onCreate(db);
    }
}
