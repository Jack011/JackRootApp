package com.jack.rootapp.common.net;


import com.jack.rootapp.base.BaseRespose;
import java.util.Map;
import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017-07-11.
 */

public interface APIService {


    /**
     * 样板一：请求头以及占位符
     * @param category
     * @param count
     * @param page
     * @return
     */
    @Headers("apikey:b86c2269fe6588bbe3b41924bb2f2da2")
    @GET("data/{category}/{count}/{page}")
    Observable<BaseRespose> typeOne(@Path("category")String category,
                                             @Path("count")int count,
                                             @Path("page")int page);

    /**
     * 样板二：普通参数GET请求
     * 002
     * @return
     */
    @GET("home/user/sendSms")
    Observable<BaseRespose> typeTwo(@Query("tel") String tel);



    /**
     * 样板三：数组参数GET请求
     *018
     * @return
     */

    @GET("Home/Recruitment/delete")
    Observable<BaseRespose> typeThree(@Query("user_id") String user_id,
                                              @Query("p_id[]") String[] p_id,
                                              @Query("type") String type);



    /**
     * 样板四：普通参数----POST
     *049
     * @return
     */
    @FormUrlEncoded
    @POST("Home/User/p_openid")
    Observable<BaseRespose> typeFour(@Field("type") String tel,
                                              @Field("openid") String code);

    /**
     * 样板五：单图片上传
     *026
     * @return
     */
    @Multipart
    @POST("Home/User/edit")
    Observable<BaseRespose> typeFive(@Part("user_id") RequestBody user_id,
                                         @Part MultipartBody.Part user_logo);

    /**
     * 样板六：多图片上传---POST
     * 024
     * @param p_id
     * @param user_id
     * @param logo
     * @return
     */
    @Multipart
    @POST("Home/Feedback/add")
    Observable<BaseRespose> typeSix(@Part("p_id") RequestBody p_id,
                                             @Part("user_id") RequestBody user_id,
                                             @PartMap Map<String, RequestBody> logo);

}
