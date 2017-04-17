package com.qingzu.waterproof_work;

import android.os.Bundle;
import android.widget.TextView;

import com.qingzu.entity.api.LoginPost;
import com.qingzu.entity.resulte.InterfaceReturn;
import com.qingzu.entity.resulte.LoginMember;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.exception.ApiException;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.http.HttpManager;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.HttpOnNextListener;

import java.util.HashMap;
import java.util.Map;


public class LoginActivity extends RxAppCompatActivity implements HttpOnNextListener {

    private HttpManager manager = null;

    private LoginPost loginPost = null;
    private  TextView tvMsg =null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tvMsg = (TextView) findViewById(R.id.tvMsg);
        IntiView();
    }

    private void IntiView() {
        manager = new HttpManager(this, this);
        loginPost = new LoginPost(this);
        //  SparseArray SparseArray
        //   Map<String,Object>map1 =new　SparseArray;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("UserName", "18698562507");
        map.put("UserPwd", "123456");
        loginPost.setMapData(map);
        manager.doHttpDeal(loginPost);

    }

    @Override
    public void onNext(String resulte, String method) {
        if (method.equals(loginPost.getMethod())) {
            InterfaceReturn<LoginMember> interfaceReturn = new InterfaceReturn<LoginMember>();
            interfaceReturn = InterfaceReturn.fromJson(resulte,
                    LoginMember.class);
            if (interfaceReturn!=null){
                tvMsg.setText(interfaceReturn.toString());
            }
        }
    }

    @Override
    public void onError(ApiException e) {
        tvMsg.setText("失败：\ncode=" + e.getCode() + "\nmsg:" + e.getDisplayMessage());
    }
}
