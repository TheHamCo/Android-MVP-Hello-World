package com.example.mdd23.myapplication.features.articlelist.presentation.presenter;

import com.example.mdd23.myapplication.features.articlelist.domain.ArticleListInteractor;
import com.example.mdd23.myapplication.features.articlelist.domain.ArticleListInteractorImpl;
import com.example.mdd23.myapplication.features.articlelist.domain.ArticleSummary;
import com.example.mdd23.myapplication.features.articlelist.presentation.ArticleListContract;

import java.util.List;

/**
 * Created by mdd23 on 9/2/2016.
 */
public class ArticleListPresenter implements ArticleListContract.Presenter, ArticleListInteractor.onArticlesLoadedListener{

    ArticleListContract.View articleListView;
    ArticleListInteractor articleListInteractor;
    List<ArticleSummary> articleSummaries;

    public ArticleListPresenter(ArticleListContract.View articleListView) {
        articleListInteractor = new ArticleListInteractorImpl(this);
        this.articleListView = articleListView;
    }

    @Override
    public void loadArticles() {
        articleListInteractor.getArticles();
    }

    @Override
    public void openArticleDetail(int position) {
        long articleId = articleSummaries.get(position).getId();
        articleListView.showArticleDetail(articleId);
    }

    @Override
    public void onSuccessfulArticleLoad(List<ArticleSummary> articleSummaries) {
        this.articleSummaries = articleSummaries;
        articleListView.showListOfArticles(articleSummaries);
    }

    @Override
    public void onError() {
        articleListView.showError();
    }
}
