package com.firstapp.filmapp.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.firstapp.filmapp.objects.Categories;

import java.util.ArrayList;

public class Categoriesdao {

    public ArrayList<Categories> allCategories(DatabaseHelper dbh)
    {
        ArrayList<Categories> categoriesArrayList = new ArrayList<>();
        SQLiteDatabase db = dbh.getWritableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM categories", null);

        while(c.moveToNext())
        {
            Categories categories = new Categories(c.getInt(c.getColumnIndex("category_id")),
                    c.getString(c.getColumnIndex("category_name")));

            categoriesArrayList.add(categories);
        }
    }
}
