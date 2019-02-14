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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.infobite.technology.R;
import com.infobite.technology.modal.MessageFragmentModal;
import com.infobite.technology.modal.ThreeVariableList;
import com.infobite.technology.ui.activity.MessageActivity;

import java.util.List;
import java.util.concurrent.TimeoutException;

public class MessagerFragmentAdapter extends RecyclerView.Adapter<MessagerFragmentAdapter.ViewHolder> {
    private Context context;
    private List<MessageFragmentModal> messageFragmentArraylist;
    private View.OnClickListener onClickListener;

    public MessagerFragmentAdapter(Context context,List<MessageFragmentModal> messageFragmentModals,View.OnClickListener onClickListener) {
        this.context = context;
        this.messageFragmentArraylist = messageFragmentModals;
        this.onClickListener = onClickListener;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater li = LayoutInflater.from(context);
        View rootview = li.inflate(R.layout.layout_message_rclv,null);
        return new ViewHolder(rootview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        MessageFragmentModal messageArraylist = messageFragmentArraylist.get(i);
        viewHolder.image.setImageDrawable(context.getResources().getDrawable(messageArraylist.getImage()));
        viewHolder.categery.setText(messageArraylist.getName());
        viewHolder.datetime.setText(messageArraylist.getDatetime());
      /*  viewHolder.btnquotes.setTag(i);
        viewHolder.btnquotes.setOnClickListener(onClickListener);*/
    }

    @Override
    public int getItemCount() {
        return messageFragmentArraylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView categery,datetime;
        private RelativeLayout onclickMessageBox;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.iv_profile_person);
            categery = itemView.findViewById(R.id.tv_person_name);
            datetime = itemView.findViewById(R.id.tv_date_time);
            onclickMessageBox = itemView.findViewById(R.id.rl_message_onclick);

            onclickMessageBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, MessageActivity.class);
                    context.startActivity(intent);
                }
            });

        }
    }
}
