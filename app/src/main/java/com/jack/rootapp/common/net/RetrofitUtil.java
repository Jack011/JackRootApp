package com.jack.rootapp.common.net;


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Administrator on 2017-07-11.
 */

public class RetrofitUtil {

    //private static final String baseUrl="http://192.168.1.164/m_shop/";
    private static final String baseUrl="http://47.92.103.1/m_shop/";
    private static APIService SERVICE;
    /**
     * 请求超时时间
     */
    private static final int DEFAULT_TIMEOUT = 10000;

    public static APIService initAPIService() {
        if (SERVICE == null) {
            //手动创建一个OkHttpClient并设置超时时间
            OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
            httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
            /**
             * 在这里对所有请求添加请求头
             * 或者在APIService接口方法中通过@Header("key:value")为单个请求添加请求头
             */
//            httpClientBuilder.addInterceptor(new Interceptor() {
//                @Override
//                publicxx okhttp3.Response intercept(Chain chain) throws IOException {
//                    Request request = chain.request();
//                    okhttp3.Response originalResponse = chain.proceed(request);
//                    return originalResponse.newBuilder().header("key1", "value1").addHeader("key2", "value2").build();
//                }
//            });
            SERVICE = new Retrofit.Builder()
                    .client(httpClientBuilder.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    //.baseUrl(Constant.BASE_URL)
                    .baseUrl(baseUrl)
                    .build()
                    .create(APIService.class);
        }
        return SERVICE;
    }


    /**
     * 下面是接口接口请求示例
     */
//    private void doLogin(){
//        RetrofitUtil.initAPIService().doLogin("jack666","123456")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<String>() {
//                    @Override
//                    publicxx void accept(@NonNull String s) throws Exception {
//                        //// TODO: 2017-07-12
//                    }
//                });
//    }

}
