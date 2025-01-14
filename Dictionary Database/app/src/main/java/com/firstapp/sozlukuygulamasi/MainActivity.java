package com.firstapp.sozlukuygulamasi;

import android.os.Bundle;
import android.provider.UserDictionary;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DatabaseHelp db;
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

        db = new DatabaseHelp(this);

        //add words
        /*new Wordsdao().wordAdd(db,"door","kapı");
        new Wordsdao().wordAdd(db,"window","pencere");
        new Wordsdao().wordAdd(db,"sea","deniz");
        new Wordsdao().wordAdd(db,"table","masa");
        new Wordsdao().wordAdd(db,"pencil","kalem");*/


        //for delete
        //new Wordsdao().wordDelete(db,2);

        //for update
       //new Wordsdao().wordUpdate(db,6, "hello","merhaba");

        //For select count
        int result = new Wordsdao().recordControl(db);
        Log.e("Veri Sayısı: ",String.valueOf(result));

        Words word = new Wordsdao().wordComing(db,5);
        Log.e("5. word: ", word.getWord_id()+" - "+word.getEnglish()+" - "+word.getTurkish());

        /*ArrayList<Words> random = new Wordsdao().rondomWord(db);

        for(Words w:random)
        {
            Log.e(String.valueOf(w.getWord_id()), w.getEnglish()+"-"+w.getTurkish());
        }*/

        //We receive all the words we send
        /*ArrayList<Words> incomingWordList = new Wordsdao().allWords(db);

        for(Words w:incomingWordList)
        {
            Log.e(String.valueOf(w.getWord_id()), w.getEnglish()+"-"+w.getTurkish());
        }*/

        ArrayList<Words> search = new Wordsdao().searchWord(db,"l");

        for (Words w:search) {
            Log.e(String.valueOf(w.getWord_id()), w.getEnglish()+"-"+w.getTurkish());
        }

    }
}