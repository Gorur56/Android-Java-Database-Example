package com.firstapp.notlaruygulamasi;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class DetayActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText editTextDers, editTextNot1, editTextNot2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detay);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        toolbar = findViewById(R.id.toolbar2);
        editTextDers = findViewById(R.id.editTextDers3);
        editTextNot1 = findViewById(R.id.editTextNot3);
        editTextNot2 = findViewById(R.id.editTextNot4);


        toolbar.setTitle("Not Detay");
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if( item.getItemId() == R.id.action_sil)
        {
            Snackbar.make(toolbar,"Silinsin mi?", Snackbar.LENGTH_SHORT).setAction("Evet", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(DetayActivity.this, NotKayitActivity.class));
                    finish();
                }
            }).show();
            return true;
        }
        else if (item.getItemId() == R.id.action_duzenle)
        {
            Snackbar.make(toolbar,"", Snackbar.LENGTH_SHORT).setAction("Evet", new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            }).show();
            return true;
        }
        return false;
    }
}