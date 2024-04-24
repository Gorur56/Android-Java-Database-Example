package com.firstapp.notlaruygulamasi;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

import java.util.stream.StreamSupport;

public class NotKayitActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText editTextDers, editTextNot1, editTextNot2;
    private Button buttonKaydet;

    private Veritabani vt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_not_kayit);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        toolbar = findViewById(R.id.toolbarNot);
        editTextDers = findViewById(R.id.editTextDers);
        editTextNot1 = findViewById(R.id.editTextNot1);
        editTextNot2 = findViewById(R.id.editTextNot2);
        buttonKaydet = findViewById(R.id.buttonKaydet);

        vt = new Veritabani(this);
        toolbar.setTitle("Not Kayıt");
        setSupportActionBar(toolbar);

        buttonKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //trim: kenar boşluklarını alır.
                String ders_adi = editTextDers.getText().toString().trim();
                String not1 = editTextNot1.getText().toString().trim();
                String not2 = editTextNot2.getText().toString().trim();

                if(TextUtils.isEmpty(ders_adi))
                {
                    Snackbar.make(v, "Ders adı giriniz:",Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(not1))
                {
                    Snackbar.make(v, "Not 1 giriniz:",Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(not2))
                {
                    Snackbar.make(v, "Not 2 giriniz:",Snackbar.LENGTH_SHORT).show();
                    return;
                }

                new NotlarDao().notEkle(vt,ders_adi,Integer.parseInt(not1),Integer.parseInt(not2));

                startActivity(new Intent(NotKayitActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}