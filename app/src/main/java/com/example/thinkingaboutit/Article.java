package com.example.thinkingaboutit;

public class Article {
    String title;
    String articleText;
    boolean like;
    boolean bookmark;

    public Article(String title, String articleText){
        this.title = title;
        this.articleText = articleText;
        this.like = false;
        this.bookmark = false;
    }
}
