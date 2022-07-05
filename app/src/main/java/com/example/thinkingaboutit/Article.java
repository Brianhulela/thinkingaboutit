package com.example.thinkingaboutit;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Article {
    String title;
    String date;
    String articleText;
    boolean like;
    boolean bookmark;

    public Article(String title, String articleText){
        this.title = title;
        this.articleText = articleText;
        this.like = false;
        this.bookmark = false;
        setDate();

    }

    public void setDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        this.date = dateFormat.format(cal.getTime());
    }
}
