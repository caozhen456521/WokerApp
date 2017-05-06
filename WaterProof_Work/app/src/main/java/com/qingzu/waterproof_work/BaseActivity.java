package com.qingzu.waterproof_work;

import android.content.Context;
import android.os.Bundle;

import android.support.annotation.Nullable;

import com.qingzu.Application.MyApplication;
import com.qingzu.observerPattem.Observer;
import com.qingzu.observerPattem.Subject;
import com.qingzu.utils.http.tools.Tools;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

/**
 * Created by Administrator on 2017/4/18.
 */


public class BaseActivity extends RxAppCompatActivity implements Observer {

    public MyApplication myApplication = null;
    public RxAppCompatActivity mContext =null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myApplication = (MyApplication) this.getApplication();
        myApplication.getApplicationSubject().addObserver(this);
        Tools.setNavigationBarColor(this, R.color.title_background_blue);
        mContext=this;
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
