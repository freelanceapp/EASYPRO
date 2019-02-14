package com.infobite.technology.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.infobite.technology.R;
import com.infobite.technology.modal.ThreeVariableList;

import java.util.List;

public class VendorRequestFragmentAdapter extends RecyclerView.Adapter<VendorRequestFragmentAdapter.ViewHolder> {
    private View rootview;
    private Context context;
    private List<ThreeVariableList> requestList;

    public VendorRequestFragmentAdapter(Context context, List<ThreeVariableList> requestList) {
        this.context = context;
        this.requestList = requestList;
    }

    @NonNull
    @Override
    public VendorRequestFragmentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater li = LayoutInflater.from(context);
        rootview = li.inflate(R.layout.layout_vendor_request_rclv,null);
        return new ViewHolder(rootview);
    }

    @Override
    public void onBindViewHolder(@NonNull VendorRequestFragmentAdapter.ViewHolder viewHOlder, int i) {
        ThreeVariableList requsetlist = requestList.get(i);
    }

    @Override
    public int getItemCount() {
        return requestList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
