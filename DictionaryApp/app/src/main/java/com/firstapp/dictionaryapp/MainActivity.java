package com.firstapp.dictionaryapp;

import android.net.wifi.WpsInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.MenuItemCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private Toolbar toolbar;
    private RecyclerView rv;
    private ArrayList<Words> wordsList;
    private WordsAdapter adapter;
    private Veritabani vt;
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
        toolbar = findViewById(R.id.toolbar);
        rv = findViewById(R.id.rv);

        //We connected the menu to the toolbar.

        toolbar.setTitle("Dictionary Application ");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);

        vt = new Veritabani(this);
        databaseCopy();

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        /*wordsList = new ArrayList<>();

        Words w1 = new Words(1,"Dog","Köpek");
        Words w2 = new Words(2,"Cat","Kedi");
        Words w3 = new Words(3,"Tiger","Kaplan");
        Words w4 = new Words(4,"Lion","Aslan");
        Words w5 = new Words(5,"Bird","Kuş");
        Words w6 = new Words(6,"Mouse","Fare");

        wordsList.add(w1);
        wordsList.add(w2);
        wordsList.add(w3);
        wordsList.add(w4);
        wordsList.add(w5);
        wordsList.add(w6);*/

        wordsList = new WordsDao().allWords(vt);

        adapter = new WordsAdapter(this,wordsList);

        //Görebilmemiz için recycle içerisine atmamız gerekiyor.
        rv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);

        //Code that Triggers the search when pressing search
        MenuItem item = menu.findItem(R.id.action_search); //click on action_search

        //SearchView searchView = (SearchView) MenuItemCompat.getActionView(item); Old usage

        SearchView searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(MainActivity.this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        //It searchs when data is entered. So We should click on enter button
        Log.e("Send Search: ",query);
        setSearchWord(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        //It searches when each character is entered.
        Log.e("Enter Character:", newText);
        setSearchWord(newText);
        return false;
    }


    //Bİr kopyalama sınıfı oluşturmamız lazım.
    public void databaseCopy(){
        DatabaseCopyHelper databaseCopyHelper = new DatabaseCopyHelper(this);

        try {
            databaseCopyHelper.createDataBase();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        databaseCopyHelper.openDataBase();
    }

    public void setSearchWord(String searchWord)
    {
        wordsList = new WordsDao().wordSearch(vt,searchWord);

        adapter = new WordsAdapter(this,wordsList);

        //Görebilmemiz için recycle içerisine atmamız gerekiyor.
        rv.setAdapter(adapter);
    }
}