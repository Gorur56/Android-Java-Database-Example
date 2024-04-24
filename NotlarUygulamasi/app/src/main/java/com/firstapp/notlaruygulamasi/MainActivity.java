package com.firstapp.notlaruygulamasi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView rv;
    private FloatingActionButton fab;

    private NotlarAdapter adapter;
    private ArrayList<Notlar> notlarArrayList;

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
        fab = findViewById(R.id.floatingActionButton);

        toolbar.setTitle("Not Uygulaması");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        toolbar.setSubtitle("Ortalama :");
        toolbar.setSubtitleTextColor(getResources().getColor(R.color.white));

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        setSupportActionBar(toolbar);

        notlarArrayList = new ArrayList<>();
        Notlar n1 = new Notlar(1,"Tarih",50,70);
        Notlar n2 = new Notlar(2,"Matematik",60,78);
        Notlar n3 = new Notlar(3,"Tarih",45,65);

        notlarArrayList.add(n1);
        notlarArrayList.add(n2);
        notlarArrayList.add(n3);

        adapter = new NotlarAdapter(this,notlarArrayList);

        rv.setAdapter(adapter);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NotKayitActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        //BAck tuşuna basınca ana sayfadaysa uygulamadan  çık.
        //İki sınıftanda ama sayfaya yönlendirdiğimiz için, back tuşuna basınca ana sayfadan ana sayfaya geçiz yapıyordu.

        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}