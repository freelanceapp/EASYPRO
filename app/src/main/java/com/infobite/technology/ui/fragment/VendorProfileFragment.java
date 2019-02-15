package com.infobite.technology.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.infobite.technology.R;
import com.infobite.technology.adapter.ProfileFragmentViewpagerAdapter;
import com.infobite.technology.utils.BaseActivity;
import com.infobite.technology.utils.BaseFragment;

public class VendorProfileFragment extends BaseFragment {
    private View rootview;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ProfileFragmentViewpagerAdapter profileviewpageradapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.layout_vendor_profile_fragment, null);
        init();
        return rootview;
    }

    private void init() {
        mContext = getActivity();

        viewPager = rootview.findViewById(R.id.vendor_profile_viewpager);
        tabLayout = rootview.findViewById(R.id.vendor_profile_tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("Profile Details"));
        tabLayout.addTab(tabLayout.newTab().setText("About"));
        tabLayout.addTab(tabLayout.newTab().setText("Change Password"));
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        viewPager.getAdapter();
        profileviewpageradapter = new ProfileFragmentViewpagerAdapter(getFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(profileviewpageradapter);

       viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
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
