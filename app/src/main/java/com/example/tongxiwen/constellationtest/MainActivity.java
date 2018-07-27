package com.example.tongxiwen.constellationtest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.tongxiwen.constellationtest.adapter.ImageViewPagerAdapter;
import com.example.tongxiwen.constellationtest.adapter.ViewPagerAdapter;
import com.example.tongxiwen.constellationtest.detail.beans.DailyFortune;
import com.example.tongxiwen.constellationtest.detail.beans.WeeklyFortune;
import com.example.tongxiwen.constellationtest.mvp.daily.DetailDailyFragment;
import com.example.tongxiwen.constellationtest.mvp.daily.Model;
import com.example.tongxiwen.constellationtest.mvp.weekly.DetailWeeklyFragment;
import com.example.tongxiwen.constellationtest.mvp.yearly.DetailYearlyFragment;
import com.example.tongxiwen.constellationtest.net.HttpClient;
import com.example.tongxiwen.constellationtest.util.DimenUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_view)
    Toolbar toolbar;
    @BindView(R.id.image_view_pager)
    ViewPager imageViewPager;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.fortune_view_pager)
    ViewPager fortuneViewPager;
    @BindView(R.id.point_container)
    ViewPagerPointer pointContainer;

    private String consName = "摩羯座";
    private static int[] imgSrcs = new int[]{
            R.drawable.img4,R.drawable.img2,
            R.drawable.img3,R.drawable.img1
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Intent preIntent = getIntent();

        consName = preIntent.getStringExtra("consName");
        if (consName == null) {
            SharedPreferences sp = getPreferences(MODE_PRIVATE);
            consName = sp.getString("preConsName", "摩羯座");
        }

        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        setSupportActionBar(toolbar);

        imageViewPager.setAdapter(new ImageViewPagerAdapter(this, imgSrcs));
        readyViews(consName);
        try {
            pointContainer.setUpViewPager(imageViewPager, true);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        imageViewPager.setCurrentItem(1, false);
        imageViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                int rawMax = imageViewPager.getAdapter().getCount();

                if (state == 0){
                    int position = imageViewPager.getCurrentItem();
                    if (position == 0) {
                        position = rawMax - 2;
                        imageViewPager.setCurrentItem(position, false);
                    }
                    if (position == rawMax - 1) {
                        position = 1;
                        imageViewPager.setCurrentItem(position, false);
                    }
                }
                pointContainer.setCurrent(imageViewPager.getCurrentItem());
            }
        });

        SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
        editor.putString("preConsName", consName).apply();
    }

    /**
     * 初始化轮播图定位点
     * @deprecated
     */
    private void readyPoints() {
        final int rawMax = imageViewPager.getAdapter().getCount();
        final int max =  rawMax - 2;
        final RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.leftMargin = DimenUtil.dip2px(4);
        params.rightMargin = DimenUtil.dip2px(4);
        for (int i = 0; i < max; i++){
            RadioButton rb = new RadioButton(this);
            rb.setLayoutParams(params);
            rb.setButtonDrawable(R.drawable.view_pager_pointer);
            pointContainer.addView(rb);
        }
        imageViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    position = rawMax - 2;
                }
                if (position == rawMax - 1) {
                    position = 1;
                }

                int pointPosition = position - 1;
                ((RadioButton) pointContainer.getChildAt(pointPosition)).setChecked(true);
                Log.d("测试", "position = " + position + "\n" + "pointPosition = " + pointPosition);
            }
            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == 0){
                    int position = imageViewPager.getCurrentItem();
                    if (position == 0) {
                        position = rawMax - 2;
                        imageViewPager.setCurrentItem(position, false);
                    }
                    if (position == rawMax - 1) {
                        position = 1;
                        imageViewPager.setCurrentItem(position, false);
                    }
                }
            }
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
        });
        imageViewPager.setCurrentItem(1, false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        consName = item.getTitle().toString().substring(0, 3);
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        intent.putExtra("consName", consName);
        startActivity(intent);
        finish();
        return super.onOptionsItemSelected(item);
    }

    private void readyViews(String consName) {
        List<SparseArray> fragments = new ArrayList<>();
        SparseArray<Object> sa = new SparseArray<>();

        sa.put(R.id.fragments_instance, DetailDailyFragment.newInstance(consName));
        sa.put(R.id.fragments_tab, "今日运势");
        fragments.add(sa);

        sa = new SparseArray<>();
        sa.put(R.id.fragments_instance, DetailWeeklyFragment.newInstance(consName, "week"));
        sa.put(R.id.fragments_tab, "本周运势");
        fragments.add(sa);

        sa = new SparseArray<>();
        sa.put(R.id.fragments_instance, DetailWeeklyFragment.newInstance(consName, "month"));
        sa.put(R.id.fragments_tab, "本月运势");
        fragments.add(sa);

        sa = new SparseArray<>();
        sa.put(R.id.fragments_instance, DetailYearlyFragment.newInstance(consName));
        sa.put(R.id.fragments_tab, "今年运势");
        fragments.add(sa);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);
        fortuneViewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(fortuneViewPager, true);
        for (int i = 0; i < adapter.getCount(); i++) {
            tabLayout.getTabAt(i).setText(adapter.getTabTitle(i));
        }
        fortuneViewPager.setNestedScrollingEnabled(true);

        mHandler.sendEmptyMessageDelayed(0, 3000);

    }

    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            int cur = imageViewPager.getCurrentItem();
            int max = imageViewPager.getAdapter().getCount();
            cur++;
            if (cur >= max)
                cur = 0;
            imageViewPager.setCurrentItem(cur);

            mHandler.sendEmptyMessageDelayed(0, 4500);
            return false;
        }
    });
}
