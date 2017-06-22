package com.example.zhangyi.mvptest.Interface;

import com.example.zhangyi.mvptest.bean.User;

/**
 * Created by zhangyi on 2017/2/21.
 */

public class UserLogin implements IUserLogin{
    @Override
    public void login(final String userName, final String passWord, final OnLoginListern listern) {
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                if (userName.equals("zhang")&&passWord.equals("456")){
                    User user = new User();
                    user.setPassWord(passWord);
                    user.setUserName(userName);
                    listern.LoginSuccess(user);
                }else {
                    listern.LoginFail();
                }

            }
        }.start();
    }
}
