package com.firstapp.dictionaryapp;

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
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private Toolbar toolbar;
    private RecyclerView rv;
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
        toolbar.setTitleTextColor(getResources().getColor(R.color.black));
        setSupportActionBar(toolbar);
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
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        //It searches when each character is entered.
        Log.e("Enter Character:", newText);
        return false;
    }
}