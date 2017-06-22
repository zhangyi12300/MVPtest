package com.example.zhangyi.mvptest.view;

/**
 * Created by zhangyi on 2017/2/21.
 */

public interface IUserLoginView {
    String getUserName();
    String getPassword();
    void showDialog();
    void hideDialog();
    void toMainActivity();
    void LoginFaileError();
    void clearUserName();
    void clearPassword();
}
