package com.qingzu.entity.api;

import com.qingzu.utils.http.HttpPostService;
import com.qingzu.utils.http.tools.SPUtils;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.Api.BaseApi;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by Administrator on 2017/3/27.
 * 刷新用户T
 */

public class RefreshToken extends BaseApi {


    public RefreshToken(RxAppCompatActivity rxAppCompatActivity) {
        this.rxAppCompatActivity = rxAppCompatActivity;
        setMethod("RefreshToken");

    }

    @Override
    public Observable getObservable(Retrofit retrofit) {
        String UserToken = (String) SPUtils.get(rxAppCompatActivity.getApplication(), "UserToken", "");
        HttpPostService postService = retrofit.create(HttpPostService.class);
        return postService.getMember(UserToken);
    }
}
