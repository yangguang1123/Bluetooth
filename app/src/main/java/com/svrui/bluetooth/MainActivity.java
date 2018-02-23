package com.svrui.bluetooth;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements OnClickListener {
    //声明ViewPager
    private ViewPager mViewpager;

    //声明四个Tab
    private LinearLayout mTabBendi;
    private LinearLayout mTabShebei;
    private LinearLayout mTabCeshi;
    private LinearLayout mTabShezhi;

    //声明四个ImageButton
    private ImageButton mBendiImg;
    private ImageButton mShebeiImg;
    private ImageButton mCeshiImg;
    private ImageButton mShezhiImg;

    //声明ViewPager的适配器
    private PagerAdapter mAdpater;
    //用于装载四个Tab的List
    private List<View> mTabs = new ArrayList<View>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉TitleBar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initViews();//初始化控件
        initDatas();//初始化数据
        initEvents();//初始化事件

    }

    private void initEvents() {
        //设置四个Tab的点击事件
        mTabBendi.setOnClickListener(this);
        mTabShebei.setOnClickListener(this);
        mTabCeshi.setOnClickListener(this);
        mTabShezhi.setOnClickListener(this);

        //添加ViewPager的切换Tab的监听事件
        mViewpager.addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //获取ViewPager的当前Tab
                int currentItem = mViewpager.getCurrentItem();
                //将所以的ImageButton设置成灰色
                resetImgs();
                //将当前Tab对应的ImageButton设置成绿色
                switch (currentItem) {
                    case 0:
                        mBendiImg.setImageResource(R.drawable.bendi);
                        break;
                    case 1:
                        mShebeiImg.setImageResource(R.drawable.shebei);
                        break;
                    case 2:
                        mCeshiImg.setImageResource(R.drawable.ceshi);
                        break;
                    case 3:
                        mShezhiImg.setImageResource(R.drawable.shebei);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initDatas() {
        //初始化ViewPager的适配器
        mAdpater = new PagerAdapter() {
            @Override
            public int getCount() {
                return mTabs.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = mTabs.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
//                super.destroyItem(container, position, object);
                container.removeView(mTabs.get(position));
            }
        };
        //设置ViewPager的适配器
        mViewpager.setAdapter(mAdpater);
    }

    //初始化控件
    private void initViews() {
        mViewpager = (ViewPager) findViewById(R.id.id_viewpager);

        mTabBendi = (LinearLayout) findViewById(R.id.id_tab_bendi);
        mTabShebei = (LinearLayout) findViewById(R.id.id_tab_shebei);
        mTabCeshi = (LinearLayout) findViewById(R.id.id_tab_ceshi);
        mTabShezhi = (LinearLayout) findViewById(R.id.id_tab_shezhi);

        mBendiImg = (ImageButton) findViewById(R.id.id_tab_bendi_img);
        mShebeiImg = (ImageButton) findViewById(R.id.id_tab_shebei_img);
        mCeshiImg = (ImageButton) findViewById(R.id.id_tab_ceshi_img);
        mShezhiImg = (ImageButton) findViewById(R.id.id_tab_shezhi_img);

        //获取到四个Tab
        LayoutInflater inflater = LayoutInflater.from(this);
        View tab1 = inflater.inflate(R.layout.tab1, null);
        View tab2 = inflater.inflate(R.layout.tab2, null);
        View tab3 = inflater.inflate(R.layout.tab3, null);
        View tab4 = inflater.inflate(R.layout.tab4, null);

        //将四个Tab添加到集合中
        mTabs.add(tab1);
        mTabs.add(tab2);
        mTabs.add(tab3);
        mTabs.add(tab4);

    }

    @Override
    public void onClick(View v) {
        //先将四个ImageButton都设置成灰色
        resetImgs();
        switch (v.getId()) {
            case R.id.id_tab_bendi:
                //设置viewPager的当前Tab
                mViewpager.setCurrentItem(0);
                //将当前Tab对应的ImageButton设置成绿色
                mBendiImg.setImageResource(R.drawable.bendi);
                break;
            case R.id.id_tab_shebei:
                mViewpager.setCurrentItem(1);
                mShebeiImg.setImageResource(R.drawable.shebei);
                break;
            case R.id.id_tab_ceshi:
                mViewpager.setCurrentItem(2);
                mCeshiImg.setImageResource(R.drawable.ceshi);
                break;
            case R.id.id_tab_shezhi:
                mViewpager.setCurrentItem(3);
                mShezhiImg.setImageResource(R.drawable.shebei);
                break;
        }
    }

    @Override
    public Intent getIntent() {
        return super.getIntent();
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    //将四个ImageButton设置成灰色
    private void resetImgs () {
        mBendiImg.setImageResource(R.drawable.bendi);
        mShebeiImg.setImageResource(R.drawable.shebei);
        mCeshiImg.setImageResource(R.drawable.ceshi);
        mShezhiImg.setImageResource(R.drawable.shebei);
    }
}
