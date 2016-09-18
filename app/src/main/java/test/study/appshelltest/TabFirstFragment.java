package test.study.appshelltest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import test.study.appshelltest.Bean.MoviesRankBean;
import test.study.appshelltest.adapter.RankMoviesAdapter;
import test.study.appshelltest.server.MovieInfoServer;
import test.study.appshelltest.utils.GsonConvert;
import test.study.appshelltest.utils.LogUtil;

/**
 * Created by ${鸿达} on 2016/8/23.
 */
public class TabFirstFragment extends Fragment {
    private SwipeRefreshLayout swipeRefreshLayout;
    private List<MoviesRankBean.ResultBean> ranklist;
    private RecyclerView ranklistview;
    private RankMoviesAdapter adapter;
    private Button btn_getrecentmovie;
    private Activity activity;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.firsttag, null);
        ranklistview = (RecyclerView) view.findViewById(R.id.rank_list);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refreshLayout);
        ranklist = new ArrayList<MoviesRankBean.ResultBean>();
        activity = getActivity();
        swipeRefreshLayout.setColorSchemeResources(R.color.base, R.color.green, R.color.colorAccent);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getContext(), "刷新中。。。", Toast.LENGTH_SHORT).show();
                // TODO Auto-generated method stub
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        Toast.makeText(getContext(), "刷新完成", Toast.LENGTH_SHORT).show();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 3000);

            }
        });


        btn_getrecentmovie = (Button) view.findViewById(R.id.get_recent_movie);
        btn_getrecentmovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           /*     MovieInfoServer.getRecentMovies(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        LogUtil.HDLog("getRecentMovies onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.HDLog("getRecentMovies onError" + e.getMessage());
                    }

                    @Override
                    public void onNext(String s) {
                        LogUtil.HDLog("getRecentMovies onNext 获取最新电影： " + s);
                    }
                });

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
                        LogUtil.HDLog("list  == "+ranklist.size());
                        adapter = new RankMoviesAdapter(getActivity(),ranklist);

                        LinearLayoutManager manager = new LinearLayoutManager(getContext());
                        ranklistview.setLayoutManager(manager);
                        ranklistview.setHasFixedSize(true);
                        ranklistview.setAdapter(adapter);
                    }
                });
            }
        });
        return view;
    }
}
