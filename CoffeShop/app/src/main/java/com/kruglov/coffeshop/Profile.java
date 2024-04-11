package com.kruglov.coffeshop;

import androidx.annotation.IntRange;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class Profile extends AppCompatActivity {
    TextView LoginProf, Balls, Lyga, Code;
    String BALLS, selection;
    DBHelper dbHelper;
    ImageView ProfileImage;
    Bitmap ProfilPhoto = null;

    String[] selectionargs = null;
    public static Uri uri = null;
    static final int GALLERY_REQUEST = 1;

    @SuppressLint({"MissingInflatedId", "Range", "SupportAnnotationUsage"})
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        LoginProf = (TextView) findViewById(R.id.LoginProf);
        Balls = (TextView) findViewById(R.id.balls);
        Lyga = (TextView) findViewById(R.id.Liga);
        Code = (TextView) findViewById(R.id.Cod);
        LoginProf.setText(Enter.LoginProf);

        ProfileImage = (ImageView) findViewById(R.id.imageProfile);
        BALLS = String.valueOf(Register.balls);
        Balls.setText(BALLS);
        Lyga.setText(Register.Lyga);
        int i = 0;
        dbHelper = new DBHelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor cursor;
        selection = "login = ?";
        selectionargs = new String[]{LoginProf.getText().toString()};
        Log.d("Enter", LoginProf.getText().toString());
        cursor = database.query("user", null, selection, selectionargs, null, null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                String str;
                do {
                    str = "";
                    for (String cn : cursor.getColumnNames()) {
                        if (i == 5) {
                            Code.setText(cursor.getString(cursor.getColumnIndex(cn)));

                        }
                        i++;
                    }
                    Log.d("Enter", str);
                } while (cursor.moveToNext());
                Log.d("Enter", str);
            }


        }
        cursor.close();
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

    public void UpgradeImage(View view) {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, GALLERY_REQUEST);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        dbHelper = new DBHelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        Bitmap bitmap = null;
        ProfileImage = (ImageView) findViewById(R.id.imageProfile);

        switch (requestCode) {
            case GALLERY_REQUEST:
                if (resultCode == RESULT_OK) {
                    uri = imageReturnedIntent.getData();
                    contentValues.put(DBHelper.KEY_PHOTO,uri.toString());
                    database.insert(DBHelper.TABLE_USER, null, contentValues);
                    try {
                        bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    ProfileImage.setImageBitmap(bitmap);
                }
        }
    }
}