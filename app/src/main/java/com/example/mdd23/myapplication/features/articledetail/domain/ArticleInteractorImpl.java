package com.example.mdd23.myapplication.features.articledetail.domain;

import com.example.mdd23.myapplication.DataManager.Article;
import com.example.mdd23.myapplication.DataManager.ArticleListRepositoryImpl;

import java.util.List;

/**
 * Created by mdd23 on 9/2/2016.
 */
public class ArticleInteractorImpl implements ArticleInteractor {

    ArticleInteractor.onArticleLoadedListener listener;

    public ArticleInteractorImpl(onArticleLoadedListener listener) {
        this.listener = listener;
    }

    @Override
    public void getArticle(long id) {
        List<Article> articles = new ArticleListRepositoryImpl().getArticles();
        for (Article a : articles) {
            if (a.getId() == id) {
                listener.onSuccessfulArticleLoad(a);
                return;
            }
        }
    }

}
