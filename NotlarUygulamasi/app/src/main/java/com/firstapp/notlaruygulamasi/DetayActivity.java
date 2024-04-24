package com.firstapp.notlaruygulamasi;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
    private Notlar not;
    private Veritabani vt;
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

        vt = new Veritabani(this);

        not = (Notlar) getIntent().getSerializableExtra("nesne");

        editTextDers.setText(not.getDers_adi());
        editTextNot1.setText(String.valueOf(not.getNot1()));
        editTextNot2.setText(String.valueOf(not.getNot2()));
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
            Snackbar.make(toolbar,"Silinsin mi ?",Snackbar.LENGTH_SHORT)
                    .setAction("Evet", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            new NotlarDao().notSil(vt,not.getNot_id());

                            startActivity(new Intent(DetayActivity.this,MainActivity.class));
                            finish();
                        }
                    })
                    .show();
            return true;
        }
        else if (item.getItemId() == R.id.action_duzenle)
        {
            String ders_adi = editTextDers.getText().toString().trim();
            String not1 = editTextNot1.getText().toString().trim();
            String not2 = editTextNot2.getText().toString().trim();

            if(TextUtils.isEmpty(ders_adi)){
                Snackbar.make(toolbar,"Ders adı giriniz",Snackbar.LENGTH_SHORT).show();
                return false;
            }

            if(TextUtils.isEmpty(not1)){
                Snackbar.make(toolbar,"Not1 giriniz",Snackbar.LENGTH_SHORT).show();
                return false;
            }

            if(TextUtils.isEmpty(not2)){
                Snackbar.make(toolbar,"Not2 giriniz",Snackbar.LENGTH_SHORT).show();
                return false;
            }

            new NotlarDao().notDuzenle(vt,not.getNot_id(),ders_adi,Integer.parseInt(not1),Integer.parseInt(not2));

            startActivity(new Intent(DetayActivity.this,MainActivity.class));
            finish();
            return true;
        }
        return false;
    }
}