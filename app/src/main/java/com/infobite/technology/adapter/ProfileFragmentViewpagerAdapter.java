package com.infobite.technology.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.infobite.technology.ui.fragment.VendorAboutFragment;
import com.infobite.technology.ui.fragment.VendorChangePassFragment;
import com.infobite.technology.ui.fragment.VendorProfileDetailsFragment;

public class ProfileFragmentViewpagerAdapter extends FragmentPagerAdapter {

    private int tabCount;
    public ProfileFragmentViewpagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;

    }
    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                return new VendorProfileDetailsFragment();
            case 1:
                return new VendorAboutFragment();
            case 2:
                return new VendorChangePassFragment();
                default:
                    return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
