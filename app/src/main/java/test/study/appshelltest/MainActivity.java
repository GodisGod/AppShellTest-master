package test.study.appshelltest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private ViewPager viewPager;
    private ListFragmentPagerAdapter mPagerAdapter;

    private List<Fragment> mFragments = new ArrayList<>();
    private TabFirstFragment tabFindFragment;
    private TabSecondFragment tabMeFragment;
    private ThirdFragment thirdFragment;
    private TabLayout tabLayout;
    private FloatingActionButton fabs;
    private Button btn_getrecentmovie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        fabs = (FloatingActionButton) findViewById(R.id.fab);
        fabs.setImageResource(R.mipmap.tab1_normal);
        viewPager.setOffscreenPageLimit(1);


        tabFindFragment = new TabFirstFragment();
        tabMeFragment = new TabSecondFragment();
        thirdFragment = new ThirdFragment();
        mFragments.add(tabFindFragment);
        mFragments.add(tabMeFragment);
        mFragments.add(thirdFragment);

        mPagerAdapter = new ListFragmentPagerAdapter(getSupportFragmentManager(), this, mFragments);

        mOnPageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    fabs.setVisibility(View.VISIBLE);
                } else {
                    fabs.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };

        viewPager.setAdapter(mPagerAdapter);
        viewPager.addOnPageChangeListener(mOnPageChangeListener);
        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(mPagerAdapter.getTabView(i));
        }
        tabLayout.getTabAt(0).getCustomView().setSelected(true);
        viewPager.setCurrentItem(0);

        fabs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点我干什么", Toast.LENGTH_SHORT).show();
            }
        });


    }


}
