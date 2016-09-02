package com.example.mdd23.myapplication.features.articlelist.domain;

import java.util.List;

/**
 * Created by mdd23 on 9/2/2016.
 */
public interface ArticleListInteractor {
    interface onArticlesLoadedListener{
        void onSuccessfulArticleLoad(List<ArticleSummary> articleSummaries);
        void onError();
    }

    void getArticles();
}
