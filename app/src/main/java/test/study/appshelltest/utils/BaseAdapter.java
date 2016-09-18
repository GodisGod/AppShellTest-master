package test.study.appshelltest.utils;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import test.study.appshelltest.APP;

/**
 * Created by Administrator on 2016/9/1.
 * READ ME
 * 对recyclerview的adapter和viewholder进行抽取，主要包含binding和item的点击事件，需要其他的可以自己添加
 */
public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseAdapter.BaseViewHolder> {

    protected List<T> mList = new ArrayList<>();
    protected Context mContext;
    private OnRecyclerItemClickListener mOnRecyclerItemClickListener;

    public interface OnRecyclerItemClickListener {
        boolean onRecyclerItemClick(RecyclerView.ViewHolder holder, View view, int position);
    }

    public BaseAdapter(List<T> list) {
        mContext = APP.getContext();
        mList = list;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = getBinding(parent, viewType);
        return new BaseViewHolder(binding);
    }

    /**
     * 获取binding对象
     */
    protected abstract ViewDataBinding getBinding(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(BaseAdapter.BaseViewHolder holder, int position) {
        onBindingViewHolder(holder, position);
    }

    /**
     * 绑定viewholder
     **/
    protected abstract void onBindingViewHolder(BaseViewHolder holder, int position);

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public void setOnRecyclerItemClickListener(OnRecyclerItemClickListener onRecyclerItemClickListener) {
        mOnRecyclerItemClickListener = onRecyclerItemClickListener;
    }


    public class BaseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ViewDataBinding binding;

        public BaseViewHolder(View itemView) {
            super(itemView);
            initListener();
        }

        public BaseViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            initListener();
        }

        private void initListener() {
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mOnRecyclerItemClickListener != null) {
                mOnRecyclerItemClickListener.onRecyclerItemClick(this, view, getAdapterPosition());
            }
        }

        public ViewDataBinding getBinding() {
            return binding;
        }
    }
}
