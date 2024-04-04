package com.firstapp.dictionaryapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class WordsAdapter extends RecyclerView.Adapter<WordsAdapter.CardTasarimTutucu>{
    private Context context;

    private ArrayList<Words> wordsArrayList;

    public WordsAdapter(Context context, ArrayList<Words> wordsArrayList) {
        this.context = context;
        this.wordsArrayList = wordsArrayList;
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Aşağıdaki card tasarım modelini birleştiriyoruz.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_design, parent);
        return new CardTasarimTutucu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        Words word = wordsArrayList.get(position);
        holder.textViewEng.setText(word.getEnglish());
        holder.textViewTr.setText(word.getTurkish());

        holder.word_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Seçilen Kelime: "+word.getEnglish(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return wordsArrayList.size();
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        //Card üzerindeki nesneleri bağlıyoruz.
        //Bu modeli kullanarak card tasarımının üzerinde satır satır göstereceğiz.
        private TextView textViewEng;
        private TextView textViewTr;
        private CardView word_card;

        public CardTasarimTutucu(@NonNull View itemView) {
            super(itemView);
            textViewEng = itemView.findViewById(R.id.textViewEng);
            textViewTr = itemView.findViewById(R.id.textViewTr);
            word_card = itemView.findViewById(R.id.word_card);
        }
    }
}
