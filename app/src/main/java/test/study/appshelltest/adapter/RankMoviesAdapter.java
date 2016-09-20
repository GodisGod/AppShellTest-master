package test.study.appshelltest.adapter;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import test.study.appshelltest.Bean.MoviesRankBean;
import test.study.appshelltest.R;
import test.study.appshelltest.databinding.AdapterRankBinding;
import test.study.appshelltest.utils.BaseAdapter;
import test.study.appshelltest.utils.GlideCircleTransform;

/**
 * Created by 李鸿达 on 2016/9/18.
 */
public class RankMoviesAdapter extends BaseAdapter<MoviesRankBean.ResultBean> {

    private Activity mActivity;
    public RankMoviesAdapter(Activity activity ,List<MoviesRankBean.ResultBean> list) {
        super(list);
        this.mActivity = activity;
    }


    @Override
    protected ViewDataBinding getBinding(ViewGroup parent, int viewType) {
        return DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.adapter_moviesrank, parent, false);
    }

    @Override
    protected void onBindingViewHolder(BaseAdapter.BaseViewHolder holder, int position) {
        AdapterRankBinding binding = (AdapterRankBinding) holder.getBinding();
        MoviesRankBean.ResultBean rankBean = mList.get(position);


        Glide.with(mContext)
                .load(rankBean.getName())
                .transform(new GlideCircleTransform(mActivity))
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .crossFade()
                .into(binding.rankMovieImg);

        binding.rankMovieName.setText(rankBean.getName());
        binding.rankMovieWktime.setText(rankBean.getWk());
        binding.rankMovieWkMoney.setText(rankBean.getWboxoffice());
        binding.rankMovieTotalMoney.setText(rankBean.getTboxoffice());
    }

}
