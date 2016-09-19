package test.study.appshelltest;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import rx.Subscriber;
import test.study.appshelltest.databinding.SencondFragBinding;
import test.study.appshelltest.server.MovieInfoServer;
import test.study.appshelltest.server.MoviesJsonUtil;
import test.study.appshelltest.utils.LogUtil;

/**
 * Created by ${鸿达} on 2016/8/23.
 */
public class TabSecondFragment extends Fragment {
    private SencondFragBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.secondtag, container, false);

        binding.getShowingMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MovieInfoServer.getRecentMovies(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        LogUtil.HDLog("getRecentMovies onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.HDLog("getRecentMovies onError" + e.getMessage());
                    }

                    @Override
                    public void onNext(final String s) {
                        LogUtil.HDLog("getRecentMovies onNext 获取最新电影： " + s);
                       new Thread(new Runnable() {
                           @Override
                           public void run() {
                               LogUtil.HDLog("解析电影： ");
                               MoviesJsonUtil.analysis(s);
                           }
                       }).start();
                    }
                });
            }
        });

        binding.getWillMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtil.HDLog("dfadfaf:  ");
                MovieInfoServer.getRecentMovies(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        LogUtil.HDLog("aaaaaaaaaaaaaa:  " + s);
                    }
                });
            }
        });

        return binding.getRoot();
    }
}
