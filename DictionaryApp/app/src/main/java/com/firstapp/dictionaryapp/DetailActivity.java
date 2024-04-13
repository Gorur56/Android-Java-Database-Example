package com.firstapp.dictionaryapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends AppCompatActivity {
    private TextView textViewEnglish, textViewTurkish;
    private Words word;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textViewEnglish = findViewById(R.id.textViewEnglish);
        textViewTurkish = findViewById(R.id.textViewTurkish);

        //Gönderilen kelimeyi alıyoruz.
        word = (Words) getIntent().getSerializableExtra("nesne");

        textViewEnglish.setText(word.getEnglish());
        textViewTurkish.setText(word.getTurkish());
    }
}