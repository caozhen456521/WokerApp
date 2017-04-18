package com.qingzu.waterproof_work;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.qingzu.Application.StatusTool;
import com.qingzu.custom.control.PermissionsChecker;
import com.qingzu.entity.api.RefreshToken;
import com.qingzu.entity.resulte.InterfaceReturn;
import com.qingzu.entity.resulte.LoginMember;
import com.qingzu.utils.http.tools.SPUtils;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.exception.ApiException;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.http.HttpManager;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.HttpOnNextListener;
import com.yjx.sharelibrary.Share;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public class WelcomeActivity extends BaseActivity implements HttpOnNextListener {


    private Boolean isFirst = false;
    private String UserToken = null;
    private HttpManager manager = null;
    private RefreshToken refreshToken = null;
    private static final int REQUEST_CODE = 0; // 请求码

    // 所需的全部权限
    static final String[] PERMISSIONS = new String[]{
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.MODIFY_AUDIO_SETTINGS
    };
    private PermissionsChecker mPermissionsChecker; // 权限检测器
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
     //   initviews();
        mPermissionsChecker = new PermissionsChecker(this);
    }

    public void initviews() {
        manager = new HttpManager(this, this);
        refreshToken = new RefreshToken(this);
        String UserToken = Share.getString( "UserToken", "");
       // isFirst = (Boolean) SPUtils.get(this, "UserToken", true);
        isFirst =Share.getBoolean("isFirst",true);
        Observable.timer(2, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(new Subscriber<Long>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Long aLong) {

                StatusTool.isWelcome = true;
                if (isFirst == true) {
                    Log.e("-------------Long",aLong.toString());
                    startActivity(new Intent(WelcomeActivity.this,GuideActivity.class));
              finish();
                } else
                    {

                    //   manager = new HttpManager(this, this);
                    manager.doHttpDeal(refreshToken);
//                    if (UserToken != null&&UserToken.equals("")) {
//}
//
//                    }
                }
                }

        });

    }

    @Override
    public void onNext(String resulte, String method) {
        if (method.equals(refreshToken.getMethod())) {
            InterfaceReturn<LoginMember> interfaceReturn = new InterfaceReturn<LoginMember>();
            interfaceReturn = InterfaceReturn.fromJson(resulte,
                    LoginMember.class);
            if (interfaceReturn != null) {
                if (interfaceReturn.isStatus()) {
//                    SharedPreferences sharedPreferences = getSharedPreferences(
//                            SPUtils.FILE_NAME, RxAppCompatActivity.MODE_PRIVATE);
//                    SharedPreferences.Editor edit = sharedPreferences.edit();
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

    }
    @Override protected void onResume() {
        super.onResume();

        // 缺少权限时, 进入权限配置页面
        if (mPermissionsChecker.lacksPermissions(PERMISSIONS)) {
            startPermissionsActivity();
        }else{
            initviews();
        }

    }

    private void startPermissionsActivity() {
        PermissionsActivity.startActivityForResult(this, REQUEST_CODE, PERMISSIONS);
    }

    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 拒绝时, 关闭页面, 缺少主要权限, 无法运行
        if (requestCode == REQUEST_CODE && resultCode == PermissionsActivity.PERMISSIONS_DENIED) {
            finish();
        }
    }
}
