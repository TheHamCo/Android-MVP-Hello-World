package com.example.mdd23.myapplication.features.articlelist.domain;

import com.example.mdd23.myapplication.DataManager.Article;
import com.example.mdd23.myapplication.DataManager.ArticleListRepositoryImpl;

import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mdd23 on 9/2/2016.
 */
public class ArticleListInteractorImpl implements ArticleListInteractor {

    List<Article> articles;
    ArticleListInteractor.onArticlesLoadedListener listener;

    public ArticleListInteractorImpl(onArticlesLoadedListener listener) {
        this.listener = listener;
    }

    @Override
    public void getArticles() {
        articles = new ArticleListRepositoryImpl().getArticles();
        List<ArticleSummary> articleSummaries = new ArrayList<>();
        for (Article a : articles) {
            articleSummaries.add(
                    new ArticleSummary(a.getId(), a.title, shortenBody(a.body))
            );
        }

        listener.onSuccessfulArticleLoad(articleSummaries);
    }

    private String shortenBody(String fullBody) {
        return String.valueOf(CharBuffer.wrap(fullBody).subSequence(0, 50) + " . . . ");
    }
}
