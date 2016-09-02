package com.example.mdd23.myapplication.features.login.presentation;

/**
 * Created by mdd23 on 9/2/2016.
 */
public interface LoginContract {
    public interface Presenter {
        void onResume();
        void login(String password);
    }

    public interface View {
        void showOnboarding(String onboardMessage);
        void showWrongPassword(String errorMessage);
        void showArticlesList(String confirmMessage);
    }

}
