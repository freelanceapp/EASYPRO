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

public class ProfileFragment extends BaseFragment implements View.OnClickListener{
    private View rootview;
    private LinearLayout profiledetails,changepassword;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.layout_profile_fragment,null);
        init();
        return rootview;
    }
    private void init(){
        mContext = getActivity();
        profiledetails = rootview.findViewById(R.id.ll_profile_details);
        changepassword = rootview.findViewById(R.id.ll_change_password);


        profiledetails.setOnClickListener(this);
        changepassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_profile_details:
                ((View) rootview.findViewById(R.id.view_profile_details)).setVisibility(View.VISIBLE);
                ((View) rootview.findViewById(R.id.ll_profile_details_opern)).setVisibility(View.VISIBLE);
                ((TextView) rootview.findViewById(R.id.tv_profile_details)).setTextColor(getResources().getColor(R.color.white));
                ((View) rootview.findViewById(R.id.view_change_password)).setVisibility(View.GONE);
                ((View) rootview.findViewById(R.id.ll_change_password_open)).setVisibility(View.GONE);
                ((TextView) rootview.findViewById(R.id.tv_change_password)).setTextColor(getResources().getColor(R.color.gray_f));
                ((Button) rootview.findViewById(R.id.btn_save_password)).setVisibility(View.GONE);
                break;
            case R.id.ll_change_password:
                ((View) rootview.findViewById(R.id.view_change_password)).setVisibility(View.VISIBLE);
                ((View) rootview.findViewById(R.id.ll_change_password_open)).setVisibility(View.VISIBLE);
                ((TextView) rootview.findViewById(R.id.tv_change_password)).setTextColor(getResources().getColor(R.color.white));
                ((View) rootview.findViewById(R.id.view_profile_details)).setVisibility(View.GONE);
                ((View) rootview.findViewById(R.id.ll_profile_details_opern)).setVisibility(View.GONE);
                ((TextView) rootview.findViewById(R.id.tv_profile_details)).setTextColor(getResources().getColor(R.color.gray_f));
                ((Button) rootview.findViewById(R.id.btn_save_password)).setVisibility(View.VISIBLE);
                break;
        }
    }
}
