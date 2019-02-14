package com.infobite.technology.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.infobite.technology.R;
import com.infobite.technology.modal.TwoVariableList;
import com.infobite.technology.ui.activity.HomeFragmentActivity;

import java.util.List;

public class HomeFragmentAdapter extends RecyclerView.Adapter<HomeFragmentAdapter.ViewHolder> {
    private Context contex;
    private List<TwoVariableList> homeOfficeArrayList;
    private View.OnClickListener onClickListener;

    public HomeFragmentAdapter(Context contex, List<TwoVariableList> homeOfficeArrayList, View.OnClickListener onClickListener) {
        this.contex = contex;
        this.homeOfficeArrayList = homeOfficeArrayList;
        this.onClickListener = onClickListener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater li = LayoutInflater.from(contex);
        View view = li.inflate( R.layout.layout_home_rclv1,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        TwoVariableList homeofficearraylist = homeOfficeArrayList.get(i);
        viewHolder.image.setImageDrawable(contex.getResources().getDrawable(homeofficearraylist.getImage()));
        viewHolder.text.setText(homeofficearraylist.getName());
        viewHolder.requstButton.setTag(i);
        viewHolder.requstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(contex, HomeFragmentActivity.class);
                contex.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return homeOfficeArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView image;
        private TextView text;
        private Button requstButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.iv_image);
            text = itemView.findViewById(R.id.tv_name);
            requstButton = itemView.findViewById(R.id.btn_request);
            requstButton = itemView.findViewById(R.id.btn_request);

        }
    }
}
