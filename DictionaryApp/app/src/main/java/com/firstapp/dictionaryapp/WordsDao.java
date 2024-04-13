package com.firstapp.dictionaryapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class WordsDao {
    public ArrayList<Words> allWords( Veritabani vt)
    {
        ArrayList<Words> wordsArrayList = new ArrayList<>();

        SQLiteDatabase db = vt.getWritableDatabase();

        //Kelimer tablolasundaki tüm kayıtlar cursor içine geliyor.
        Cursor c = db.rawQuery("SELECT * FROM kelimeler", null);

        while (c.moveToNext())
        {
            Words w = new Words(c.getInt(c.getColumnIndex("kelime_id"))
                    ,c.getString(c.getColumnIndex("ingilizce"))
                    ,c.getString(c.getColumnIndex("turkce")));
            wordsArrayList.add(w);
        }

        return wordsArrayList;
    }

    public ArrayList<Words> wordSearch( Veritabani vt, String searchWord)
    {
        ArrayList<Words> wordsArrayList = new ArrayList<>();

        SQLiteDatabase db = vt.getWritableDatabase();

        //Kelimer tablolasundaki tüm kayıtlar cursor içine geliyor.
        Cursor c = db.rawQuery("SELECT * FROM kelimeler WHERE ingilizce like '%"+searchWord+"%'", null);

        while (c.moveToNext())
        {
            Words w = new Words(c.getInt(c.getColumnIndex("kelime_id"))
                    ,c.getString(c.getColumnIndex("ingilizce"))
                    ,c.getString(c.getColumnIndex("turkce")));
            wordsArrayList.add(w);
        }

        return wordsArrayList;
    }
}
