package com.example.mdd23.myapplication.features.articledetail.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.mdd23.myapplication.DataManager.Article;
import com.example.mdd23.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.mdd23.myapplication.ToastUtil.showShortToast;

public class ArticleDetailActivity extends AppCompatActivity implements ArticleContract.View{

    public static final String INTENT_EXTRA_ARTICLE_ID = "INTENT_EXTRA_ARTICLE_ID";
    public static final String INSTANCE_STATE_ARTICLE_ID = "INSTANCE_STATE_ARTICLE_ID";

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.body)
    TextView body;

    private long articleId;
    private ArticleContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);
        ButterKnife.bind(this);

        initActivity(savedInstanceState);
        presenter = new ArticlePresenter(this);
        presenter.loadArticle(articleId);
    }

    private void initActivity(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            this.articleId = getIntent().getLongExtra(INTENT_EXTRA_ARTICLE_ID, 0L);
        } else {
            this.articleId = savedInstanceState.getInt(INSTANCE_STATE_ARTICLE_ID);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.putLong(INSTANCE_STATE_ARTICLE_ID, this.articleId);
        }
        super.onSaveInstanceState(outState);
    }

    @Override
    public void showArticle(Article article) {
        title.setText(article.title);
        body.setText(article.body);
    }

    @Override
    public void showError() {
        showShortToast(this, "Error loading article.");
    }
}
