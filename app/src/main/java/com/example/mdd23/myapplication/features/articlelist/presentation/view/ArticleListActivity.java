package com.example.mdd23.myapplication.features.articlelist.presentation.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.mdd23.myapplication.R;
import com.example.mdd23.myapplication.features.articledetail.presentation.ArticleDetailActivity;
import com.example.mdd23.myapplication.features.articlelist.domain.ArticleSummary;
import com.example.mdd23.myapplication.features.articlelist.presentation.ArticleListContract;
import com.example.mdd23.myapplication.features.articlelist.presentation.presenter.ArticleListPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

import static com.example.mdd23.myapplication.ToastUtil.showShortToast;

public class ArticleListActivity extends AppCompatActivity implements ArticleListContract.View {

    @BindView(R.id.article_summaries)
    ListView articles;

    ArticleAdapter articleAdapter;
    ArticleListContract.Presenter articlePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_list);
        ButterKnife.bind(this);
        articleAdapter = new ArticleAdapter(this, new ArrayList<ArticleSummary>());
        articles.setAdapter(articleAdapter);

        articlePresenter = new ArticleListPresenter(this);
        articlePresenter.loadArticles();
    }

    @OnItemClick(R.id.article_summaries)
    void onArticleSelected(int position) {
        long articleId = articleAdapter.getItem(position).getId();
        Intent intent = new Intent(this, ArticleDetailActivity.class)
                .putExtra(ArticleDetailActivity.INTENT_EXTRA_ARTICLE_ID, articleId);
        startActivity(intent);
    }

    @Override
    public void showListOfArticles(List<ArticleSummary> articleSummaries) {
        articleAdapter.addAll(articleSummaries);
    }

    @Override
    public void showError() {
        showShortToast(ArticleListActivity.this, "Error loading articles!");
    }
}
