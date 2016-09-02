package com.example.mdd23.myapplication.features.login.presentation;

import com.example.mdd23.myapplication.features.login.LoginUtils;

/**
 * Created by mdd23 on 9/2/2016.
 */
public class LoginPresenter implements LoginContract.Presenter {

    LoginContract.View loginView;

    public LoginPresenter(LoginContract.View loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onResume() {
        loginView.showOnboarding("Welcome to Magic List!");
    }

    @Override
    public void login(String password) {
        if (password.equals(LoginUtils.PASSWORD)){
            loginView.showArticlesList("Welcome!");

        } else {
            loginView.showWrongPassword("Try Again!");
        }
    }
}
