package test.study.appshelltest;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by marks on 2016/5/9.
 */
public class ListFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragmentList;
    private Context context;

    public ListFragmentPagerAdapter(FragmentManager fm, Context context, List<Fragment> fragments) {
        super(fm);
        this.context = context;
        this.mFragmentList = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return (mFragmentList == null || mFragmentList.size() < Constant.TAB_COUNT) ? null : mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList == null ? 0 : mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Constant.STRTITLE[position];
    }

    public View getTabView(int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.tab_item, null);
        ImageView iv_tab = (ImageView) view.findViewById(R.id.iv_tab);
        iv_tab.setBackgroundDrawable(addStateDrawable(context, Constant.TABICON_UNSELECTED[position], Constant.TABICON_SELECTED[position]));
        return view;
    }

    private StateListDrawable addStateDrawable(Context context, int idNormal, int idPressed) {
        StateListDrawable sd = new StateListDrawable();
        Drawable normal = idNormal == -1 ? null : context.getResources().getDrawable(idNormal);
        Drawable pressed = idPressed == -1 ? null : context.getResources().getDrawable(idPressed);
        sd.addState(new int[]{android.R.attr.state_selected}, pressed);
        sd.addState(new int[]{}, normal);
        return sd;
    }
}
