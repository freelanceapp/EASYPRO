package com.infobite.technology.ui.activity;

import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.infobite.technology.R;
import com.infobite.technology.constant.Constant;
import com.infobite.technology.menu.DrawerAdapter;
import com.infobite.technology.menu.DrawerItem;
import com.infobite.technology.menu.SimpleItem;
import com.infobite.technology.ui.fragment.BuyCreditsFragment;
import com.infobite.technology.ui.fragment.HomeFragment;
import com.infobite.technology.ui.fragment.MessagesFragment;
import com.infobite.technology.ui.fragment.ProfileFragment;
import com.infobite.technology.ui.fragment.QuotesFragment;
import com.infobite.technology.ui.fragment.RequstesFragment;
import com.infobite.technology.ui.fragment.SettingsFragment;
import com.infobite.technology.ui.fragment.TransactionsFragment;
import com.infobite.technology.ui.fragment.VendorProfileFragment;
import com.infobite.technology.ui.fragment.VendorQuationFragment;
import com.infobite.technology.ui.fragment.VendorRequestFragment;
import com.infobite.technology.utils.BaseActivity;
import com.infobite.technology.utils.Utility;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.util.Arrays;

public class MainActivity extends BaseActivity implements DrawerAdapter.OnItemSelectedListener{

    private SlidingRootNav slidingRootNav;
    private static final int NAVall = 0;
    private static final int NAVprofile = 1;
    private static final int NAVRequstes = 2;
    private static final int NAVQuotes = 3;
    private static final int NAVmessages = 4;
    private static final int NAvbuycredits = 5;
    private static final int NAVTransactions = 6;
    private static final int NAVsettings = 7;

    private TextView toolbartitile;
    private String[] screenTitles;
   // private Drawable[] screenIcons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initXmal(savedInstanceState);
    }
        private void initXmal(Bundle savedInstanceState) {
            mContext = this;
            toolbartitile = findViewById(R.id.tool_title);
            android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            //screenIcons = loadScreenIcons();
            screenTitles = loadScreenTitles();

            slidingRootNav = (SlidingRootNav) new SlidingRootNavBuilder(this)
                    .withToolbarMenuToggle(toolbar)
                    .withMenuOpened(false)
                    .withContentClickableWhenMenuOpened(true)
                    .withSavedState(savedInstanceState)
                    .withMenuLayout(R.layout.navigation_menu_list)
                    .inject();

            DrawerAdapter drawadapter = new DrawerAdapter(Arrays.asList(
                    createItemFor(NAVall).setChecked(true),
                    createItemFor(NAVprofile),
                    createItemFor(NAVRequstes),
                    createItemFor(NAVQuotes),
                    createItemFor(NAVmessages),
                   createItemFor(NAvbuycredits),
                    createItemFor(NAVTransactions),
                    createItemFor(NAVsettings)));
                    drawadapter.setListener(this);

            RecyclerView list = findViewById(R.id.menu_list);
            list.setNestedScrollingEnabled(false);
            list.setLayoutManager(new LinearLayoutManager(this));
            list.setAdapter(drawadapter);
            drawadapter.setSelected(NAVall);
        }

        private DrawerItem createItemFor(int position) {
            return new SimpleItem(screenTitles[position])                 //  screenIcons[position],
                   // .withIconTint(color(R.color.black))
                    .withTextTint(color(R.color.white))
                    .withSelectedTextTint(color(R.color.black));
        }

        @ColorInt
        private int color(@ColorRes int res) {
            return ContextCompat.getColor(this, res);
        }

        private String[] loadScreenTitles() {

            return getResources().getStringArray(R.array.icontitles);
        }

     /*   private Drawable[] loadScreenIcons() {
            TypedArray ta = getResources().obtainTypedArray(R.array.icons);
            Drawable[] icons = new Drawable[ta.length()];
            for (int i = 0; i < ta.length(); i++) {
                int id = ta.getResourceId(i, 0);
                if (id != 0) {
                    icons[i] = ContextCompat.getDrawable(this, id);
                }
            }
            ta.recycle();
            return icons;
        }*/

        @Override
        public void onBackPressed() {
            if (slidingRootNav.isMenuOpened()) {
                slidingRootNav.closeMenu();
            } else {
                FragmentManager fm = getSupportFragmentManager();
                Fragment fragment_byID = fm.findFragmentById(R.id.home_contents);
                String tag = fragment_byID.getTag();
                if (!tag.equals(Constant.HOME)) {
                    HomeFragment homeFragment = new HomeFragment();
                    Utility.setFragment(homeFragment, mContext, Constant.HOME);
                } else {
                    finish();
                }
            }
        }
        public void onItemSelected(int position) {
            if (position == NAVall) {
                toolbartitile.setText(Constant.HOME);
                HomeFragment homeFragment = new HomeFragment();
                Utility.setFragment(homeFragment, mContext, Constant.HOME);
                slidingRootNav.closeMenu();
            } else if (position == NAVprofile) {
                toolbartitile.setText(Constant.VENDORPROFILE);
                VendorProfileFragment fragment = new VendorProfileFragment();
                Utility.setFragment(fragment, mContext, Constant.VENDORPROFILE);
                slidingRootNav.closeMenu();
            } else if (position == NAVRequstes) {
                toolbartitile.setText(Constant.VENDORREQUEST);
                VendorRequestFragment fragment = new VendorRequestFragment();
                Utility.setFragment(fragment, mContext, Constant.VENDORREQUEST);
                slidingRootNav.closeMenu();
            } else if (position == NAVQuotes) {
                toolbartitile.setText(Constant.VENDORQUOTATION);
                VendorQuationFragment fragment = new VendorQuationFragment();
                Utility.setFragment(fragment, mContext, Constant.VENDORQUOTATION);
                slidingRootNav.closeMenu();
            } else if (position == NAVmessages) {
                toolbartitile.setText(Constant.VENDORMESSAGES);
                MessagesFragment fragment = new MessagesFragment();
                Utility.setFragment(fragment, mContext, Constant.VENDORMESSAGES);
                slidingRootNav.closeMenu();
            } else if (position == NAvbuycredits) {
                toolbartitile.setText(Constant.VBUYCREDITS);
                BuyCreditsFragment fragment = new BuyCreditsFragment();
                Utility.setFragment(fragment, mContext, Constant.VBUYCREDITS);
                slidingRootNav.closeMenu();
            } else if (position == NAVTransactions) {
                toolbartitile.setText(Constant.VTRANSACTIONS);
                TransactionsFragment fragment = new TransactionsFragment();
                Utility.setFragment(fragment, mContext, Constant.VTRANSACTIONS);
                slidingRootNav.closeMenu();
            } else if (position == NAVsettings) {
                toolbartitile.setText(Constant.VSETTINGS);
                SettingsFragment fragment = new SettingsFragment();
                Utility.setFragment(fragment, mContext, Constant.VSETTINGS);
                slidingRootNav.closeMenu();
            }
        /*    toolbartitile.setText(ConstantData.HOME);
            BookingFragment fragment = new BookingFragment();
            Utility.setFragment(fragment, context, ConstantData.HOME);*/
                slidingRootNav.closeMenu();
    }
}
