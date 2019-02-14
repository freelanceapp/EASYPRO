package com.infobite.technology.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.infobite.technology.R;
import com.infobite.technology.constant.Constant;
import com.infobite.technology.ui.activity.MainActivity;
import com.infobite.technology.utils.BaseFragment;

import static com.infobite.technology.ui.activity.LoginSignUpActivity.fragmentManager;

public class LoginFragment extends BaseFragment implements View.OnClickListener {
    private View rootview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         rootview = inflater.inflate(R.layout.fragment_login, container, false);
          init();
        return rootview;
    }

    private void init() {

        mContext = getActivity();
        rootview.findViewById(R.id.btn_login).setOnClickListener(this);
        rootview.findViewById(R.id.cv_fb_login).setOnClickListener(this);
        rootview.findViewById(R.id.tv_forgot_password).setOnClickListener(this);
        rootview.findViewById(R.id.tv_signup).setOnClickListener(this);
    }

    private void startFragment(String tag, Fragment fragment){
        fragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.right_enter, R.anim.left_out)
                .replace(R.id.frame_container, fragment, tag).commit();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                Intent intent = new Intent(mContext, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_forgot_password:
                startFragment(Constant.Forgot_Password,new ForgotPasswordFragment());
                break;
            case R.id.tv_signup:
                startFragment(Constant.SignUp_Fragment,new SignUpFragment());
                break;
            case R.id.cv_fb_login:
                break;
        }

    }
}
