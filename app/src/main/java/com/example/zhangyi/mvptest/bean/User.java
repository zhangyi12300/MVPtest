package com.example.zhangyi.mvptest.bean;

/**
 * Created by zhangyi on 2017/2/21.
 */

public class User {
    private String UserName;
    private String PassWord;

    public User(String userName, String passWord) {
        UserName = userName;
        PassWord = passWord;
    }

    public User() {
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }
}
