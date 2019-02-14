package com.infobite.technology.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.infobite.technology.R;
import com.infobite.technology.adapter.VendorRequestFragmentAdapter;
import com.infobite.technology.constant.Constant;
import com.infobite.technology.modal.ThreeVariableList;
import com.infobite.technology.ui.activity.CreateQuoteActivity;
import com.infobite.technology.utils.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class VendorQuationFragment extends BaseFragment implements View.OnClickListener{
    private VendorRequestFragmentAdapter vendorRequestFragmentAdapter;
    private RecyclerView quotesrclv;
    private View rootview;
    private List<ThreeVariableList> quotesList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_quoates_layout,null);
        init();
        return rootview;
    }

    private void init() {
        mContext = getActivity();
        quotesrclv = rootview.findViewById(R.id.rclv_vendor_quotes_fr);
        rootview.findViewById(R.id.btn_send_quote).setOnClickListener(this);
        rootview.findViewById(R.id.btn_cancel_quote).setOnClickListener(this);

        quotesrclv.setHasFixedSize(true);
        quotesrclv.setLayoutManager(new LinearLayoutManager(mContext));

        vendorRequestFragmentAdapter = new VendorRequestFragmentAdapter(mContext,quotesList);
        LinearLayoutManager lm1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        quotesrclv.setLayoutManager(lm1);
        quotesrclv.setItemAnimator(new DefaultItemAnimator());
        quotesrclv.setAdapter(vendorRequestFragmentAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_send_quote:
                Intent intent = new Intent(mContext, CreateQuoteActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_cancel_quote:
                getActivity().finish();
        }

    }
}
