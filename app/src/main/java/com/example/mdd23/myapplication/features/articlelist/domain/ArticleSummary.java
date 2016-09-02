package com.example.mdd23.myapplication.features.articlelist.domain;

/**
 * Created by mdd23 on 9/2/2016.
 */
public class ArticleSummary {
    private long id;
    public String title;
    public String shortDescription;

    public ArticleSummary(long id, String title, String shortDescription) {
        this.id = id;
        this.title = title;
        this.shortDescription = shortDescription;
    }

    public long getId() {
        return id;
    }
}
