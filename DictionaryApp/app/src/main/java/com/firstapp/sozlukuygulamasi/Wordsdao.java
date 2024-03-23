package com.firstapp.sozlukuygulamasi;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.UserDictionary;

import java.util.ArrayList;

public class Wordsdao {
    //access database methods

    public void wordAdd(DatabaseHelp db, String english, String turkish){
        SQLiteDatabase dbx = db.getWritableDatabase();

        //we can add value in database with ContentValue
        ContentValues values = new ContentValues();

        values.put("english",english);
        values.put("turkish",turkish);

        dbx.insertOrThrow("words",null,values);
        dbx.close();

    }

    //If you want to see the words we added, you need to get the data with this method.
    public ArrayList<Words> allWords(DatabaseHelp db){
        ArrayList<Words> wordsArrayList = new ArrayList<>();
        SQLiteDatabase dbx = db.getWritableDatabase();

        Cursor c = dbx.rawQuery("SELECT*FROM words",null);

        while (c.moveToNext())
        {
            Words word = new Words(c.getInt(c.getColumnIndex("word_id")),
                    c.getString(c.getColumnIndex("english")),
                    c.getString(c.getColumnIndex("turkish")));

            wordsArrayList.add(word);
        }
    }
}
