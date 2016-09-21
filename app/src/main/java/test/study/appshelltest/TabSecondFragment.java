package test.study.appshelltest;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import rx.Subscriber;
import test.study.appshelltest.adapter.ShowingAdapter;
import test.study.appshelltest.adapter.WillShowAdapter;
import test.study.appshelltest.databinding.SencondFragBinding;
import test.study.appshelltest.server.MovieInfoServer;
import test.study.appshelltest.server.MoviesJsonUtil;
import test.study.appshelltest.utils.LogUtil;

/**
 * Created by ${鸿达} on 2016/8/23.
 */
public class TabSecondFragment extends Fragment {
    private SencondFragBinding binding;
    private ShowingAdapter showingAdapter;
    private WillShowAdapter willShowAdapter;

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

                        MoviesJsonUtil.analysis(s);


                        showingAdapter = new ShowingAdapter(Constant.showingBeanList);
                        willShowAdapter = new WillShowAdapter(Constant.willShowBeanList);
                        LogUtil.HDLog("==电影L+++"+Constant.showingBeanList.size());
//                        LinearLayoutManager manager = new LinearLayoutManager(getContext());
//                        manager.setOrientation(LinearLayoutManager.VERTICAL);
//                        binding.showingList.setLayoutManager(manager);
//                        binding.showingList.setHasFixedSize(true);
//                        binding.showingList.setAdapter(showingAdapter);
                        LinearLayoutManager manager2 = new LinearLayoutManager(getContext());
                        manager2.setOrientation(LinearLayoutManager.VERTICAL);
                        binding.willShowList.setLayoutManager(manager2);
                        binding.willShowList.setHasFixedSize(true);
                        binding.willShowList.setAdapter(willShowAdapter);
                    }
                });
            }
        });

        return binding.getRoot();
    }
}
