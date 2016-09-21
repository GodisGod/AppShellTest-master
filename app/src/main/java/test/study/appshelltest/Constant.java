package test.study.appshelltest;

import java.util.ArrayList;
import java.util.List;

import test.study.appshelltest.Bean.ShowingBean;
import test.study.appshelltest.Bean.WillShowBean;

/**
 * Created by ${鸿达} on 2016/8/23.
 */
public class Constant {
    public static final int TAB_COUNT = 2;
    public static String[] STRTITLE = new String[]{"第一页", "第二页", "第三页"};
    //选中tab
    public static final int[] TABICON_SELECTED = new int[]{R.mipmap.tab1_select, R.mipmap.tab_mine_select, R.mipmap.header2};
    //未选中tab
    public static final int[] TABICON_UNSELECTED = new int[]{R.mipmap.tab1_normal, R.mipmap.tab_mine_normal, R.mipmap.header4};

    public static List<ShowingBean> showingBeanList = new ArrayList<ShowingBean>();
    public static List<WillShowBean> willShowBeanList = new ArrayList<WillShowBean>();
}
