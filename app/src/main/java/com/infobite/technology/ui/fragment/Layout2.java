package com.infobite.technology.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.infobite.technology.R;
import com.infobite.technology.utils.BaseFragment;

public class Layout2 extends BaseFragment {
    private View rootview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         rootview = inflater.inflate(R.layout.layout_gift2,null);
         return rootview;
    }
}
