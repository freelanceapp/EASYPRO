package com.infobite.technology.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.infobite.technology.R;
import com.infobite.technology.adapter.VendorRequestFragmentAdapter;
import com.infobite.technology.modal.ThreeVariableList;
import com.infobite.technology.utils.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class VendorRequestFragment extends BaseFragment {
    private VendorRequestFragmentAdapter vendorRequestFragmentAdapter;
    private List<ThreeVariableList> vendorrequestList = new ArrayList<>();
    RecyclerView requsetrclv;
    View rootview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_vendor_request,null);
        init();
        return rootview;
    }

    private void init() {
        mContext = getActivity();
        requsetrclv = rootview.findViewById(R.id.rclv_vendor_rq_fr);

        requsetrclv.setHasFixedSize(true);
        requsetrclv.setLayoutManager(new LinearLayoutManager(mContext));

        vendorRequestFragmentAdapter = new VendorRequestFragmentAdapter(mContext,vendorrequestList);
        LinearLayoutManager lm1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        requsetrclv.setLayoutManager(lm1);
        requsetrclv.setItemAnimator(new DefaultItemAnimator());
        requsetrclv.setAdapter(vendorRequestFragmentAdapter);
    }
}
