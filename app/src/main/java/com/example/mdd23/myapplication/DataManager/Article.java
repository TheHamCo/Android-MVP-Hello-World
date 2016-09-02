package com.example.mdd23.myapplication.DataManager;

/**
 * Created by mdd23 on 9/2/2016.
 */
public class Article {
    private long id;
    public String title;
    public String body;

    public Article(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public long getId() {
        return id;
    }
}
