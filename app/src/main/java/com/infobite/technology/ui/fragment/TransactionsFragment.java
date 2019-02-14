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
import com.infobite.technology.adapter.TransactionAdapter;
import com.infobite.technology.modal.TransactionModal;
import com.infobite.technology.utils.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class TransactionsFragment extends BaseFragment {
    private List<TransactionModal> transactionModalsList = new ArrayList<>();
    private TransactionAdapter transactionAdapter;
    private View rootview;
    private RecyclerView transactionrclv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_transaction_layout, null);
        init();
        return rootview;
    }

    private void init() {
        mContext = getActivity();
        transactionrclv = rootview.findViewById(R.id.rclv_transaction);
        transactionrclv.setHasFixedSize(true);
        transactionrclv.setLayoutManager(new LinearLayoutManager(mContext));

        transactionModalsList.add(new TransactionModal("223", "01-02-2019", "monthly",
                "Easy Paisa", R.drawable.ic_eye));

        transactionAdapter= new TransactionAdapter(mContext,transactionModalsList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        transactionrclv.setLayoutManager(layoutManager);
        transactionrclv.setItemAnimator(new DefaultItemAnimator());
        transactionrclv.setAdapter(transactionAdapter);
    }
}
