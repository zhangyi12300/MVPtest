package com.example.zhangyi.mvptest.Interface;

import com.example.zhangyi.mvptest.bean.User;

/**
 * Created by zhangyi on 2017/2/21.
 */

public interface OnLoginListern {
    void LoginSuccess(User user);
    void LoginFail();
}
