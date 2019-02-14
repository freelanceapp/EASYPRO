package com.infobite.technology.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.infobite.technology.R;
import com.infobite.technology.constant.Constant;
import com.infobite.technology.ui.activity.LoginSignUpActivity;
import com.infobite.technology.utils.BaseFragment;

import static com.infobite.technology.ui.activity.LoginSignUpActivity.fragmentManager;

public class SignUpFragment extends BaseFragment implements View.OnClickListener {
    private View rootview;
    private Boolean check = false;
    private TextView vendorsignup, customersignup;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_sign_up, container, false);

        init();
        return rootview;
    }

    private void init() {
        mContext = getActivity();
        vendorsignup = rootview.findViewById(R.id.tv_vendor_sign);
        customersignup = rootview.findViewById(R.id.tv_customer_sign);

        rootview.findViewById(R.id.tv_vendor_sign).setOnClickListener(this);
        rootview.findViewById(R.id.tv_customer_sign).setOnClickListener(this);
        rootview.findViewById(R.id.tv_loginpage).setOnClickListener(this
        );
    }
    private void setFragment(String tag, Fragment fragment){
        fragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.right_enter, R.anim.left_out)
                .replace(R.id.frame_container, fragment, tag).commit();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_vendor_sign:
                vendorsignup.setBackground(mContext.getResources().getDrawable(R.drawable.textview_back_a));
                vendorsignup.setTextColor(getResources().getColor(R.color.white));
                customersignup.setBackground(mContext.getResources().getDrawable(R.drawable.textview_back_b));
                customersignup.setTextColor(getResources().getColor(R.color.gray_f));
                break;
            case R.id.tv_customer_sign:
                customersignup.setBackground(mContext.getResources().getDrawable(R.drawable.textview_back_a));
                customersignup.setTextColor(getResources().getColor(R.color.white));
                vendorsignup.setBackground(mContext.getResources().getDrawable(R.drawable.textview_back_b));
                vendorsignup.setTextColor(getResources().getColor(R.color.gray_f));
                break;
            case R.id.btn_signup:
                break;
            case R.id.tv_loginpage:
                setFragment(Constant.Login_fragment,new LoginFragment());

                break;
            case R.id.btn_fb:
                break;
        }
    }
}
