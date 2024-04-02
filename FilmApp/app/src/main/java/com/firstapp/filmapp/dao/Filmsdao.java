package com.firstapp.filmapp.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.firstapp.filmapp.objects.Categories;
import com.firstapp.filmapp.objects.Directors;
import com.firstapp.filmapp.objects.Films;

import java.util.ArrayList;

public class Filmsdao {
    public ArrayList<Films> allFilms(DatabaseHelper dbh)
    {
        ArrayList<Films> filmsArrayList = new ArrayList<>();
        SQLiteDatabase db = dbh.getWritableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM films, categories, directors " +
                "WHERE films.category_id = categories.category_id and films.director_id = directors.director_id", null);

        while(c.moveToNext())
        {
            Categories categories = new Categories(c.getInt(c.getColumnIndex("category_id")), c.getString(c.getColumnIndex("category_name")));
            Directors directors = new Directors(c.getInt(c.getColumnIndex("director_id")), c.getString(c.getColumnIndex("director_name")));

            Films f = new Films(c.getInt(c.getColumnIndex("film_id"))
                    ,c.getString(c.getColumnIndex("film_name"))
                    ,c.getInt(c.getColumnIndex("film_year"))
                    ,c.getString(c.getColumnIndex("film_image"))
                    ,categories,directors);
            filmsArrayList.add(f);
        }

        return filmsArrayList;
    }
}
