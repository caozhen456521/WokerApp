package com.qingzu.entity.api;

import android.content.SharedPreferences;

import com.qingzu.utils.http.HttpPostService;
import com.qingzu.utils.http.tools.Tools;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.Api.BaseApi;
import com.yjx.sharelibrary.Share;

import java.util.Map;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * The type Login post.
 */
public class LoginPost extends BaseApi {
    /**
     * The Map.
     */
// private String UserToken = null;
    Map<String, Object> map = null;


    /**
     * Instantiates a new Login post.
     *
     * @param rxAppCompatActivity the rx app compat activity
     */
    public LoginPost(RxAppCompatActivity rxAppCompatActivity) {
        this.rxAppCompatActivity=rxAppCompatActivity;
        setMethod("api/User/Logon/ByPwd");
       // setCache(true);
    }

    /**
     * Gets map data.
     *
     * @return the map data
     */
    public Map<String, Object> getMapData() {
        return map;
    }

    /**
     * Sets map data.
     *
     * @param map the map
     */
    public void setMapData(Map<String, Object> map) {
        this.map = map;
    }

    @Override
    public Observable getObservable(Retrofit retrofit) {
      //  SharedPreferences SharedPreferences =rxAppCompatActivity.getSharedPreferences("UserToken",RxAppCompatActivity.MODE_PRIVATE);
        HttpPostService postService = retrofit.create(HttpPostService.class);
        return postService.PostLoginMember(Tools.getEZFSToken(Share.getString("UserToken","")), getMapData());
    }
}
