package com.qingzu.entity.api;

import com.qingzu.utils.http.HttpPostService;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.Api.BaseApi;
import com.yjx.sharelibrary.Share;

import java.security.PrivateKey;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by Administrator on 2017/4/19.
 */

public class CheckByCellPhone extends BaseApi {
  private  String CellPhone=null;


    public  CheckByCellPhone (RxAppCompatActivity rxAppCompatActivity){
        this.rxAppCompatActivity=rxAppCompatActivity;
        setMethod("api/User/CheckByCellPhone/{cellPhone}");
    }

    public String getCellPhone(){
        return CellPhone;
    }
    public  void setCellPhone(String CellPhone){
        this.CellPhone=CellPhone;
    }

    @Override
    public Observable getObservable(Retrofit retrofit) {
        HttpPostService postService =retrofit.create(HttpPostService.class);
        return postService.CheckByCellPhone(Share.getString("UserToken",""),getCellPhone());
    }
}
