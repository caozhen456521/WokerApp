package com.qingzu.waterproof_work;

import android.os.Bundle;

import android.support.annotation.Nullable;

import com.qingzu.Application.MyApplication;
import com.qingzu.observerPattem.Observer;
import com.qingzu.observerPattem.Subject;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

/**
 * Created by Administrator on 2017/4/18.
 */


public class BaseActivity extends RxAppCompatActivity implements Observer {

    public MyApplication myApplication = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myApplication = (MyApplication) this.getApplication();
        myApplication.getApplicationSubject().addObserver(this);
    }

    @Override
    public void update(Subject subject) {
        this.finish();
    }

    @Override
    public void finish() {
        super.finish();
        myApplication.getApplicationSubject().removeObserver(this);
    }

    public void close() {
        myApplication.getApplicationSubject().exit();
    }
}