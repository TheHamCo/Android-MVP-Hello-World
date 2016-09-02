package com.example.mdd23.myapplication.features.articledetail.presentation;

import com.example.mdd23.myapplication.DataManager.Article;
import com.example.mdd23.myapplication.features.articledetail.domain.ArticleInteractor;
import com.example.mdd23.myapplication.features.articledetail.domain.ArticleInteractorImpl;

/**
 * Created by mdd23 on 9/2/2016.
 */
public class ArticlePresenter implements ArticleContract.Presenter, ArticleInteractor.onArticleLoadedListener{

    ArticleContract.View articleView;
    ArticleInteractor articleInteractor;

    public ArticlePresenter(ArticleContract.View articleView) {
        this.articleView = articleView;
        articleInteractor = new ArticleInteractorImpl(this);
    }

    @Override
    public void loadArticle(long id) {
        articleInteractor.getArticle(id);
    }

    @Override
    public void onSuccessfulArticleLoad(Article article) {
        articleView.showArticle(article);
    }

    @Override
    public void onError() {
        articleView.showError();
    }
}
