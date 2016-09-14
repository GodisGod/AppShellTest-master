package test.study.appshelltest.server;

import android.util.Log;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import rx.Subscriber;
import test.study.appshelltest.APP;
import test.study.appshelltest.R;
import test.study.appshelltest.utils.LogUtil;
import test.study.appshelltest.utils.http.HttpManager;
import test.study.appshelltest.utils.http.HttpService;

/**
 * Created by 李鸿达 on 2016/9/13.
 */
public class MovieInfoServer {

    //1、最近影讯
    public static void getRecentMovies(Subscriber<String> subscriber) {
        String host = "http://op.juhe.cn/onebox/movie/";
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("key", APP.getContext().getResources().getString(R.string.getrecentmoviekey));
        map.put("city", "上海");
        HttpManager.getInstance(host).doHttpRequest(
                HttpManager.getInstance(host).getHttpService().getRecentMovies(map)
                , subscriber
        );
    }

    //2.影视搜索
    public static void SearchMovies(Subscriber<String> subscriber) {
        String host = "http://op.juhe.cn/onebox/movie/";
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("key", APP.getContext().getResources().getString(R.string.getrecentmoviekey));
        map.put("q", "肖申克");
        HttpManager.getInstance(host).doHttpRequest(
                HttpManager.getInstance(host).getHttpService().SearchMovies(map)
                , subscriber
        );
    }

    //3.影视票房榜
    public static void getMoviesRank() {
//        String host = "http://v.juhe.cn/";
//        HashMap<String, String> map = new HashMap<String, String>();
//        map.put("key", APP.getContext().getResources().getString(R.string.getmovierankkey));
//        map.put("area", "CN");
//        HttpManager.getInstance(host).doHttpRequest(
//                HttpManager.getInstance(host).getHttpService().getMoviesRank()
//                , subscriber
//        );
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://v.juhe.cn/")
                .build();
        HttpService service = retrofit.create(HttpService.class);

        Call<ResponseBody> call = service.getMoviesRank();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        Log.i("LHD",response.body().toString());
                        //返回的结果保存在response.body()中
                        String result = response.body().string();
                        LogUtil.HDLog("\n"+result);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.i("LHD","访问失败");
            }
        });
    }
}
