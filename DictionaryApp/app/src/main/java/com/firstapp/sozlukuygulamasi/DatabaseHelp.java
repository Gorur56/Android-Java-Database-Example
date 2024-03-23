package com.firstapp.sozlukuygulamasi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelp extends SQLiteOpenHelper {

    public DatabaseHelp(@Nullable Context context) {
        super(context, "dictionary", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE \"words\" (\n" +
                "\t\"word_id\"\tINTEGER,\n" +
                "\t\"english\"\tTEXT,\n" +
                "\t\"turkish\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"word_id\" AUTOINCREMENT)\n" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //If we have words table. We must drop it.
        db.execSQL("DROP TABLE IF EXISTS words");
    }
}
