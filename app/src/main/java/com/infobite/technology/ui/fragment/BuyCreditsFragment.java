package com.infobite.technology.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.infobite.technology.R;
import com.infobite.technology.ui.activity.SeletctPaymentActivity;
import com.infobite.technology.ui.activity.WelcomeScreenActivity;
import com.infobite.technology.utils.BaseFragment;

public class BuyCreditsFragment extends  BaseFragment implements View.OnClickListener{
    private View rootview;
    private ViewPager viewPager;
    private int [] layout;
    private TextView[] dots;
    private LinearLayout dotLayout;
    private int currentPage;
    private MyGiftViewPagerAdapter giftViewPagerAdapter;

    private LinearLayout llgotosubcription,llmonsubscription,ll_monthly_coupan;

    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.layout_buycredits_fragment, container, false);
        init();
        return rootview;

    }

    private void init() {
        mContext = getActivity();
        viewPager = rootview.findViewById(R.id.vp_gift_viewpager);
        dotLayout = rootview.findViewById(R.id.layout_Dots);
        llgotosubcription = rootview.findViewById(R.id.ll_gotosub);
        llgotosubcription.setOnClickListener(this);
        llmonsubscription = rootview.findViewById(R.id.ll_monsub);
        llmonsubscription.setOnClickListener(this);
        rootview.findViewById(R.id.btn_buy_coupan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(mContext, SeletctPaymentActivity.class);
                startActivity(intent1);
            }});
      /*  rootview.findViewById(R.id.buy_coupan1).setOnClickListener(this);
        rootview.findViewById(R.id.buy_coupan2).setOnClickListener(this);
        rootview.findViewById(R.id.buy_coupan3).setOnClickListener(this);*/


        layout = new int[]{
                R.layout.layout_gift1,
                R.layout.layout_gift2,
                R.layout.layout_gift3,
        };
        addBottomDots(0);
        changeStatusBarColor();

        giftViewPagerAdapter = new MyGiftViewPagerAdapter();
        viewPager.setAdapter(giftViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
    }
    private void addBottomDots(int currentPage) {
        dots = new TextView[layout.length];

        int[] colorsActive = getResources().getIntArray(R.array.active_grift_card);
        int[] colorsInactive = getResources().getIntArray(R.array.inactive_grift_card);

        dotLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(mContext);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            dotLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };
    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_gotosub:
                ((View) rootview.findViewById(R.id.view_gs)).setVisibility(View.VISIBLE);
                ((TextView) rootview.findViewById(R.id.tv_gotosub)).setTextColor(getResources().getColor(R.color.white));
                ((ViewPager) rootview.findViewById(R.id.vp_gift_viewpager)).setVisibility(View.VISIBLE);
                ((View) rootview.findViewById(R.id.view_ms)).setVisibility(View.GONE);
                ((TextView) rootview.findViewById(R.id.tv_monsub)).setTextColor(getResources().getColor(R.color.gray_f));
                ((LinearLayout) rootview.findViewById(R.id.ll_monthly_coupan)).setVisibility(View.GONE);

                break;
            case R.id.ll_monsub:
                ((View) rootview.findViewById(R.id.view_ms)).setVisibility(View.VISIBLE);
                ((TextView) rootview.findViewById(R.id.tv_monsub)).setTextColor(getResources().getColor(R.color.white));
                ((LinearLayout) rootview.findViewById(R.id.ll_monthly_coupan)).setVisibility(View.VISIBLE);
                ((View) rootview.findViewById(R.id.view_gs)).setVisibility(View.GONE);
                ((TextView) rootview.findViewById(R.id.tv_gotosub)).setTextColor(getResources().getColor(R.color.gray_f));
                ((ViewPager) rootview.findViewById(R.id.vp_gift_viewpager)).setVisibility(View.GONE);
                break;
            case R.id.btn_buy_coupan:
               /* Intent intent = new Intent(mContext, SeletctPaymentActivity.class);
                startActivity(intent);*/
                break;
            case R.id.buy_coupan1:
              /*  Intent intent1 = new Intent(mContext, SeletctPaymentActivity.class);
                startActivity(intent1)*/;
                break;
            case R.id.buy_coupan2:
               /* Intent intent2 = new Intent(mContext, SeletctPaymentActivity.class);
                startActivity(intent2);*/
                break;
            case R.id.buy_coupan3:
              /*  Intent intent3 = new Intent(mContext, SeletctPaymentActivity.class);
                startActivity(intent3);*/
                break;
        }
    }

    public class MyGiftViewPagerAdapter  extends PagerAdapter {
        private LayoutInflater layoutInflater;

        public MyGiftViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(layout[position], container, false);

            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return layout.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }

  /*  private FragmentManager getSupportFragmentManager() {
        return getFragmentManager();
    }

    private class MyGiftPagerAdapter extends FragmentPagerAdapter    {
        public MyGiftPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i){
                case 0:
                    Layout1 layout1 = new Layout1();
                    return layout1;
                case 1:
                    Layout2 layout2 = new Layout2();
                    return layout2;
                case 2:
                    Layout3 layout3 = new Layout3();
                    return layout3;
                    default:
                        Layout1 layout0 = new Layout1();
                        return layout0;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }


    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }*/
}
