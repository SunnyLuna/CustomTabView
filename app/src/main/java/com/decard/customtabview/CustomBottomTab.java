package com.decard.customtabview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class CustomBottomTab extends LinearLayout implements View.OnClickListener {
    private static final String TAG = "-----CustomBottomTab";

    /**
     * tab的枚举类型
     */
    public enum Tab {
        HOME,
        FIND,
        MALL,
        MAIN
    }

    private View mView;
    private LinearLayout ll_home, ll_find, ll_mall, ll_main;
    private ViewPager viewPager;
    private FragmentManager fragmentManager;
    private ArrayList<Fragment> fragments;
    private TabPagerAdapter mAdapter;

    public CustomBottomTab(Context context) {
        this(context, null, 0);
        Log.d(TAG, "CustomBottomTab: 1");
    }

    public CustomBottomTab(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
        Log.d(TAG, "CustomBottomTab: 2");
    }

    public CustomBottomTab(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.d(TAG, "CustomBottomTab: 3");
        mView = View.inflate(context, R.layout.custom_bottom_tab, this);
        initViews();
        setCheckedTab(Tab.HOME);
    }

    private void initViews() {
        ll_home = mView.findViewById(R.id.ll_home);
        ll_home.setOnClickListener(this);
        ll_find = mView.findViewById(R.id.ll_find);
        ll_find.setOnClickListener(this);
        ll_mall = mView.findViewById(R.id.ll_mall);
        ll_mall.setOnClickListener(this);
        ll_main = mView.findViewById(R.id.ll_main);
        ll_main.setOnClickListener(this);
        viewPager = mView.findViewById(R.id.view_pager);
    }
    public void init(FragmentManager fragmentManager, ArrayList<Fragment> fragmentList) {
        this.fragmentManager = fragmentManager;
        this.fragments = fragmentList;
        initViewPager();
    }

    private void initViewPager() {
        mAdapter = new TabPagerAdapter(fragmentManager, 0, fragments);
        if (viewPager == null) {
            Log.d(TAG, "viewPager: ");
        }
        if (mAdapter == null) {
            Log.d(TAG, "mAdapter: ");
        }
        viewPager.setAdapter(mAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //将viewPager与tab联系起来
                switch (position) {
                    case 1:
                        setCheckedTab(Tab.FIND);
                        break;
                    case 2:
                        setCheckedTab(Tab.MALL);
                        break;
                    case 3:
                        setCheckedTab(Tab.MAIN);
                        break;
                    default:
                        setCheckedTab(Tab.HOME);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_home:
                setCheckedTab(Tab.HOME);
                viewPager.setCurrentItem(0);
                break;
            case R.id.ll_find:
                setCheckedTab(Tab.FIND);
                viewPager.setCurrentItem(1);
                break;
            case R.id.ll_mall:
                setCheckedTab(Tab.MALL);
                viewPager.setCurrentItem(2);
                break;
            case R.id.ll_main:
                setCheckedTab(Tab.MAIN);
                viewPager.setCurrentItem(3);
                break;
        }
    }



    private void setCheckedTab(Tab tab) {
        unCheckedAll();
        switch (tab) {
            case HOME:
                ll_home.setActivated(true);
                break;
            case FIND:
                ll_find.setActivated(true);
                break;
            case MALL:
                ll_mall.setActivated(true);
                break;
            case MAIN:
                ll_main.setActivated(true);
                break;
        }
    }

    /**
     * 全部取消选中
     */
    private void unCheckedAll() {
        ll_home.setActivated(false);
        ll_find.setActivated(false);
        ll_mall.setActivated(false);
        ll_main.setActivated(false);
    }
}
