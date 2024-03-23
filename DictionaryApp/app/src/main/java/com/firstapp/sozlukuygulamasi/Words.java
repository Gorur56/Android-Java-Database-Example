package com.firstapp.sozlukuygulamasi;

public class Words {
    //Databse tablosunun model 'ini oluşturuyoruz.
    private int word_id;
    private String english;
    private String turkish;

    public Words() {
    }

    public Words(int word_id, String english, String turkish) {
        this.word_id = word_id;
        this.english = english;
        this.turkish = turkish;
    }

    public int getWord_id() {
        return word_id;
    }

    public void setWord_id(int word_id) {
        this.word_id = word_id;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getTurkish() {
        return turkish;
    }

    public void setTurkish(String turkish) {
        this.turkish = turkish;
    }
}
