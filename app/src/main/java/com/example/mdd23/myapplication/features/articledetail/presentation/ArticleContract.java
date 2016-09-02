package com.example.mdd23.myapplication.features.articledetail.presentation;

import com.example.mdd23.myapplication.DataManager.Article;

/**
 * Created by mdd23 on 9/2/2016.
 */
public interface ArticleContract {
    public interface Presenter {
        void loadArticle(long id);
    }

    public interface View {
        void showArticle(Article article);
        void showError();
    }
}
