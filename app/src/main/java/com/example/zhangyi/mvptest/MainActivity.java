package com.example.zhangyi.mvptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.zhangyi.mvptest.presenter.UserLoginPresenter;
import com.example.zhangyi.mvptest.view.IUserLoginView;

public class MainActivity extends AppCompatActivity implements IUserLoginView{

    private EditText userName_et;
    private EditText password_et;
    private Button login_bt;
    private Button clear_bt;
    private ProgressBar progressBar;

    private UserLoginPresenter loginPresenter = new UserLoginPresenter(MainActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intviews();

    }
    private void intviews(){
        userName_et = (EditText) findViewById(R.id.editText);
        password_et = (EditText) findViewById(R.id.editText3);
        login_bt = (Button) findViewById(R.id.button);
        clear_bt = (Button) findViewById(R.id.button2);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        login_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.Login();
            }
        });
        clear_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.clear();
            }
        });
    }

    @Override
    public String getUserName() {
        return userName_et.getText().toString();
    }

    @Override
    public String getPassword() {
        return password_et.getText().toString();
    }

    @Override
    public void showDialog() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideDialog() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity() {
        Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void LoginFaileError() {
        Toast.makeText(MainActivity.this,"登录失败",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void clearUserName() {
        userName_et.setText("");
    }

    @Override
    public void clearPassword() {
        password_et.setText("");
    }
}
