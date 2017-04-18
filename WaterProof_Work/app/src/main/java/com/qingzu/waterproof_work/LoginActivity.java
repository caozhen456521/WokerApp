package com.qingzu.waterproof_work;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.qingzu.entity.api.LoginPost;
import com.qingzu.entity.resulte.InterfaceReturn;
import com.qingzu.entity.resulte.LoginMember;
import com.qingzu.waterproof_work.databinding.ActivityLoginBinding;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.exception.ApiException;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.http.HttpManager;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.HttpOnNextListener;
import com.yjx.sharelibrary.Share;
import java.util.HashMap;
import java.util.Map;


public class LoginActivity extends BaseActivity implements HttpOnNextListener {

    private HttpManager manager = null;

    private LoginPost loginPost = null;

    private ActivityLoginBinding activityLoginBinding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login);
      //  setContentView(R.layout.activity_login);

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
            if (interfaceReturn != null) {
                if (interfaceReturn.isStatus()) {
                    Share.putString("UserToken", interfaceReturn
                            .getResults().get(0).getToken());
                    Share.putInt("MemberId", interfaceReturn
                            .getResults().get(0).getMember().getId());
                    Share.putLong("tokenExpiredTimeStamp",
                            interfaceReturn.getResults().get(0)
                                    .getTokenExpiredTimeStamp());
                    Share.putString("Phone", interfaceReturn
                            .getResults().get(0).getMember()
                            .getContactTel());
                    Share.putString("UserName", interfaceReturn
                            .getResults().get(0).getMember()
                            .getUserName());
                    Share.putString("UserPhoto", interfaceReturn
                            .getResults().get(0).getMember()
                            .getMemberPhoto());
                    Share.putInt("IsCheck", interfaceReturn.getResults()
                            .get(0).getMember().getIsCheck());
                    Share.putBoolean("IsRealName", interfaceReturn
                            .getResults().get(0).getMember()
                            .isRealName());
                    Share.putString("NickName", interfaceReturn
                            .getResults().get(0).getMember()
                            .getNickName());
                    Share.putInt("IntegralNumber", interfaceReturn
                            .getResults().get(0).getMember()
                            .getIntegralNumber());
                    if (interfaceReturn.getResults().get(0).getMember()
                            .getDefaultRoleId() == 1) {
                        Share.putInt("identity", 2);
                    } else if (interfaceReturn.getResults().get(0)
                            .getMember().getDefaultRoleId() == 2) {
                        Share.putInt("identity", 0);
                    } else if (interfaceReturn.getResults().get(0)
                            .getMember().getDefaultRoleId() == 6) {
                        Share.putInt("identity", 1);
                    }

                }
            }
        }
    }


    @Override
    public void onError(ApiException e) {
      //  activityLoginBinding.tvMsg.setText("失败：\ncode=" + e.getCode() + "\nmsg:" + e.getDisplayMessage());
    }
}
