package test.study.appshelltest.server;

import java.util.HashMap;

import rx.Subscriber;
import test.study.appshelltest.APP;
import test.study.appshelltest.Bean.SearchMoviesBean;
import test.study.appshelltest.R;
import test.study.appshelltest.utils.http.HttpManager;

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
    public static void getbaidu(String movie_name,Subscriber<SearchMoviesBean> subscriber) {
        String host = "http://op.juhe.cn/onebox/movie/";
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("key", APP.getContext().getResources().getString(R.string.getrecentmoviekey));
        map.put("q", movie_name);
        HttpManager.getInstance(host).doHttpRequest(
                HttpManager.getInstance(host).getHttpService().SearchMovies(map)
                , subscriber
        );
    }


    //3.影视票房榜
    public static void getMoviesRank(Subscriber<String> subscriber) {
        //传统的访问方式
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://v.juhe.cn/")
//                .build();
//        HttpService service = retrofit.create(HttpService.class);
////        HttpManager.getInstance("http://v.juhe.cn/")
////                .doHttpRequest(
////                HttpManager.getInstance("http://v.juhe.cn/").getHttpService().getMoviesRank()
////                , subscriber
////        );
//
//        Call<ResponseBody> call = service.getMoviesRank();
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                if (response.isSuccessful()) {
//                    try {
//                        Log.i("LHD", response.body().string());
//                        //返回的结果保存在response.body()中
//                        String result = response.body().string();
//                        LogUtil.HDLog("\n" + result);
//
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                Log.i("LHD", "访问失败");
//            }
//        });

        HttpManager.getInstance("http://v.juhe.cn/").doHttpRequest(
                HttpManager.getInstance("http://v.juhe.cn/").getHttpService().getMoviesRank()
                , subscriber
        );

    }



}
