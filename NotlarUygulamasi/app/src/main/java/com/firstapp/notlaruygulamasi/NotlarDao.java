package com.firstapp.notlaruygulamasi;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class NotlarDao {
    public ArrayList<Notlar> tumNotlar( Veritabani vt )
    {
        //Her seferinde yeni notları kaydetsin diye arraylist oluşturuyoruz.
        ArrayList<Notlar> notlarArrayList = new ArrayList<>();
        SQLiteDatabase db = vt.getWritableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM notlar",null);

        while (c.moveToNext())
        {
            Notlar n = new Notlar(c.getInt(c.getColumnIndex("not_id"))
                    ,c.getString(c.getColumnIndex("ders_adi"))
                    ,c.getInt(c.getColumnIndex("not1"))
                    ,c.getInt(c.getColumnIndex("not2")));

            notlarArrayList.add(n);
        }

        return notlarArrayList;
    }
}
