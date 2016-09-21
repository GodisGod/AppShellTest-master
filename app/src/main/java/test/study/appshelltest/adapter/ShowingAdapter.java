package test.study.appshelltest.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import test.study.appshelltest.Bean.ShowingBean;
import test.study.appshelltest.R;
import test.study.appshelltest.databinding.ShowItemBinding;
import test.study.appshelltest.utils.BaseAdapter;

/**
 * Created by 李鸿达 on 2016/9/21.
 */
public class ShowingAdapter extends BaseAdapter<ShowingBean> {
    public ShowingAdapter(List<ShowingBean> list) {
        super(list);
    }

    @Override
    protected ViewDataBinding getBinding(ViewGroup parent, int viewType) {
        return DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.item_show_movie, parent, false);
    }

    @Override
    protected void onBindingViewHolder(BaseAdapter.BaseViewHolder holder, int position) {
        ShowItemBinding binding = (ShowItemBinding) holder.getBinding();
        ShowingBean showingBean = mList.get(position);


        Glide.with(mContext)
                .load(showingBean.getIcon())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .crossFade()
                .into(binding.showMovieImg);

        binding.showMovieName.setText(showingBean.getMovie_name());
        StringBuffer sb = new StringBuffer();
        for (String s : showingBean.getShowtypes()) {
            sb.append(s + " ");
        }
        binding.showMovieType.setText(sb);
        StringBuffer sb2 = new StringBuffer();
        for (String n :
                showingBean.getShowactors()) {
            sb2.append(n + " ");
        }
        binding.showStarName.setText(sb2);
        binding.showStarBrief.setText(showingBean.getStory_brief());
    }
}
