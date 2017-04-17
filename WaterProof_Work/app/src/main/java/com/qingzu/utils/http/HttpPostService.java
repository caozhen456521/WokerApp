package com.qingzu.utils.http;


import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import rx.Observable;

/**
 * 测试接口service-post相关
 * Created by WZG on 2016/12/19.
 */

public interface HttpPostService {
@GET("api/User/RefreshToken")
    Observable<String>getMember(@Header("EZFSToken") String e);

@FormUrlEncoded
@POST("api/User/Logon/ByPwd")
    Observable<String>PostLoginMember(@Header("EZFSToken") String e, @FieldMap Map<String, Object> map);

//  @POST("AppFiftyToneGraph/videoLink")
//    Call<RetrofitEntity> getAllVedio(@Header("EZFSToken") String EZFSToken, @Body boolean once_no);
//
//    @POST("AppFiftyToneGraph/videoLink")
//  //  @Header()
//    Observable<RetrofitEntity> getAllVedioBy(@Body boolean once_no);
//
//
////    @POST("AppFiftyToneGraph/videoLink")
////    Observable<BaseResultEntity<List<SubjectResulte>>> getAllVedioBys(@Body boolean once_no);
//
//
//   @GET("AppFiftyToneGraph/videoLink/{once_no}")
//    Observable<BaseResultEntity<List<SubjectResulte>>> getAllVedioBys(@Query("once_no") boolean once_no);
////    @GET("api/User/RefreshToken")
////   Observable<InterfaceReturn<LoginMember>>interfaceReturn{@Header("EZFSToken") String EZFSToken);
}
