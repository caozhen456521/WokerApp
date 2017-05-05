package com.qingzu.DownFile;

import android.os.Environment;
import android.widget.Toast;

import com.wzgiceman.rxretrofitlibrary.retrofit_rx.RxRetrofitApp;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod.DownInfo;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod.DownState;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.downlaod.HttpDownManager;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.HttpDownOnNextListener;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.utils.DbDwonUtil;

import java.io.File;
import java.util.List;

/**
 * Created by Administrator on 2017/4/20.
 */

public class DownFile {

    private static DownFile downFile;
    List<DownInfo> listData;
    DbDwonUtil dbUtil;
    DownInfo apkApi;
    HttpDownManager manager;
    /*数据*/

    public static DownFile getInstance() {
        if (downFile == null) {
            synchronized (DownFile.class) {
                if (downFile == null) {
                    downFile = new DownFile();
                }
            }
        }
        return downFile;
    }

    public void initResource(String url) {
        dbUtil = DbDwonUtil.getInstance();
        listData = dbUtil.queryDownAll();
        manager = HttpDownManager.getInstance();
        /*第一次模拟服务器返回数据掺入到数据库中*/
        if (listData.isEmpty()) {
            String[] downUrl = new String[]{url};
            for (int i = 0; i < downUrl.length; i++) {

                File outputFile = new File(Environment.getExternalStorageDirectory() + "/Ezufangshui_twoCode/", "memberPhoto.png");
//                File outputFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
//                        "test"+i + ".apk");
                DownInfo apkApi = new DownInfo(downUrl[i]);
                apkApi.setId(i);
                apkApi.setState(DownState.START);
                apkApi.setSavePath(outputFile.getAbsolutePath());
                dbUtil.save(apkApi);
            }
            //   listData=dbUtil.queryDownAll();
            apkApi = dbUtil.queryDownAll().get(0);
            apkApi.setListener(httpProgressOnNextListener);
            if (apkApi.getState() != DownState.FINISH) {
                manager.startDown(apkApi);
            }
        }
    }

    /*下载回调*/
    HttpDownOnNextListener<DownInfo> httpProgressOnNextListener = new HttpDownOnNextListener<DownInfo>() {
        @Override
        public void onNext(DownInfo baseDownEntity) {
            //   tvMsg.setText("提示：下载完成");
            Toast.makeText(RxRetrofitApp.getApplication(), baseDownEntity.getSavePath(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onStart() {
            // tvMsg.setText("提示:开始下载");
        }

        @Override
        public void onComplete() {

            //tvMsg.setText("提示：下载结束");
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            //   tvMsg.setText("失败:"+e.toString());
        }


        @Override
        public void onPuase() {
            super.onPuase();
            //   tvMsg.setText("提示:暂停");
        }

        @Override
        public void onStop() {
            super.onStop();
        }

        @Override
        public void updateProgress(long readLength, long countLength) {
//            tvMsg.setText("提示:下载中");
//            progressBar.setMax((int) countLength);
//            progressBar.setProgress((int) readLength);
        }
    };

}
