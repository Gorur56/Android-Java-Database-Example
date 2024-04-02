package com.firstapp.filmapp.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(@Nullable Context context) {
        super(context, "filmler.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Database oluşturmak için;
        //kopyalandığı için IF NOT EXISTS ekliyoruz.
        db.execSQL("CREATE TABLE IF NOT EXISTS \"categories\" (\n" +
                "\t\"category_id\"\tINTEGER,\n" +
                "\t\"category_name\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"category_id\" AUTOINCREMENT)\n" +
                ");");

        db.execSQL("CREATE TABLE IF NOT EXISTS \"directors\" (\n" +
                "\t\"director_id\"\tINTEGER,\n" +
                "\t\"director_name\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"director_id\" AUTOINCREMENT)\n" +
                ");");

        db.execSQL("CREATE TABLE IF NOT EXISTS \"films\" (\n" +
                "\t\"film_id\"\tINTEGER,\n" +
                "\t\"film_name\"\tTEXT,\n" +
                "\t\"film_year\"\tINTEGER,\n" +
                "\t\"film_image\"\tTEXT,\n" +
                "\t\"category_id\"\tINTEGER,\n" +
                "\t\"director_id\"\tINTEGER,\n" +
                "\tFOREIGN KEY(\"director_id\") REFERENCES \"directors\"(\"director_id\"),\n" +
                "\tFOREIGN KEY(\"category_id\") REFERENCES \"categories\"(\"category_id\"),\n" +
                "\tPRIMARY KEY(\"film_id\" AUTOINCREMENT)\n" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
