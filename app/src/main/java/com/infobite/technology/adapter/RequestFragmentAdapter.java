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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.infobite.technology.R;
import com.infobite.technology.constant.Constant;
import com.infobite.technology.modal.ThreeVariableList;
import com.infobite.technology.ui.activity.HomeOfficeRenovationActivity;
import com.infobite.technology.ui.fragment.HomeOfficeRenovation;


import java.util.List;

import static com.infobite.technology.ui.activity.LoginSignUpActivity.fragmentManager;

public class RequestFragmentAdapter extends RecyclerView.Adapter<RequestFragmentAdapter.ViewHOlder>{
    private Context context;
    private List<ThreeVariableList> requstquaotesList;

    public RequestFragmentAdapter(Context context,List<ThreeVariableList> requstquaoteslist) {
        this.context = context;
        this.requstquaotesList = requstquaoteslist;
    }

    @NonNull
    @Override
    public ViewHOlder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater li = LayoutInflater.from(context);
        View rootview = li.inflate(R.layout.layout_request_rclv,null);
        return new ViewHOlder(rootview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHOlder viewHOlder, int i) {
        ThreeVariableList requstquaoteslist = requstquaotesList.get(i);
        viewHOlder.image.setImageDrawable(context.getResources().getDrawable(requstquaoteslist.getImage()));
        viewHOlder.categery.setText(requstquaoteslist.getCategry());
        viewHOlder.btnquotes.setText(requstquaoteslist.getQuotes());
        viewHOlder.requestedquotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, HomeOfficeRenovationActivity.class);
                context.startActivity(intent);
                   /* fragmentManager
                            .beginTransaction()
                            .replace(R.id.frame_container, new HomeOfficeRenovation(),
                                    Constant.HOMEOFFICERENOVATION).commit();*/
            }
        });
    }

    @Override
    public int getItemCount() {
        return requstquaotesList.size();
    }

    public  class ViewHOlder extends RecyclerView.ViewHolder{
        private ImageView image;
        private TextView categery;
        private Button btnquotes;
        private LinearLayout requestedquotes;

        public ViewHOlder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.iv_image_quote);
            categery = itemView.findViewById(R.id.tv_categery_quote);
            btnquotes = itemView.findViewById(R.id.btn_requested_quote);
            requestedquotes = itemView.findViewById(R.id.requsted_quote_onclick);

        }

    }
}
