package com.example.mdd23.myapplication.features.login.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.example.mdd23.myapplication.R;
import com.example.mdd23.myapplication.features.articlelist.presentation.view.ArticleListActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.mdd23.myapplication.ToastUtil.showShortToast;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.login)
    Button button;

    LoginContract.Presenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mLoginPresenter = new LoginPresenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mLoginPresenter.onResume();
    }

    @OnClick(R.id.login)
    public void login(Button button) {
        mLoginPresenter.login(password.getText().toString());
    }

    @Override
    public void showOnboarding(String onboardMessage) {
        showShortToast(LoginActivity.this, onboardMessage);
    }

    @Override
    public void showWrongPassword(String errorMessage) {
        showShortToast(LoginActivity.this, errorMessage);
    }

    @Override
    public void showArticlesList(String confirmMessage) {
        showShortToast(LoginActivity.this, confirmMessage);
        startActivity(new Intent(this, ArticleListActivity.class));
    }

    @Override
    public void navigateToList() {
        startActivity(new Intent());
    }
}
