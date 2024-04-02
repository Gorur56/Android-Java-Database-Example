package com.firstapp.filmapp;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.firstapp.filmapp.dao.Categoriesdao;
import com.firstapp.filmapp.dao.DatabaseCopyHelper;
import com.firstapp.filmapp.dao.DatabaseHelper;
import com.firstapp.filmapp.objects.Categories;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //We write in mainActivity copy process

    private DatabaseHelper dbh = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        try {
            copy();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ArrayList<Categories> categoriesArrayList = new Categoriesdao().allCategories(dbh);

        for (Categories c: categoriesArrayList) {
            Log.e(String.valueOf(c.getCategory_id()), c.getCategory_name());
        }
    }

    public void copy() throws IOException {
        DatabaseCopyHelper helper = new DatabaseCopyHelper(this);

        try {
            helper.createDataBase();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        helper.openDataBase();
    }
}