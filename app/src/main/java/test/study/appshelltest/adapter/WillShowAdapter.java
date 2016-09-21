package test.study.appshelltest.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import test.study.appshelltest.Bean.WillShowBean;
import test.study.appshelltest.R;
import test.study.appshelltest.databinding.WillShowItemBinding;
import test.study.appshelltest.utils.BaseAdapter;

/**
 * Created by 李鸿达 on 2016/9/21.
 */
public class WillShowAdapter extends BaseAdapter<WillShowBean> {
    public WillShowAdapter(List<WillShowBean> list) {
        super(list);
    }

    @Override
    protected ViewDataBinding getBinding(ViewGroup parent, int viewType) {
        return DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.item_willshow_movie, parent, false);
    }

    @Override
    protected void onBindingViewHolder(BaseAdapter.BaseViewHolder holder, int position) {
        WillShowItemBinding binding = (WillShowItemBinding) holder.getBinding();
        WillShowBean willShowBean = mList.get(position);


        Glide.with(mContext)
                .load(willShowBean.getW_icon())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .crossFade()
                .into(binding.willShowMovieImg);

        binding.willShowMovieName.setText(willShowBean.getW_movie_name());
        StringBuffer sb = new StringBuffer();
        for (String s : willShowBean.getWilltypes()) {
            sb.append(s + " ");
        }
        binding.willShowMovieType.setText(sb);
        StringBuffer sb2 = new StringBuffer();
        for (String n :
                willShowBean.getWillactors()) {
            sb2.append(n + " ");
        }
        binding.willShowStarName.setText(sb2);
        binding.willShowStarBrief.setText(willShowBean.getW_story_brief());
    }
}
