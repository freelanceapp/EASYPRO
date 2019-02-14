package com.infobite.technology.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.infobite.technology.R;
import com.infobite.technology.constant.Constant;
import com.infobite.technology.ui.fragment.ForgotPasswordFragment;
import com.infobite.technology.ui.fragment.LoginFragment;
import com.infobite.technology.ui.fragment.SignUpFragment;
import com.infobite.technology.utils.BaseActivity;

public class LoginSignUpActivity extends BaseActivity implements View.OnClickListener {
    public static LoginSignUpActivity mainActivity;
    public static  FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sign_up);
        mainActivity = this;
        fragmentManager =   getSupportFragmentManager();
        if (savedInstanceState == null){
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container,new LoginFragment()
                    , Constant.Login_fragment).commit();
        }
    }
    public void replaceLoginFragment() {
        fragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.left_enter, R.anim.right_out)
                .replace(R.id.frame_container, new LoginFragment(),
                        Constant.Login_fragment).commit();
    }
    @Override
    public void onBackPressed() {

        Fragment SignUp_Fragment = fragmentManager.findFragmentByTag(Constant.SignUp_Fragment);
        Fragment Login_Password = fragmentManager.findFragmentByTag(Constant.Login_fragment);
        Fragment ForgotPassword_Fragment = fragmentManager.findFragmentByTag(Constant.Forgot_Password);

        if (SignUp_Fragment != null)
            replaceLoginFragment();
        else if (Login_Password != null)
            replaceLoginFragment();
        else if (ForgotPassword_Fragment != null)
            replaceLoginFragment();
        else
            super.onBackPressed();
    }
    @Override
    public void onClick(View v) {
        finish();
    }
}
