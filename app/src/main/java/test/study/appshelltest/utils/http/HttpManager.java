package test.study.appshelltest.utils.http;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import test.study.appshelltest.APP;

/**
 * Created by marks on 2016/8/5.
 */
public class HttpManager {

    public  String HOST = "";
    private static final int TIMEOUT = 10;
    protected HttpService httpService;
    private volatile static HttpManager httpManager;

    protected HttpManager(String host) {
        this.HOST = host;
        File cacheDirectory = new File(APP.getContext()
                .getCacheDir().getAbsolutePath(), "HttpCache");
        OkHttpClient.Builder okhttpBuilder = new OkHttpClient.Builder();
        okhttpBuilder.connectTimeout(TIMEOUT, TimeUnit.SECONDS);
        okhttpBuilder.readTimeout(TIMEOUT, TimeUnit.SECONDS);
        okhttpBuilder.writeTimeout(TIMEOUT, TimeUnit.SECONDS);
        okhttpBuilder.cache(new Cache(cacheDirectory, 10 * 1024 * 1024));
        okhttpBuilder.addInterceptor(new Interceptor() {//拦截器
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder()
                        .addHeader("Content-Type", "application/json; charset=UTF-8")
                        .addHeader("Connection", "keep-alive")
                        .addHeader("Accept", "*/*")
                        .header("Cache-Control", String.format("public, max-age=%d", 60))
                        .removeHeader("Pragma")
                        .build();
                return chain.proceed(request);
            }
        });

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .client(okhttpBuilder.build())
                .addConverterFactory(ScalarsConverterFactory.create())   //http://blog.csdn.net/u013003052/article/details/50992436
                .addConverterFactory(GsonConverterFactory.create())      //此处顺序不能和上面对调，否则不能同时兼容普通字符串和Json格式字符串
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(getHost());
        httpService = retrofitBuilder.build().create(HttpService.class);

//        使用Retrofit.Builder对象可以随时调节配置
//        Retrofit retrofit = new Retrofit.Builder()
//                .addConverterFactory(ScalarsConverterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .baseUrl(HOST)
//                .build();
//        httpService = retrofit.create(HttpService.class);
    }

    /**
     * 如果有不同的请求HOST可继承此类并Override
     *
     * @return
     */
    protected String getHost() {
        return HOST;
    }

    public HttpService getHttpService() {
        return httpService;
    }

    public static HttpManager getInstance(String host) {
        if (httpManager == null) {
            synchronized (HttpManager.class) {
                if (httpManager == null) {
                    httpManager = new HttpManager(host);
                }
            }
        }
        return httpManager;
    }

    /**
     * 处理http请求——常规
     *
     * @param pCall
     * @param pCallback
     */
    public void doHttpRequest(Call pCall, Callback pCallback) {
        Call call = pCall;
        call.enqueue(pCallback);
    }

    /**
     * 处理http请求——RX
     *
     * @param pObservable
     * @param pSubscriber
     */
    public void doHttpRequest(Observable pObservable, Subscriber pSubscriber) {
        Observable observable = pObservable
                .subscribeOn(Schedulers.io()) //指定subscribe()发生在io调度器（读写文件、读写数据库、网络信息交互等）
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()); //指定subscriber的回调发生在主线程
        observable.subscribe(pSubscriber);
    }


    /**
     * json方式传参
     *
     * @param pBody
     * @return
     */
    public RequestBody getPostBody(String pBody) {
        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), pBody);
        return body;
    }

}
