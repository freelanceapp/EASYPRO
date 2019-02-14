package com.infobite.technology.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.infobite.technology.R;
import com.infobite.technology.ui.activity.LoginSignUpActivity;
import com.infobite.technology.utils.BaseFragment;

public class ForgotPasswordFragment extends BaseFragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_forgot_password, container, false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.password_change:
                new LoginSignUpActivity()
                        .replaceLoginFragment();
                break;

        }
    }
}
