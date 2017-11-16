package com.aprivate.thinklibrary.utils;

import com.aprivate.thinklibrary.gson.GsonConverterFactory;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by sss on 2017/9/8.
 * 只是创建一个普通的Retrofit或者带有Interceptor的Retrofit，或者直接获取一个指定的api对象
 * ServiceApi和请求，响应不封装，封装的话耦合性太高，还是原来的就好且别于阅读
 */

public class ThinkRetrofitUtil {

    /**
     * 创建一个普通的Retrofit
     *
     * @param baseUrl 这个Retrofit的BaseUrl
     * @return 返还一个Retrofit实例
     */
    public static Retrofit createRetrofit(String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    /**
     * 创建一个带有指定拦截器的Retrofit
     * 关于拦截器可以查看http://blog.csdn.net/oyangyujun/article/details/50039403
     *
     * @param baseUrl
     * @param interceptor
     * @return
     */
    public static Retrofit createRetrofitWithInterceptor(String baseUrl, Interceptor interceptor) {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }

    /**
     * 创建一个带有指定拦截器的可以配合RxJava使用的Retrofit
     * 关于拦截器可以查看http://blog.csdn.net/oyangyujun/article/details/50039403
     *
     * @param baseUrl
     * @param interceptor
     * @return
     */
    public static Retrofit createRxRetrofitWithInterceptor(String baseUrl, Interceptor interceptor) {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }

    /**
     * 创建一个可以配合RxJava使用的Retrofit
     *
     * @param baseUrl
     * @return
     */
    public static Retrofit createRetrofitWithRxAdapter(String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;
    }

    /**
     * 创建一个Retrofit，返回一个api，因为参数问题，我们还是把请求参数交给外面做
     *
     * @param baseUrl 基础url
     * @param service api，传入参数是xxxApi.class
     */

    public static <T> T getApi(String baseUrl, Class<T> service) {
        return createRetrofit(baseUrl).create(service);      //获取指定的api对象
    }

    /**
     * 创建一个Retrofit，返回一个api，因为参数问题，我们还是把请求参数交给外面做
     * (和上面不同的是这个要配合RxJava使用)
     *
     * @param baseUrl 基础url
     * @param service api，传入参数是xxxApi.class
     */

    public static <T> T getRxApi(String baseUrl, Class<T> service) {
        return createRetrofitWithRxAdapter(baseUrl).create(service);      //获取指定的api对象
    }

}
