package com.firstapp.sozlukuygulamasi;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.SearchRecentSuggestions;
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
        return wordsArrayList;
    }
    //we need word_id to delete the value we want.
    //If we want to delete words  other then word_id,we add them this way. dbx.delete("words","word_id=? and english=?"
    //ve diziye ekliyoruz
    public void wordDelete(DatabaseHelp db,int word_id)
    {
        SQLiteDatabase dbx = db.getWritableDatabase();

        dbx.delete("words","word_id=?",new String[]{String.valueOf(word_id)});
        dbx.close();
    }

    //we need all values to update the value we want.

    public void wordUpdate(DatabaseHelp db, int word_id, String english, String turkish)
    {
        SQLiteDatabase dbx = db.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("english",english);
        values.put("turkish",turkish);

        dbx.update("words",values,"word_id=?",new String[]{String.valueOf(word_id)});
        dbx.close();
    }

    public int recordControl(DatabaseHelp db)
    {
        int result = 0;

        SQLiteDatabase dbx = db.getWritableDatabase();
        Cursor c = dbx.rawQuery("SELECT count(*) as sonuc FROM words",null);

        while (c.moveToNext())
        {
            result= c.getInt(c.getColumnIndex("sonuc"));
        }

        return result;
    }


}
