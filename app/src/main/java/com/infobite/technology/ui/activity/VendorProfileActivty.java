package com.infobite.technology.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.infobite.technology.R;
import com.infobite.technology.adapter.ProfileFragmentViewpagerAdapter;
import com.infobite.technology.utils.BaseActivity;

public class VendorProfileActivty extends BaseActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ProfileFragmentViewpagerAdapter profileviewpageradapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_vendor_profile_activity);
        init();
    }

    private void init() {
        viewPager = findViewById(R.id.vendor_profile_viewpager);
        tabLayout = findViewById(R.id.vendor_profile_tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("Profile Details"));
        tabLayout.addTab(tabLayout.newTab().setText("About"));
        tabLayout.addTab(tabLayout.newTab().setText("Change Password"));
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        profileviewpageradapter = new ProfileFragmentViewpagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount()); //, tabLayout.getTabCount()
        viewPager.setAdapter(profileviewpageradapter);

        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener());
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener<TabLayout.Tab>() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
}
