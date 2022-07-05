package com.example.thinkingaboutit;

public class Article {
    String title;
    boolean like;
    boolean bookmark;

    public Article(String title){
        this.title = title;
        this.like = false;
        this.bookmark = false;
    }
}
