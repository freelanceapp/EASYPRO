package com.infobite.technology.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.infobite.technology.R;
import com.infobite.technology.utils.BaseFragment;

public class VendorProfileFragment extends BaseFragment implements View.OnClickListener{
    private View rootview;
    private LinearLayout profiledetails,changepassword;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.layout_vendor_profile_fragment,null);
        init();
        return rootview;
    }
    private void init(){
        mContext = getActivity();

        ((LinearLayout)rootview.findViewById(R.id.ll_ven_profile)).setOnClickListener(this);
        ((LinearLayout)rootview.findViewById(R.id.ll_ven_about)).setOnClickListener(this);
        ((LinearLayout)rootview.findViewById(R.id.ll_ven_chan_pass)).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_ven_profile:
                ((View) rootview.findViewById(R.id.view_ven_profile)).setVisibility(View.VISIBLE);
                ((LinearLayout) rootview.findViewById(R.id.ll_vendor_profile_open)).setVisibility(View.VISIBLE);
                ((TextView) rootview.findViewById(R.id.tv_ven_profile)).setTextColor(getResources().getColor(R.color.white));
                ((View) rootview.findViewById(R.id.view_vend_chan_pass)).setVisibility(View.GONE);
                ((LinearLayout) rootview.findViewById(R.id.ll_vendor_change_pass_open)).setVisibility(View.GONE);
                ((TextView) rootview.findViewById(R.id.tv_ven_chan_pass)).setTextColor(getResources().getColor(R.color.gray_f));
                ((View) rootview.findViewById(R.id.view_ven_about)).setVisibility(View.GONE);
                ((LinearLayout) rootview.findViewById(R.id.ll_vendor_about_open)).setVisibility(View.GONE);
                ((TextView) rootview.findViewById(R.id.tv_ven_about)).setTextColor(getResources().getColor(R.color.gray_f));
              //  ((Button) rootview.findViewById(R.id.btn_save_password)).setVisibility(View.GONE);
                break;
            case R.id.ll_ven_about:
                ((View) rootview.findViewById(R.id.view_ven_about)).setVisibility(View.VISIBLE);
                ((LinearLayout) rootview.findViewById(R.id.ll_vendor_about_open)).setVisibility(View.VISIBLE);
                ((TextView) rootview.findViewById(R.id.tv_ven_about)).setTextColor(getResources().getColor(R.color.white));
                ((View) rootview.findViewById(R.id.view_vend_chan_pass)).setVisibility(View.GONE);
                ((LinearLayout) rootview.findViewById(R.id.ll_vendor_change_pass_open)).setVisibility(View.GONE);
                ((TextView) rootview.findViewById(R.id.tv_ven_chan_pass)).setTextColor(getResources().getColor(R.color.gray_f));
                ((View) rootview.findViewById(R.id.view_ven_profile)).setVisibility(View.GONE);
                ((LinearLayout) rootview.findViewById(R.id.ll_vendor_profile_open)).setVisibility(View.GONE);
                ((TextView) rootview.findViewById(R.id.tv_ven_profile)).setTextColor(getResources().getColor(R.color.gray_f));
             //   ((Button) rootview.findViewById(R.id.btn_save_password)).setVisibility(View.GONE);
                break;
            case R.id.ll_ven_chan_pass:
                ((View) rootview.findViewById(R.id.view_vend_chan_pass)).setVisibility(View.VISIBLE);
                ((LinearLayout) rootview.findViewById(R.id.ll_vendor_change_pass_open)).setVisibility(View.VISIBLE);
                ((TextView) rootview.findViewById(R.id.tv_ven_chan_pass)).setTextColor(getResources().getColor(R.color.white));
                ((View) rootview.findViewById(R.id.view_ven_profile)).setVisibility(View.GONE);
                ((LinearLayout) rootview.findViewById(R.id.ll_vendor_profile_open)).setVisibility(View.GONE);
                ((TextView) rootview.findViewById(R.id.tv_ven_profile)).setTextColor(getResources().getColor(R.color.gray_f));
                ((View) rootview.findViewById(R.id.view_ven_about)).setVisibility(View.GONE);
                ((LinearLayout) rootview.findViewById(R.id.ll_vendor_about_open)).setVisibility(View.GONE);
                ((TextView) rootview.findViewById(R.id.tv_ven_about)).setTextColor(getResources().getColor(R.color.gray_f));
             //   ((Button) rootview.findViewById(R.id.btn_save_password)).setVisibility(View.GONE);
                break;
        }
    }
}
