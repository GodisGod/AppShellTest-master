package test.study.appshelltest;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import test.study.appshelltest.Bean.MoviesRankBean;
import test.study.appshelltest.adapter.RankMoviesAdapter;
import test.study.appshelltest.databinding.MoviesRankBinding;
import test.study.appshelltest.server.MovieInfoServer;
import test.study.appshelltest.utils.GsonConvert;
import test.study.appshelltest.utils.LogUtil;

/**
 * Created by ${鸿达} on 2016/8/23.
 */
public class TabFirstFragment extends Fragment {
    private List<MoviesRankBean.ResultBean> ranklist;
    private RankMoviesAdapter adapter;
    private Activity activity;
    private MoviesRankBinding binding;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.firsttag,container,false);

        ranklist = new ArrayList<MoviesRankBean.ResultBean>();
        activity = getActivity();
        binding.refreshLayout.setColorSchemeResources(R.color.base, R.color.green, R.color.colorAccent);
        binding.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getContext(), "刷新中。。。", Toast.LENGTH_SHORT).show();
                // TODO Auto-generated method stub
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        Toast.makeText(getContext(), "刷新完成", Toast.LENGTH_SHORT).show();
                        binding.refreshLayout.setRefreshing(false);
                    }
                }, 3000);

            }
        });


        binding.getRecentMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           /*
                MovieInfoServer.SearchMovies(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        LogUtil.HDLog("SearchMovies onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.HDLog("SearchMovies onError  " + e.getMessage());
                    }

                    @Override
                    public void onNext(String s) {
                        LogUtil.HDLog("SearchMovies onNext  " + s);
                    }
                });*/

                MovieInfoServer.getMoviesRank(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.HDLog("电影票房榜onError： " + e.getMessage());
                    }

                    @Override
                    public void onNext(String s) {
                        LogUtil.HDLog("电影票房榜： " + s);
                        MoviesRankBean rankBean = GsonConvert.parseJson(s, MoviesRankBean.class);
                        ranklist = rankBean.getResult();
                        LogUtil.HDLog("list  == " + ranklist.size());
                        adapter = new RankMoviesAdapter(getActivity(), ranklist);

                        LinearLayoutManager manager = new LinearLayoutManager(getContext());
                        binding.rankList.setLayoutManager(manager);
                        binding.rankList.setHasFixedSize(true);
                        binding.rankList.setAdapter(adapter);
                    }
                });
            }
        });
        return binding.getRoot();
    }
}
