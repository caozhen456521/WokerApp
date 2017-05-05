package com.qingzu.waterproof_work;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Toast;

import com.jakewharton.rxbinding.view.RxView;
import com.qingzu.DownFile.DownFile;
import com.qingzu.entity.api.CheckByCellPhone;
import com.qingzu.entity.api.LoginPost;
import com.qingzu.entity.resulte.InterfaceReturn;
import com.qingzu.entity.resulte.LoginMember;
import com.qingzu.utils.http.tools.Tools;
import com.qingzu.waterproof_work.databinding.ActivityLoginBinding;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.RxRetrofitApp;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod.DownInfo;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod.HttpDownManager;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.exception.ApiException;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.http.HttpManager;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.HttpDownOnNextListener;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.HttpOnNextListener;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.utils.DbDwonUtil;
import com.yjx.sharelibrary.Share;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import rx.functions.Action1;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static com.qingzu.waterproof_work.R.id.login_et_phone_number;


public class LoginActivity extends BaseActivity implements HttpOnNextListener {
    private HttpManager manager = null;
    private LoginPost loginPost = null;
    private ActivityLoginBinding activityLoginBinding = null;
    private CheckByCellPhone checkByCellPhone =null;
    private HttpDownManager downManager =null;
    private  DownInfo apkApi =null;
    private DbDwonUtil dbUtil =null;
    private List<DownInfo> listData=null;
    private DownFile downFile =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        dbUtil= DbDwonUtil.getInstance();
        IntiView();
    }
    private void IntiView() {
        manager = new HttpManager(this, this);
      //  Share.remove("UserToken");
           loginPost = new LoginPost(this);
        //  SparseArray SparseArray
        //   Map<String,Object>map1 =new　SparseArray;
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("UserName", "18698562507");
//        map.put("UserPwd", "123456");
//        loginPost.setMapData(map);
//        manager.doHttpDeal(loginPost);

        final ScaleAnimation animation =new ScaleAnimation(1f, 1.4f, 1f, 1.4f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(5000);//设置动画持续时间
        animation.setRepeatCount(0);
        animation.setFillAfter(true);
        activityLoginBinding.LoginRe.setAnimation(animation);
        animation.startNow();

//        RxView.clickEvents(activityLoginBinding.loginEtPhoneNumber)
//                .throttleFirst(500, TimeUnit.MILLISECONDS)
//                .subscribe(clickAction);
        RxView.clicks(activityLoginBinding.loginBtCommit). throttleFirst(1, TimeUnit.SECONDS).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                loginPost = new LoginPost(LoginActivity.this);
            }
        });

        activityLoginBinding.loginEtPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP:
                        if (activityLoginBinding.loginEtPhoneNumber.getText().toString().trim() == null
                                || activityLoginBinding.loginEtPhoneNumber.getText().toString()
                                .trim().equals("")) {
                            Toast.makeText(LoginActivity.this, "手机号码不能为空",
                                    Toast.LENGTH_SHORT).show();

                        } else if (!Tools.isMobileNO(activityLoginBinding.loginEtPhoneNumber
                                .getText().toString().trim())) {
                            Toast.makeText(LoginActivity.this, "手机号码输入有误",
                                    Toast.LENGTH_SHORT).show();
                        } else {
//                            getCheckByCellPhone(login_et_phone_number.getText()
//                                    .toString().trim());
                            checkByCellPhone=new CheckByCellPhone((RxAppCompatActivity) mContext);
                            checkByCellPhone.setCellPhone(activityLoginBinding.loginEtPhoneNumber.getText().toString().trim());
                            manager.doHttpDeal(checkByCellPhone);
                        }

                        break;

                    default:
                        break;
                }


                return false;
            }
        });
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
        }else if (method.equals(checkByCellPhone.getMethod())){
            InterfaceReturn interfaceReturn = new InterfaceReturn();
            interfaceReturn = InterfaceReturn.fromJsonModel(resulte);
            if (interfaceReturn != null) {
                if (interfaceReturn.isStatus()) {
                    Toast.makeText(LoginActivity.this, "该手机号尚未注册",
                            Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(LoginActivity.this,
//                            RegistActivity.class));
                } else {

                }
            }
        };
    }


    @Override
    public void onError(ApiException e) {

      //  activityLoginBinding.tvMsg.setText("失败：\ncode=" + e.getCode() + "\nmsg:" + e.getDisplayMessage());
    }



}
