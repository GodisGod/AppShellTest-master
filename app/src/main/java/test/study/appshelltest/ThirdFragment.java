package test.study.appshelltest;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import rx.Subscriber;
import test.study.appshelltest.Bean.SearchMoviesBean;
import test.study.appshelltest.databinding.SearchBinding;
import test.study.appshelltest.server.MovieInfoServer;
import test.study.appshelltest.utils.LogUtil;

/**
 * Created by ${鸿达} on 2016/8/23.
 */
public class ThirdFragment extends Fragment {
    private SearchBinding binding;
    private String movie_name;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.thirdtag, container, false);


        binding.startSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movie_name = binding.searchName.getText().toString();
                if (!movie_name.isEmpty()) {
                    MovieInfoServer.SearchMovies(movie_name, new Subscriber<SearchMoviesBean>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            LogUtil.HDLog("没有搜索到：：" + e.getMessage());
                        }

                        @Override
                        public void onNext(SearchMoviesBean s) {
                            LogUtil.HDLog("搜索电影：  " + s.getResult().toString());
                            SearchMoviesBean.ResultBean resultBean = s.getResult();
                            binding.searchMovieName.setText(resultBean.getTitle());
                            binding.searchMovieType.setText(resultBean.getTag());
                            binding.searchStarBrief.setText(resultBean.getDesc());
                            binding.searchStarName.setText(resultBean.getAct());
                            Glide.with(getContext())
                                    .load(resultBean.getCover())
                                    .placeholder(R.mipmap.ic_launcher)
                                    .error(R.mipmap.ic_launcher)
                                    .crossFade()
                                    .into(binding.searchMovieImg);
                        }
                    });
                } else {
                    Toast.makeText(getContext(), "请输入电影名字", Toast.LENGTH_SHORT).show();
                }

            }
        });


        return binding.getRoot();
    }
}
