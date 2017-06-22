package com.example.zhangyi.mvptest.presenter;

import android.os.Handler;

import com.example.zhangyi.mvptest.Interface.OnLoginListern;
import com.example.zhangyi.mvptest.Interface.UserLogin;
import com.example.zhangyi.mvptest.bean.User;
import com.example.zhangyi.mvptest.view.IUserLoginView;



/**
 * Created by zhangyi on 2017/2/21.
 */

public class UserLoginPresenter {
    private UserLogin userLogin;
    private IUserLoginView userLoginView;
    private Handler handler = new Handler();
    public UserLoginPresenter(IUserLoginView userLoginView){
        this.userLoginView = userLoginView;
        this.userLogin = new UserLogin();
    }
    public void Login(){
        userLoginView.showDialog();
        userLogin.login(userLoginView.getUserName(), userLoginView.getPassword(), new OnLoginListern() {
            @Override
            public void LoginSuccess(User user) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.toMainActivity();
                        userLoginView.hideDialog();
                    }
                });
            }

            @Override
            public void LoginFail() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.LoginFaileError();
                        userLoginView.hideDialog();
                    }
                });
            }
        });
    }
    public void clear(){
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }
}
