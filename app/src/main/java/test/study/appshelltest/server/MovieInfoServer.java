package test.study.appshelltest.server;

import java.util.HashMap;

import rx.Subscriber;
import test.study.appshelltest.APP;
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
                HttpManager.getInstance(host).getHttpService().getRelatedMovies(map)
                , subscriber
        );
    }

    //2.
}
