package com.example.mdd23.myapplication.features.articledetail.domain;

import com.example.mdd23.myapplication.DataManager.Article;

/**
 * Created by mdd23 on 9/2/2016.
 */
public interface ArticleInteractor {
    public interface onArticleLoadedListener{
        void onSuccessfulArticleLoad(Article article);
        void onError();
    }

    void getArticle(long id);
}
